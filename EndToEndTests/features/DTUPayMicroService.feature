Feature: Payment

Scenario: Successful Payment
Given a customer with id "1"
And a merchant with id "2"
When the merchant initiates a payment for 10.00 kr by the customer
Then the payment is successful

Scenario: List of payments
Given a successful payment of 10.00 kr from customer "1" to merchant "2"
When the manager asks for a list of payments
Then the list contains a payments where customer "1" paid 10.00 kr to merchant "2"



