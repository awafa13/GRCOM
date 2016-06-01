
Feature: DataTable Test
Scenario: Test
    Given a list of numbers
    |10|
    |12|
    |8|
	When  I summarize them
	Then  should I get 30