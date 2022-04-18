package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;
	FileInputStream fis;

	public ConfigDataProvider() {
		try {
			fis = new FileInputStream("src/main/resources/data.properties");
			pro = new Properties();
			pro.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		return pro.getProperty("browser");

	}
	public String getUrl() {
		return pro.getProperty("url");

	}

}
