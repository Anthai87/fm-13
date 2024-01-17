#Harald
Feature: Customer service
#Scenarios for pay service

Scenario: person service getPersonJson returns correct answer
	When I call the personService to get person via Json
	Then I get a customer with name "John" and address "Doe"

Scenario: add customer to DTU pay
	Given a customer with first name "Jane", last name "Doe" and crp "1234567890" 
	When the customer is registered with DTU Pay
	Then the customer is registered

 Scenario: Delete a customer from DTU-pay
	Given a customer with first name "Jane", last name "Doe" and crp "1234567890" 
 	When the customer is registered with DTU Pay
	Then the customer is registered
	When the customer is deleted
	Then the customer is not registered

