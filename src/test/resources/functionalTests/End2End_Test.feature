Feature: Automated end to end test
  Description: The purpose of this test case is to test end to end integration.

  Scenario: Customer place an order by purchasing an item from search

    Given User is on Home page
    When User click on search icon
    And enters "dress" on search form
    And choose to buy the first item on the search results page
    And moves to checkout from mini cart
    And enters the personal information on checkout page
    And accepts the terms and conditions
    And place the order


