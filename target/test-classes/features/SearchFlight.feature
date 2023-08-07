Feature: Search flight 
 
Scenario Outline: Search flight with multicity journeytype option
Given User clicks on journeyType option <journeyType>
When User enters departure city <dCity> and arrival city <aCity>
And User clicks on departDate
And User selects depart date with month <month> and date 22
And User selects passengers with adults <noOfAdults> childs <noOfChilds> infants <noOfInfants>
And User selects currency as <curr>
And User clicks on search
Then Available flights for the given search criteria should be displayed

Examples:
|journeyType|dCity |aCity|month|noOfAdults|noOfChilds|noOfInfants|curr|
|multicity  |GOI   |BLR  |August  |4         |2         |1          |USD |

Scenario Outline: Search flight with oneway journeytype option
Given User clicks on journeyType option <journeyType>
When User enters departure city <dCity> and arrival city <aCity>
And User selects depart date with month <month> and date 23
And User selects passengers with adults <noOfAdults> childs <noOfChilds> infants <noOfInfants>
And User selects currency as <curr>
And User clicks on search
Then Available flights for the given search criteria should be displayed

Examples:
|journeyType|dCity |aCity|month|noOfAdults|noOfChilds|noOfInfants|curr|
|oneway  |GWL   |PNQ  |August  |5     |3         |2         |INR |

Scenario Outline: Search flight with roundtrip journeytype option
Given User clicks on journeyType option <journeyType>
When User enters departure city <dCity> and arrival city <aCity>
And User selects depart date with month <month> and date 20
And User clicks on returndate option with month <month> and date 21
And User selects passengers with adults <noOfAdults> childs <noOfChilds> infants <noOfInfants>
And User selects currency as <curr>
And User clicks on search
Then Available flights for the given search criteria should be displayed

Examples:
|journeyType|dCity |aCity|month|returnDate|noOfAdults|noOfChilds|noOfInfants|curr|
|roundtrip  |BOM   |DEL  |August  |June|6        |3         |4        |AED |

