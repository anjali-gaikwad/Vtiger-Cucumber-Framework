Feature: login functionality

Background:
Given user should be on login page

@TC01 
Scenario: valid_login_TC01
When user enters valid credentials
And click on login button
Then user should be on home page
And user can see logout option


@TC02
Scenario: valid_login_TC02
When user enters valid credentials userid "<userID>" and password "<password>"
|TCID|userID| password|
|TC03|admin1|pwd1|
|TC04|admin2|pwd2|
|TC05|admin|admin|
And click on login button
Then user should be on home page
And user can see logout option

@TC03
Scenario Outline: valid_login_<TCID>
When user enters valid credentials userid as "<userID>" and password as "<password>"
And click on login button
Then user should be on home page
And user can see logout option
Examples:
|TCID|userID| password|
|TC03|admin1|pwd1|
|TC04|admin2|pwd2|


@TC04
Scenario: valid_login_with_Theme_TC06
When user enters valid credentials and theme
And click on login button
Then user should be on home page
And user can see logout option

@TC05
Scenario: valid_login_with_Theme_and_Language_TC07
When user enters valid credentials and theme and language
And click on login button
Then user should be on home page
And user can see logout option