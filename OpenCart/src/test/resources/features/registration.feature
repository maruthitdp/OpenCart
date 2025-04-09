Feature: Register Functionality
@abc143
Scenario: Validate Registering an Account by providing only the Mandatory fields of already registered details

Given user launches the browser and open the url
When user clicks on MyAccount button and selects Register option
Then user checks the title of register page
When user enters personal deatils of the mandatory fields
| FirstName | LastName | Email | TelephoneNumber |
| Maruthi Reddy | Kodathala | maruthireddykodathala59@gmail.com | 8309117319 |
And user enters password details of the mandatory fields
And user clicks on mandatoryCheckBoxes
And user clicks on Continue button
Then user should be navigated to Account Success Page and verify the title of the page
| expTitle |
| Register Account |




