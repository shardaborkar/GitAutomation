Feature: Error messages during flight search
 
Scenario Outline: Verify error message is displayed when more than 9 passengers are selected
Given User clicks on journeyType option <journeyType>
When User enters departure city <dCity> and arrival city <aCity>
And User clicks on departDate
And User selects depart date with month <month> and date 22
And User selects passengers with adults <noOfAdults> childs <noOfChilds> then Error message You are allowed a maximum of 9 passengers per booking online. If your party is larger than this, please call our reservation center. should be displayed

Examples:
|journeyType|dCity |aCity|month|noOfAdults|noOfChilds|noOfInfants|curr|
|multicity  |GOI   |BLR  |August  |6         |4         |1          |USD |