package com.scm.genericutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtils {
/**This method is used to read data from the property file
 * @author nikhilpatel
 * @param key
 * @return
 * @throws Throwable
 */
	public  String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(Ipathconstants.FilePath);
		Properties p= new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		
	}
	
}
