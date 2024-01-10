Feature: Payment

Scenario: Successful Payment
Given a customer with id "3eee0fea-b21f-4f06-9c07-310cae24ecb1"
And a merchant with id "5d686620-8f20-4c37-b113-a2358fa6284b"
When the merchant initiates a payment for 10 kr by the customer
Then the payment is successful

Scenario: List of payments
Given a successful payment of 10 kr from customer "3eee0fea-b21f-4f06-9c07-310cae24ecb1" to merchant "5d686620-8f20-4c37-b113-a2358fa6284b"
When the manager asks for a list of payments
Then the list contains a payments where customer "3eee0fea-b21f-4f06-9c07-310cae24ecb1" paid 10 kr to merchant "5d686620-8f20-4c37-b113-a2358fa6284b"



