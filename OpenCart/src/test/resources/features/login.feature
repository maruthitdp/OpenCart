Feature: Login Functionality o OpenCart

@Login
Scenario: To validate login using valid credentials


Given user launches the browser and open the url
When user clicks on MyAccount button and selects Login option
Then user checks the title of register page
When user enters valid LogIn deatils 
Then user should clickOn LogIn
And user should verify the title after LoggedIn
| expTitle |
| My Account |