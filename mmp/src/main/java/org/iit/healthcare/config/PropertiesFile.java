package org.iit.healthcare.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile 
{
	public Properties loadProperties() throws IOException 
	{
		//C:\Priyanka\GitMergework\Priyanka_changes\RadiusMMP\mmp\config
		//C:\Priyanka\GitMergework\Priyanka_changes\RadiusMMP\mmp\config\configProperties
		
		String filePath = System.getProperty("user.dir") +"\\config\\configProperties";
		System.out.println("Print the FilePath:" +filePath);
		FileInputStream fis = new FileInputStream(filePath);
		
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
	}
}
