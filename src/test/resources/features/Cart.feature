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
    Then verify success message is displayed
    And verify cart count is "1"
    And user click cart icon
    Then verify user is on cart page

  @web@mobile
  Scenario: Verify user can add an item to cart
    Then verify cart contain the correct item

  @web@mobile
  Scenario: Verify user can alter quantity and size from the cart
    When user changes the size and quantity of the item
    Then verify the size "item.size" and quantity is updated

  @web
  Scenario: Verify user can remove item from the cart
    When user clicks on remove button
    Then verify the item is removed from the cart
    When user clicks continue shopping button
    Then verify user is in home page

  @mobile
  Scenario: Verify user can remove item from the cart in android
    When user clicks on remove button
    Then verify the item is removed from the cart

  @web@mobile
  Scenario: Verify the total amount in cart page
    Then verify cart contain the correct item
    And verify the total amount is correct
    When user increase quantity of the item
    And verify the total amount is correct
    When user clicks tatacliq logo
    Then verify user is in home page
    When user search an item "search.item" in search bar
    Then verify "search.item" listing page is displayed
    When user clicks on the first product
    Then verify whether product detail page is displayed
    And user selects size "item.size" of the product
    And user clicks add to cart button
    Then verify success message is displayed
    And user click cart icon
    Then verify user is on cart page
    And verify the total amount is correct

  @web@mobile
  Scenario: Verify user can apply coupon
    When user clicks check for coupons
    And apply a coupon if available
    Then verify coupon amount is reduced from total amount
