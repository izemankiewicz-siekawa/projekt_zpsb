Feature: This is just a first test to see if environment works

  Scenario: Simple POC of tests function
    Given I open home page
    When I write search phrase "Blouse"
    And I click Search
    Then I will see that "1 result has been found."