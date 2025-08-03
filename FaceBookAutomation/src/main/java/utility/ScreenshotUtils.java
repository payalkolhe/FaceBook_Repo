package utility;

import java.io.File;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {
	public static void captureScreenshot(WebDriver driver,String scenarioName) {
		String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		scenarioName=scenarioName.replaceAll("[^a-zA-Z0-9]", "_");
		String screenshotName= scenarioName + "_" + timestamp + ".jpg";
		String path="target/AllureScreenshot" + screenshotName;
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile=Paths.get(path).toFile();
		
		try {
			FileHandler.copy(srcFile, destFile);
		}
		catch(IOException e) {
			System.err.println("Failed to copy the screenshot");
			e.printStackTrace();
		}
		
	}
}
