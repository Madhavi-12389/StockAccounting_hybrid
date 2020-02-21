package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {
	
	public static String getValueForKey( String Key) throws IOException{
		
		Properties p = new Properties();
		
		FileInputStream fi = new FileInputStream("D:\\Madhavi\\StockAccountingHybridFF\\PropertyFile\\Enviroment.properties");
		
		p.load(fi);
		
		return  p.getProperty(Key);
		
 }
	

}
