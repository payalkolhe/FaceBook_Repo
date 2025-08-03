package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.WebElementActionsUtilities;


public class SignUpPage {

	@FindBy(xpath="//input[@name='firstname']")
	private WebElement FirstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//select[@id='day']")
	private WebElement day;
	
	@FindBy(xpath="//select[@id='month']")
	private WebElement month;
	
	@FindBy(xpath="//select[@id='year']")
	private WebElement year;
	
	@FindBy(xpath="(//input[@id='sex'])[1]")
	private WebElement female;
	
	@FindBy(xpath="(//input[@id='sex'])[2]")
	private WebElement male;
	
	@FindBy(xpath="(//input[@id='sex'])[3]")
	private WebElement custom;
	
	@FindBy(xpath="//select[@id='preferred_pronoun']")
	private WebElement selectYourPronounDropDown;
	
	@FindBy(xpath="//input[@name='reg_email__']")
	private WebElement mobileNumberOrEmailAddress;
	
	@FindBy(xpath="//input[@id='password_step_input']")
	private WebElement newPassword;

	@FindBy(xpath="//a[text()='Learn more']")
	private WebElement learMoreLink;
	
	@FindBy(xpath="(//a[text()='Privacy Policy'])[1]")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//a[text()='Cookies Policy']")
	private WebElement cookiesPolicyLink;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement signUpBtn;
	
	@FindBy(xpath="//a[text()='Already have an account?']")
	private WebElement alreadyHaveAnAccount;
	

	private	WebDriver driver;
	private WebDriverWait wait;
	
	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));

	}
		
	
	public void sendFirstName(String FirstName) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(this.FirstName));
	        this.FirstName.sendKeys(FirstName);
	        System.out.println("Entered first name: " + FirstName);
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.err.println("Failed to enter first name: " + e.getMessage());
	    }
	}

	public void sendLastName(String lastName) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(this.lastName));

	        this.lastName.sendKeys(lastName);
	        System.out.println("Entered last name: " + lastName);
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.err.println("Failed to enter last name: " + e.getMessage());
	    }
	}

	public void selectDay(String dayValue) {
	    wait.until(ExpectedConditions.visibilityOf(day));
	    new Select(day).selectByValue(dayValue);
	}

	public void selectMonth(String monthValue) {
	    wait.until(ExpectedConditions.visibilityOf(month));
	    new Select(month).selectByValue(monthValue);
	}

	public void selectYear(String yearValue) {
	    wait.until(ExpectedConditions.visibilityOf(year));
	    new Select(year).selectByVisibleText(yearValue);
	}


	public void selectGender(String gender) {
	    switch (gender.toLowerCase()) {
	        case "female":
	            WebElementActionsUtilities.clickOnElement(female);
	            break;
	        case "male":
	            WebElementActionsUtilities.clickOnElement(male);
	            break;
	        case "custom":
	            WebElementActionsUtilities.clickOnElement(custom);
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid gender: " + gender);
	    }
	}

	public void selectYourPronounDropDown() {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(this.selectYourPronounDropDown));
	       // this.selectYourPronounDropDown.click();
	        WebElementActionsUtilities.clickOnElement(selectYourPronounDropDown);
	        System.out.println("Clicked Pronoun dropdown");
	    } catch (Exception e) {
	        System.err.println("Failed to click Pronoun dropdown: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public void sendMobileNumberOrEmailAddress(String mobileNumberOrEmailAddress) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(this.mobileNumberOrEmailAddress));
	        this.mobileNumberOrEmailAddress.sendKeys(mobileNumberOrEmailAddress);
	        System.out.println("Entered mobile number or email: " + mobileNumberOrEmailAddress);
	    } catch (Exception e) {
	        System.err.println("Failed to enter mobile/email: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public void sendNewPassword(String newPassword) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(this.newPassword));
	        this.newPassword.sendKeys(newPassword);
	        System.out.println("Entered new password");
	    } catch (Exception e) {
	        System.err.println("Failed to enter new password: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public void learMoreLinkDragDrop() {
	    try {
	        Actions a = new Actions(driver);    
	        wait.until(ExpectedConditions.elementToBeClickable(this.learMoreLink));
	        a.dragAndDrop(learMoreLink, FirstName).perform();
	        System.out.println("Performed drag and drop from 'Learn More' link to First Name field");
	    } catch (Exception e) {
	        System.err.println("Failed to perform drag and drop: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public void clickcookiesPolicyLink() {
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(this.cookiesPolicyLink));    
	     //   this.cookiesPolicyLink.click();
	        WebElementActionsUtilities.clickOnElement(cookiesPolicyLink);
	        System.out.println("Clicked Cookies Policy link");
	    } catch (Exception e) {
	        System.err.println("Failed to click Cookies Policy link: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public void signUpButton() {
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(this.signUpBtn));    
	       // this.signUpBtn.click();
	        WebElementActionsUtilities.clickOnElement(signUpBtn);
	        System.out.println("Clicked Sign Up button");
	    } catch (Exception e) {
	        System.err.println("Failed to click Sign Up button: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public boolean isSignUpButtonDisplayed() {
	    wait.until(ExpectedConditions.visibilityOf(signUpBtn));
	    return signUpBtn.isDisplayed();
	}


	public void alreadyHaveAnAccountLink() {
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(this.alreadyHaveAnAccount));    
	       // this.alreadyHaveAnAccount.click();
	        WebElementActionsUtilities.clickOnElement(alreadyHaveAnAccount);
	        String getcurrenturl=driver.getCurrentUrl();
			System.out.println(getcurrenturl);
			
	        System.out.println("Clicked 'Already have an account' link");
	    } catch (Exception e) {
	        System.err.println("Failed to click 'Already have an account' link: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
}
	
