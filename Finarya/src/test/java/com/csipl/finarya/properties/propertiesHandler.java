package com.csipl.finarya.properties;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class propertiesHandler {
	public Properties p = new Properties();

	public void loadProperties(String fileName) {
		InputStream iStream = null;
		try {
			// Loading properties file from the classpath
			iStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
			if (iStream == null) {
				throw new IOException("File not found");
			}
			p.load(iStream);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (iStream != null) {
					iStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String readProperties(String element) {
		return p.getProperty(element).toString();
	}

}
