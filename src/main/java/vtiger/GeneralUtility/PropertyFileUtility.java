package vtiger.GeneralUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Piyusha Chipare
 * This class consists  generic methods related to property files
 */
public class PropertyFileUtility 
{
/**
 * This method will read data from property file
 * @return 
 * @param 
 * @throws IOException
 */
	
	public String readDataFromPropertyFile(String keyValue) throws IOException 
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.propertyFilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(keyValue);
		return value;
	}
	
}
