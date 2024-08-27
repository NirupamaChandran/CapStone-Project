Feature: Validate sorting functionality

  Background:
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed

  Scenario: Verify user can sort price high to low
    And user sort price high to low
    Then verify whether product list is sorted high to low

  Scenario: Verify user can sort price low to high
    And user sort price low to high
    Then verify whether product list is sorted low to high
