Feature: Login
	As a user
	I can login to the website
	So that I can save my progress
	
	Scenario:	User tries to login
		Given User id on Home Page
		When User Navigates to LogIn Page
		And User enters UserName
		And Password field
		And User clicks submit
		Then the user is logged on
		
	Scenario:	Successful Logout
		When User clicks Logout
		Then User is Logged Out