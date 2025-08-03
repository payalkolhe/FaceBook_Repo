package core;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.ConfigReader;
import config.EnvironmentConfig;

public class DriverFactory {
	public static WebDriver driver;
	public static EnvironmentConfig evnConfig;

	public void setup() {
		evnConfig=ConfigReader.getActiveEnvironment();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String baseUrl=evnConfig.getBaseURL();
		driver.get(baseUrl);
	}

	public void tearDown() {

		if(driver!=null) {
			driver.quit();
		}
		
	}
}
