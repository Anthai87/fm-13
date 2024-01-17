#Harald
Feature: Merchant service

Scenario: add merchant to DTU pay
	Given a merchant with first name "Jane", last name "Doe" and crp "1234567890" 
	When the merchant is registered with DTU Pay
	Then the merchant is registered

 Scenario: Delete a merchant from DTU-pay
	Given a merchant with first name "Jane", last name "Doe" and crp "1234567890" 
 	When the merchant is registered with DTU Pay
	Then the merchant is registered
	When the merchant is deleted
	Then the merchant is not registered

