Feature: Validate filter functionality

  Background:
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed

  @web@mobile
  Scenario: Verify user can filter product list as per a brand
    When user selects filter by "Brand" "filter.brand"
    Then verify filter "filter.brand" is applied

  @web@mobile
  Scenario: Verify user can filter product list as per a discount percentage
    When user selects filter by "Discount" "filter.percent"
    Then verify filter "filter.percent" is applied to all products

