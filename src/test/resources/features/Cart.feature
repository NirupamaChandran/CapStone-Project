Feature: Validate cart page functionalities

  Background:
    Given user opens website
    Then verify user is on homepage
    When user search an item "search.cart" in search bar
    Then verify "search.cart" listing page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed
    And user selects size "item.size" of the product
    And user clicks add to cart button
    Then verify text "The item has been added to your bag" is displayed
    And verify cart count is "1"
    And user click cart icon
    Then verify user is on cart page

  Scenario: Verify user can add an item to cart
    Then verify cart contain the correct item

  Scenario: Verify user can alter quantity and size from the cart
    When user changes the size and quantity of the item
    Then verify the size "item.size" and quantity is updated

  Scenario: Verify user can remove item from the cart
    When user clicks on remove button
    Then verify the item is removed from the cart
    When user clicks continue shopping button
    Then verify user is in home page

  Scenario: Verify the total amount in cart page
    Then verify cart contain the correct item
    And verify the total amount is correct
    When user increase quantity then verify
    And verify the total amount is correct
