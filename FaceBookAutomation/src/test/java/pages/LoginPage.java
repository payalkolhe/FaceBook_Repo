package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import core.WebElementActionsUtilities;

public class LoginPage {

	@FindBy(xpath="//img[@alt='Facebook']")
	@CacheLookup
	private WebElement facebook;
	
	@FindBy(xpath="//div[@aria-label='Your profile']")
	private WebElement profileElement;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;

	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;

	@FindBy(id="errorMsg")
	private WebElement wrongEmail;
	
	@FindBy(xpath="//div[contains(text(),'The password ')]")
	private WebElement wrongPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Forgotten password?']")
	private WebElement forgottenPasswordLink;
	
	@FindBy(xpath="(//a[@role='button'])[3]")
	private WebElement createNewAccountButton;
	
	@FindBy(xpath="//a[text()='Create a Page']")
	private WebElement createAPageLink;
	
	private WebDriver driver ;
	private WebDriverWait wait ;
    
	public void verifyLoginPageDisplay() {
        try {
            // Wait until the element is visible
            wait.until(ExpectedConditions.visibilityOf(facebook));

            // Correct usage of assertTrue in TestNG
            Assert.assertTrue(facebook.isDisplayed(), "Facebook logo is displayed!");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred while verifying Facebook logo: " + e.getMessage());
        }
    }
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
		
	public void sendEmail(String email) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(this.email));
	        
	        if (email == null || email.trim().isEmpty()) {
	            throw new IllegalArgumentException("Email input is null or empty.");
	        }

	        this.email.sendKeys(email);
	        System.out.println("Username entered successfully: " + email);
	    } catch(Exception e) {
	        System.err.println("User unable to enter username in field: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public void sendpassword(String password) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(this.password));
	        
	        if (password == null || password.trim().isEmpty()) {
	            throw new IllegalArgumentException("Password input is null or empty.");
	        }

	        this.password.sendKeys(password);
	        System.out.println("Password entered successfully.");
	    } catch(Exception e) {
	        System.err.println("User unable to enter password in field: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	public void clickOnloginButton() {
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(this.loginButton));
	        //this.loginButton.click();
	        WebElementActionsUtilities.clickOnElement(loginButton);
	        System.out.println("Login button clicked.");

	        try {
	             wait.until(ExpectedConditions.visibilityOf(this.profileElement));
	            System.out.println("Login successful. User is redirected to the home page.");
	            return;
	        } catch (TimeoutException e) {
	            System.out.println("Login not successful, checking for errors...");
	        }

	       
	    } catch (Exception e) {
	        System.err.println("Exception during login validation: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	
	public void clickOnForgottenPasswordLink() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(this.forgottenPasswordLink));
			//this.forgottenPasswordLink.click();
			WebElementActionsUtilities.clickOnElement(forgottenPasswordLink);
		}
		catch(Exception e) {
			System.err.println("Failed to clicks on ForgotPassword Link");
			e.printStackTrace();
		}
		
	}
	
	public void clickOnCreateNewAccountButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(this.createNewAccountButton));
			//this.createNewAccountButton.click();
			WebElementActionsUtilities.clickOnElement(createNewAccountButton);
		}
		catch(Exception e) {
			System.err.println("Failed to clicks on Create New Account Button");
			e.printStackTrace();
		}
	}
	
	public void clickOnCreateAPageLink() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(this.createAPageLink));
			//this.createAPageLink.click();
			WebElementActionsUtilities.clickOnElement(createAPageLink);
		}
		catch(Exception e) {
			System.err.println("Failed to clicks on Create A Page Link");
			e.printStackTrace();
		}
	}
	
	public String getloginButtonText() {
		return 	this.loginButton.getText();
	}
	
	public String getForgottenPasswordLink() {
		return this.forgottenPasswordLink.getText();
	}
	
	public String getCreateNewAccountButtonText() {
		return this.createNewAccountButton.getText();
	}
	
	
}
