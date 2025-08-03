package stepDefi;

import core.DriverFactory;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ForgotPassword;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import pages.VerifyAlreadyHaveAccountPage;

public class StepDefination extends DriverFactory{
	
	private LoginPage loginPage;
	private SignUpPage signUpPage;
	private HomePage homePage;
	private ForgotPassword forgotPassword;
	private VerifyAlreadyHaveAccountPage verifyAlreadyHaveAccountPage;
	
	
	 @Given("user is on the login page")
	 public void user_is_on_the_login_page() {
			 loginPage=new LoginPage(driver);
			 loginPage.verifyLoginPageDisplay();
		
	 }
	 
	 @When("user enters email address {string} and password {string}")
	 public void enter_email_and_password(String email,String password) {
		 loginPage=new LoginPage(driver);
		
		    loginPage.sendEmail(email);        
		    loginPage.sendpassword(password);
	 }
	 
	 @When("user clicks on the Log In button")
	 public void click_on_LogIn_button() {
		 loginPage=new LoginPage(driver);
		 loginPage.clickOnloginButton();
	 }

	 @Then("user should be redirected to the home page")
	 public void redirected_to_the_home_page() {
		 homePage=new HomePage(driver);
		 homePage.verifyHomePageFriendsOption();
	 }
	 
	 @Then("user should see an error message saying Incorrect username and password")
	 public void error_message_saying_Incorrect_username_and_password() {
		 loginPage=new LoginPage(driver);
		 loginPage.clickOnloginButton();
	 }

	 @When("user clicks on the Forgotten password? link")
	 public void clicks_on_the_Forgotten_password_link() {
		 loginPage=new LoginPage(driver);
		 loginPage.clickOnForgottenPasswordLink();
	 }

	 @Then("user should be navigated to the recovery page")
	 public void navigated_to_the_recovery_page() {
		 forgotPassword=new ForgotPassword(driver);
		 forgotPassword.verifyForgotPasswordPageDisplay();
	 }
	 
	 @When("user clicks on the Create new account button")
	 public void clicks_on_the_Create_new_account_button() {
		 loginPage=new LoginPage(driver);
		 loginPage.clickOnCreateNewAccountButton();
	 }
	 
	 @Then("user should be navigated to the Sign Up page")
	 public void navigated_to_the_Sign_Up_page() {
		 signUpPage=new SignUpPage(driver);
		 signUpPage.isSignUpButtonDisplayed();
	 }
	 
	 @Given("user is on the Sign Up page")
	 public void user_is_on_the_Sign_Up_page() {
		 signUpPage=new SignUpPage(driver);
		 signUpPage.signUpButton();
	 }
	
	 @When("user enters FirstName {string} and LastName {string}")
	 public void first_name_and_surname(String FirstName,String LastName) {
		 signUpPage=new SignUpPage(driver);
		 signUpPage.sendFirstName(FirstName);
		 signUpPage.sendLastName(LastName);
	 }

	 @When("selects date of birth {string},{string},{string}")
	 public void selects_date_of_birth_day_month_and_year(String day,String month,String year) {
		 signUpPage=new SignUpPage(driver);
		 signUpPage.selectDay(day);
		 signUpPage.selectMonth(month);
		 signUpPage.selectYear(year);
	 }
	 
     @When("select Female {string}")
     public void select_Female(String Female) {
		 signUpPage=new SignUpPage(driver);
    	 signUpPage.selectGender(Female);
    	
     }
     
     @When("enters email {string} and new password {string}")
     public void enters_email_and_new_password(String email,String newPassword) {
    	 signUpPage.sendMobileNumberOrEmailAddress(email);
    	 signUpPage.sendNewPassword(newPassword);
     }
     
     
     @When("clicks on the Sign Up button")
     public void clicks_on_the_SignUp_button() {
		 signUpPage=new SignUpPage(driver);
    	 signUpPage.signUpButton();
     }
     
     @Then("account creation should be initiated")
     public void account_creation_should_be_initiated() {
         System.out.println("Account creation process has started.");
     }
     
     @When("user clicks on the Already have an account? link")
     public void Already_have_an_account_link() {
		 signUpPage=new SignUpPage(driver);
    	 signUpPage.alreadyHaveAnAccountLink();
     }

     @Then("user should be navigated to the Log in to Facebook page")
     public void navigated_to_the_Log_in_to_Facebook_page() {
    	 verifyAlreadyHaveAccountPage=new VerifyAlreadyHaveAccountPage(driver);
    	 verifyAlreadyHaveAccountPage.verifyAlreadyHaveAccountLinkOpens();
     }	 
}
