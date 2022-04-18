package factory;

import dataProvider.ConfigDataProvider;

public class DataProviderfactory {
	
	public static ConfigDataProvider getConfig() {
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}

}
