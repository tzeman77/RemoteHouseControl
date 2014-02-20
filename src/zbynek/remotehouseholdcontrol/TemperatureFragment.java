package zbynek.remotehouseholdcontrol;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import zbynek.remotehouseholdcontrol.nettools.ConnectionCredentialsManager;
import zbynek.remotehouseholdcontrol.nettools.StatusesXmlParser;
import zbynek.remotehouseholdcontrol.nettools.UrlReader;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

public class TemperatureFragment extends Fragment {

	private static final String XML_STATES_FILE = "stavsenzoru.xml";

	private TableLayout table;
	private LayoutInflater inflater;

	@Override
	public View onCreateView(LayoutInflater i, ViewGroup container,
	  Bundle savedInstanceState) {
	  View v = i.inflate(R.layout.table, container, false);
	  table = (TableLayout)v.findViewById(R.id.table);
	  inflater = i;
	  return v;
	}

	@Override
	public void onResume() {
		super.onResume();
		displayActualState();
	}

	private void displayActualState() {
		String url = constructUrl();
		new DownloadStatesTask().execute(url);
	}

	private String constructUrl() {
		ConnectionCredentialsManager cm = new ConnectionCredentialsManager(
		  getActivity());
		return cm.constructUrl(XML_STATES_FILE);
	}

	private class DownloadStatesTask extends
	  AsyncTask<String, Void, SimpleArrayMap<String, String>> {

		@Override
		protected SimpleArrayMap<String, String> doInBackground(String... args) {
			String url = args[0];
			try {
				ConnectionCredentialsManager cm = new ConnectionCredentialsManager(
				 getActivity());
				String xml = UrlReader.readOutputFromUrl(cm, url);
				return StatusesXmlParser.parseXml(xml);
			} catch (IOException e) {
			  SimpleArrayMap<String, String> m = new SimpleArrayMap<String, String>();
			  m.put("Error", "Neprectu XML.\n Zkontrolujte pripojeni a nastaveni.");
			  return m;
			} catch (XmlPullParserException e) {
			  SimpleArrayMap<String, String> m = new SimpleArrayMap<String, String>();
			  m.put("Error", "Chyba pri parsovani odpovedi serveru.");
			  return m;
			}
		}

		@Override
		protected void onPostExecute(SimpleArrayMap<String, String> m) {
		  for (int i = 0; i < m.size(); i++) {
		    View r = inflater.inflate(R.layout.table_row_kv, null); 
		    ((TextView)r.findViewById(R.id.row_key)).setText(m.keyAt(i));
		    ((TextView)r.findViewById(R.id.row_val)).setText(m.valueAt(i));
		    table.addView(r);
		  }

			//table.setTextColor(-16711681);
			table.setBackgroundColor(-7829368);
			//table.setTextSize(15);
		}


	}	
}