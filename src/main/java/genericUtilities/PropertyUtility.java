package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility implements IAutoConstants {
	/**
	 * This method is developed to read data from Property file.
	 * this method takes the parameter key whose value we want to fetch.
	 * @param Key
	 * @return value of the given key
	 */
	
	public String getDatafromPropertyFile(String Key) {
		FileInputStream Fis=null;
     try {
		Fis= new FileInputStream(PROPERTY_FILE_PATH);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     Properties property=new Properties();
     try {
		property.load(Fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return property.getProperty(Key);
	}
}
