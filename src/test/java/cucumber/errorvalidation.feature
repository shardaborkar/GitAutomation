@tag
Feature: Error validation
  
    @Error
  Scenario: Error validation for incorect username and password
   When User is logged in with username asx@gmail.com and password asx123
   Then "Incorrect email or password." message is displayed
    
  @Error
  Scenario Outline: Error validation for incorect username and password using examples
    When User is logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name            | password    | 
      | asx@gmail.com   | asx123      |
      
