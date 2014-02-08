package zbynek.remotehouseholdcontrol.nettools;

import java.io.IOException;


public class CgiScriptCaller {

	
	ConnectionCredentialsManager cm;
	String scriptName;
	
	public CgiScriptCaller(ConnectionCredentialsManager cm, String scriptName) {
		this.cm = cm;
		this.scriptName = scriptName;
	}
	
	/**
	 * Calls a CGI script and returns true if it finished successfully (returns "0")
	 * @param setOn set the script to ON or OFF status.
	 */
	public boolean callCGIScriptAndSetValue(boolean setOn) throws IOException {
		String value = setOn ? "on" : "off";
		String urlString = cm.constructUrl(scriptName) + "?value=" + value;	
		String scriptOutput = UrlReader.readOutputFromUrl(cm, urlString);
		return "OK".equals(scriptOutput.trim());
	}
	
	/**
	 * Calls a CGI script and returns actual status - ON (true) / OFF (false)
	 */
	public boolean callCGIScriptAndGetStatus() throws IOException {
		String urlString = cm.constructUrl(scriptName) + "?value=status";	
		String scriptOutput = UrlReader.readOutputFromUrl(cm, urlString);
		if ("1".equals(scriptOutput.trim())) {
			return true;
		} else if ("0".equals(scriptOutput.trim())) {
			return false;
		} else {
			throw new IOException("Script returned an invalid status.");
		}
	}

}
