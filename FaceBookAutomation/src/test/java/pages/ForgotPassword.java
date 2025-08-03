package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ForgotPassword {

	@FindBy(xpath="(//h2[text()='Find Your Account'])[2]")
	private WebElement FindYourAccount;
	
	private WebDriverWait wait ;
	private WebDriver driver;
	
	public ForgotPassword(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	   this.driver=driver;
	}
	
	public void verifyForgotPasswordPageDisplay() {
		try {
			wait.until(ExpectedConditions.visibilityOf(this.FindYourAccount));
			String actual=FindYourAccount.getText();
			String expected="Find Your Account";
			Assert.assertEquals(actual, expected);
			
		}
		catch(Exception e) {
			System.err.println("Find_Your_Account not displayed");
			e.printStackTrace();
		}
	}
}
