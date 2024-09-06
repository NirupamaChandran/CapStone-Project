Feature: Validate sorting functionality

  Background:
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed

  @web@mobile
  Scenario: Verify user can sort price high to low
    And user sort "Price High to Low"
    Then verify whether product list is sorted high to low

  @web@mobile
  Scenario: Verify user can sort price low to high
    And user sort "Price Low to High"
    Then verify whether product list is sorted low to high
