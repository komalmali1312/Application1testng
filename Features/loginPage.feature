#Author:komalmali1312@gmail.com
#applicationname: OrangeHRM
Feature: Login Page

  Background:
  Given Initialize the browser
    Given I am on the OrangeHRM login page
 
  Scenario: Verify the title of the login page
    Then the title should be "OrangeHRM"
Scenario: Verify the title of the login page logo
    Then I should see the logo 
   Scenario: Verify the presence of "Login" header
      Then I should see the LoginForm header 
  Scenario: Verify the presence of username and password fields
    Then I should see the username field
    And I should see the password field

  Scenario: Verify the presence of login button
    Then I should see the login button

  Scenario: Verify the presence of "Forgot your password?" link
    Then I should see the "Forgot your password?" link

  Scenario:Verify copyright text on loginpage
      Then I should see the copyright text
      
 Scenario Outline: Verify the login functionality with valid credentials
    Given I enter "<username>" in the username field
    And I enter "<password>" in the password field
    When I click on the login button
    Then I should be redirected to the dashboard page

  Examples:
    | username | password |
    | Admin    | admin123 |

  Scenario Outline: Verify the login functionality with invalid credentials
    Given I enter "<username>" in the username field
    And I enter "<password>" in the password field
    When I click on the login button
    Then I should see an error message indicating "invalid credentials"

  Examples:
    | username | password |
    | invalid  | invalid  |
Scenario: Verify home Page
    When user login with valid credentials
    Then user should be able to see the home page
    
    

 

      