Feature: Server connection
  This feature file will test the connection to the REST server

Scenario: hello service retuns correct answer
	When I call the hello service
	Then I get the answer "Hello RESTEasy"