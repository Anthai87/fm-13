#Harald
Feature: Customer service
#Scenarios for pay service

Scenario: person service getPersonJson returns correct answer
	When I call the personService to get person via Json
	Then I get a customer with name "John" and address "Doe"

Scenario: add customer to DTU pay
	Given a customer with name "Jane" and andress "Sin City"
	When the customer is registered with DTU Pay
	Then the customer is registered

#Scenario: Updating the person using JSON
#	When I update the person with name "Carrie V. Herzig" and address "Harrisburg" using JSON
#	And I call the hello service to get person via Json
#	Then I get a person with name "Carrie V. Herzig" and address "Harrisburg"
#