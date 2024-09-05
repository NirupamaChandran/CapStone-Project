Feature: Validate product detail page functionalities

  Background:
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.cart" in search bar
    Then verify "search.cart" listing page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed

  @web
  Scenario: Verify user can view more product info
    When user clicks more product info
    Then verify product info is displayed

  @web@mobile
  Scenario: Verify user can visit store
    When user clicks visit store button
    Then verify whether product "brand.name" list page is displayed

  @web@mobile
  Scenario: Verify user can view similar products
    When user clicks similar products icon from product image
    And click view all products button
    Then verify similar products listing page is displayed