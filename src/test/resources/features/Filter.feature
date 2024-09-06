Feature: Validate filter functionality

  Background:
    Given user opens website
    Then verify user is on homepage

  @web@mobile
  Scenario: Verify user can filter product list as per a brand
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed
    When user selects filter by "Brand" "filter.brand"
    Then verify filter "filter.brand" is applied

  @web@mobile
  Scenario: Verify user can filter product list as per a discount percentage
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed
    When user selects filter by "Discount" "filter.percent"
    Then verify filter "filter.percent" is applied to all products


  @mobile
  Scenario: Verify user can filter product by color
    When user search an item "search.cart" in search bar
    Then verify "search.cart" listing page is displayed
    When user scroll up to filter by colour option
    And swipe until last color
    And select last color from the list
    And click view products
    Then verify filter by colour is applied