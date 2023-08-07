Feature: Book holiday package
 
Scenario Outline: Book holiday packages in destination city
Given User clicks on holidaypackage option
When User clicks on destination option <destination>
And User enters departure city <dCity> and return city <aCity>
And User selects the departure date with month <month> and date 27
And User clicks on search button

Examples:
|destination|dCity |aCity|month|
|Leh  |Mumbai   |Delhi  |August  |