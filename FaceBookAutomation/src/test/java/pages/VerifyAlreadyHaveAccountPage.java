package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VerifyAlreadyHaveAccountPage {
	
	@FindBy(xpath="//div[text()='Log in to Facebook']")
	private WebElement logInToFacebook;
	
	private WebDriverWait wait ;
	private WebDriver driver;
	public VerifyAlreadyHaveAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		this.driver=driver;
	}
	
	
	public void verifyAlreadyHaveAccountLinkOpens() {
		try {
			wait.until(ExpectedConditions.visibilityOf(logInToFacebook));
			String actual=logInToFacebook.getText();
			String expected="Log in to Facebook";
			Assert.assertEquals(actual, expected);
			
		}
		catch(Exception e) {
			System.err.println("Unsuccessfull.. not landed on Log In To FaceBook page");
			e.printStackTrace();
		}
	
	}
}
