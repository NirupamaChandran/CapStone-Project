Feature: Validate search functionalities

  Background:
    Given user opens website
    Then verify user is on homepage

  @web @mobile
  Scenario: Verify user can search an item
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed

  @web @mobile
  Scenario Outline: Verify user can search multiple items

    When user search an item "<searchKey>" in search bar
    Then verify "<searchKey>" listing page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed

    Examples:
    | searchKey |
    | Lamps     |
    | Bedsheet  |
    | Chair     |
    | Bags      |
