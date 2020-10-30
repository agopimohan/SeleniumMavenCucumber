$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/functionalTests/End2End_Test.feature");
formatter.feature({
  "name": "Automated end to end test",
  "description": "  Description: The purpose of this test case is to test end to end integration.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User is on Home page",
  "keyword": "Given "
});
formatter.step({
  "name": "User click on search icon",
  "keyword": "When "
});
formatter.step({
  "name": "enters \"dress\" on search form",
  "keyword": "And "
});
formatter.step({
  "name": "choose to buy the first item on the search results page",
  "keyword": "And "
});
formatter.step({
  "name": "moves to checkout from mini cart",
  "keyword": "And "
});
formatter.step({
  "name": "enters \"\u003ccustomer\u003e\" personal information on checkout page",
  "keyword": "And "
});
formatter.step({
  "name": "accepts the terms and conditions",
  "keyword": "And "
});
formatter.step({
  "name": "place the order",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "customer"
      ]
    },
    {
      "cells": [
        "Test123"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Customer place an order by purchasing an item from search",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageSteps.user_is_on_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on search icon",
  "keyword": "When "
});
formatter.match({
  "location": "HomePageSteps.user_click_on_search_icon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enters \"dress\" on search form",
  "keyword": "And "
});
formatter.match({
  "location": "HomePageSteps.enters_on_search_form(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "choose to buy the first item on the search results page",
  "keyword": "And "
});
formatter.match({
  "location": "ProductPageSteps.choose_to_buy_the_first_item_on_the_search_results_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "moves to checkout from mini cart",
  "keyword": "And "
});
formatter.match({
  "location": "CartPageSteps.moves_to_checkout_from_mini_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enters \"Test123\" personal information on checkout page",
  "keyword": "And "
});
formatter.match({
  "location": "CheckOutPageSteps.entersPersonalInformationOnCheckoutPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "accepts the terms and conditions",
  "keyword": "And "
});
formatter.match({
  "location": "CheckOutPageSteps.accepts_the_terms_and_conditions()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "place the order",
  "keyword": "And "
});
formatter.match({
  "location": "CheckOutPageSteps.place_the_order()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});