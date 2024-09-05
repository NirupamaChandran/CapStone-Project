Feature: Validate category and brand search

  Background:
    Given user opens website
    Then verify user is on homepage

  @web
  Scenario: Verify user can select brand from HomePage
    When user selects adidas from Footwear in brands menu
    Then verify whether product "footwear.brand" list page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed

  @web
  Scenario: Verify user can select category from home page
    When user select Shirts from Men's fashion in Categories
    Then verify whether product "category.name" list page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed