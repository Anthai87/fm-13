#Harald, Elias og Anthony
Feature: Report 
Scenario: Manager gets a list of all payments
Given a mangager asks for a list of all payments
Then he gets a list of all payments

# Scenario: Merchant asks for a list of payments
Given a successful payment of 10 kr from customer with name "Eddy" to merchant "Murphy"
And a merchant asks for a list of payments
Then he gets a list of all payments
And all payments contains only merchants ID

Scenario: Customer asks for a list of payments
Given a successful payment of 10 kr from customer with name "Eddy" to merchant "Murphy"
Given a Customer asks for a list of payments
Then he gets a list of all payments
And all payments contains only customers ID
