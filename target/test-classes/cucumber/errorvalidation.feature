#@tag
#Feature: Error validation
  #
    #@Error
  #Scenario: Error validation for incorect username and password
  #Given User landed on the landing page
   #When User is logged in with username "asx@gmail.com" and password "asx123"
   #Then "Incorrect email or password." message is displayed
    #
  #@Error
  #Scenario Outline: Error validation for incorect username and password using examples
  #Given User landed on the landing page
    #When User is logged in with username <name> and password <password>
    #Then "Incorrect email or password." message is displayed
#
    #Examples: 
      #| name            | password    | 
      #| ert@gmail.com   | ert123      |
      
