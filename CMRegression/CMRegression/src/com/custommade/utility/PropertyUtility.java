package com.custommade.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author anokh ClassName: PropertyUtility Description: This class is for
 *         reading the property values written inside config.properties file
 */
public class PropertyUtility {

	public static final String FILE_CONFIG = "config.properties";

	/*
	 * Method Name: getProperty() Description: This function returns a property
	 * value when the property name is passed as parameter
	 */
	public static String getProperty(String propertyName) {
		Properties prop = new Properties();
		String propertyValue = null;
		try {
			prop.load(new FileInputStream(FILE_CONFIG));
			propertyValue = prop.getProperty(propertyName);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return propertyValue;
	}
	
	//suraj on 14/3
	public static void setPropertyValue (String propertyName, String propertyValue) throws FileNotFoundException, IOException{
		Properties prop = new Properties();
		prop.load(new FileInputStream(FILE_CONFIG));
		prop.setProperty(propertyName, propertyValue);
		prop.store(new FileOutputStream("config.properties"), null);
	}
	//suraj on 14/3
}
