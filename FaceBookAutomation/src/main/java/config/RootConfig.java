package config;

import java.util.Map;

public class RootConfig {
	
	private String activeEnv;
	private Map<String, EnvironmentConfig> environments;
	
	public String getActiveEnv() {
		return activeEnv;
	}
	
	public Map<String, EnvironmentConfig> getEnvironments(){
		return environments;
	}
}
