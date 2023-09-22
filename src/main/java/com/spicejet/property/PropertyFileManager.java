package com.spicejet.property;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileManager {
	
/*	This class is used to create a property file and also get the stored values.
 *	PropertyKey Enum file created for store the property keys.
 *		
 *	constructor is used to load the property file.
 *
 *	using PropertyKey Enum keys and getValue() method we can get the values
 */
	
	static Properties property;
	
	// this method is used for load the property file on Properties class
	public PropertyFileManager() {
		try {

			String path = System.getProperty("user.dir") + "\\Property\\Spicejet.properties";

			FileInputStream input = new FileInputStream(new File(path));

			property = new Properties();

			property.load(input);

		} catch (Exception ex) {
			
			System.out.println("problem on loading the property file");
			
			ex.printStackTrace();
		}
	}
	
	// return URL value from property file as a String
	public String getURL() {
		
		try { return property.getProperty("URL"); }catch(Exception ex) {
			
			System.out.println("problem on getting URL form the property file");
			
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public String getValue(String key) {
		
		String value = null;
		
		try { value = property.getProperty(key); }catch(Exception ex) {
			
			System.out.println("problem on getting from property file");
			
			ex.printStackTrace();
		}
		
		return value;
	}
}
