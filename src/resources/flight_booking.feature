Feature: To book a flight ticket on Cleartrip Website

Scenario Outline:To fill the details of Home Page
Given User is on Home Page and One Way is selected
Then Fills the From which is boarding place
And Fills the To which is deboarding place
Then Selects the date of departure "<year>" and "<month>" and "<date>"
And Fills the number of Adults and Children and Infants
Then Clicks on Search Flights

Examples:
|year| month|date|
|2021|  January | 26 | 
#|2021|  August| 06 | 


Scenario: To Book the flight of choice
#Given User is on second page and verifies the Route
#Then User verifies the Boarding City
#Then User verifies the DeBoarding City
#Then User verifies the Date of Travelling
#Then User verifies the number of Persons
Then User chooses the flight and clicks on book
