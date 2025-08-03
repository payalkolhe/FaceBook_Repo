Feature: Verify Facebook Login Page

  Scenario Outline: Successful login with valid credentials
    Given user is on the login page
    When user enters email address "<email>" and password "<password>"
    And user clicks on the Log In button
    Then user should be redirected to the home page

    Examples:
      | email        | password          |
      | 7972118383   | Optum@7972118383  |


  Scenario Outline: Unsuccessful login with invalid credentials
    Given user is on the login page
    When user enters email address "<email>" and password "<password>"
    And user clicks on the Log In button
    Then user should see an error message saying Incorrect username and password

    Examples:
      | email             | password |
      | invalid@test.com  | 123456   |


  Scenario: Forgotten Password navigation
    Given user is on the login page
    When user clicks on the Forgotten password? link
    Then user should be navigated to the recovery page


  Scenario: Create new account navigation
    Given user is on the login page
    When user clicks on the Create new account button
    Then user should be navigated to the Sign Up page


  Scenario Outline: Complete sign up process
  Given user is on the Sign Up page
  When user enters FirstName "<FirstName>" and LastName "<LastName>"
  And selects date of birth "<day>","<month>","<year>"
  And selects gender "Female"
  And enters email "<email>" and new password "<password>"
  And clicks on the Sign Up button
  Then account creation should be initiated

  Examples:
    | FirstName | LastName | day | month | year | email          | password |
    | Payal     | Kolhe    | 10  | 05    | 1995 | test@gmail.com | 6987465  |




  Scenario: Navigate to login from sign up
    Given user is on the Sign Up page
    When user clicks on the Already have an account? link
    Then user should be navigated to the Log in to Facebook page
