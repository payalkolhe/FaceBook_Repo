package config;

import java.io.InputStream;


import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigReader {
	public static RootConfig config;
	
	static {
		try {
			ObjectMapper mapper=new ObjectMapper();
			InputStream inputStream=ConfigReader.class.getClassLoader().getResourceAsStream("environment.json");
			config=mapper.readValue(inputStream,RootConfig.class);
		}
		catch(Exception e){
			System.err.println("Failed to load the environment config");
			e.printStackTrace();
		}
		
	}
	public static EnvironmentConfig getActiveEnvironment() {
		
		String runtimeEnv=System.getProperty("env");
		String selectedEnv;
		selectedEnv=(runtimeEnv!=null)?runtimeEnv:config.getActiveEnv();
		
//		if(runtimeEnv !=null) {
//			selectedEnv=runtimeEnv;
//			}
//		else {
//			selectedEnv=config.getActiveEnv();
//		}
		return config.getEnvironments().get(selectedEnv);
		
	}
}
