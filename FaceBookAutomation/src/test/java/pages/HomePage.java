package pages;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	@FindBy(xpath="//span[text()='Friends']")
	private WebElement Friends;
	
	private WebDriverWait wait ;
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		this.driver=driver;
	}
	
	
	public void verifyHomePageFriendsOption() {
		try {
	        wait.until(ExpectedConditions.visibilityOf(this.Friends));
			String actual=Friends.getText();
			String expected="Friends";
			Assert.assertEquals(actual, expected);
			Assert.assertTrue(Friends.isDisplayed());
			System.out.println("verification succesfull..landed on Home page");
			System.out.println("hii");
			System.out.println("hiii");
		}
		catch(Exception e) {
			System.err.println("Friends is not clicked.");
			//e.printStackTrace();
		}
	}
	
	
}
