package com.ui.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.constants.Environment;

public class PropertiesUtil {
	public static String readProperty(Environment env,String propertyName) {
	
	File file=new File(System.getProperty("user.dir")+"\\config\\" + env + ".properties");
	
	FileReader reader = null;
	Properties prop=new Properties();
	try {
		reader = new FileReader(file);
		prop.load(reader);
	} 
	catch (IOException e) {
		
		e.printStackTrace();
	}
	return prop.getProperty(propertyName.toUpperCase());
}}
