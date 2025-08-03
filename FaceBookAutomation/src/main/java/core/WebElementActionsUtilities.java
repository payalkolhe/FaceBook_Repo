package core;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementActionsUtilities extends DriverFactory{
	private static Wait<WebDriver> wait;
	static {
		wait=new WebDriverWait(driver,Duration.ofMillis(60000));
	}
	
	public static void clickOnElement(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
		try {
			ele.click();
		}
		catch(Exception e) {
			try {
				Actions act=new Actions(driver);
				act.moveToElement(ele).click().build().perform();
			}
			catch(Exception er) {
				JavascriptExecutor r=(JavascriptExecutor)driver;
				r.executeScript("arguments[0].click();", ele);
				
			}
		}
		
	}
}
