Feature: Validate search functionalities

  Background:
    Given user opens website
    Then verify user is on homepage

  Scenario: Verify user can select brand from HomePage
    When user selects adidas from Footwear in brands menu
    Then verify whether product "footwear.brand" list page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed

  Scenario: Verify user can select category from home page
    When user select Shirts from Men's fashion in Categories
    Then verify whether product "category.name" list page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed

  Scenario: Verify user can search an item
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed

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
