package zbynek.remotehouseholdcontrol.nettools;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedHashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class StatusesXmlParser {

	private static final String DATA_TAG = "DATA";

	public static LinkedHashMap<String, String> parseStatusesFromXml(String xmlString) throws XmlPullParserException, IOException {
		LinkedHashMap<String, String> resultMap = new LinkedHashMap<String, String>();
		
		//TODO - validate according to some DTD or XSD
		
		//parse
		XmlPullParser parser = Xml.newPullParser();
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        parser.setInput(new StringReader(xmlString));
        parser.nextTag();
        parser.require(XmlPullParser.START_TAG, null, DATA_TAG);
        while (!(parser.next() == XmlPullParser.END_TAG 
				&& DATA_TAG.equals(parser.getName()))) {
			
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String elementName = parser.getName();
			parser.next();
			String value = parser.getText();
			resultMap.put(elementName, value);
		}            
        
		return resultMap;
	}	
}
