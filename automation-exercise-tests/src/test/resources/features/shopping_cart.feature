@regression
Feature: Shopping Cart Management
  As a customer of the online clothing store
  I want to add products to the shopping cart
  So that I can review them before completing the purchase

  # 1. The customer can add one or several products to the cart
  # 2. The cart shows the products in the cart
  # 3. The customer can remove products from the cart

  Background:
    Given I am on the products section

  Scenario: HU-01 Add a single product to the cart
    When I add a product to the cart
    Then the product is displayed in the cart

  Scenario: HU-02 Add multiple products to the cart
    Given I have added a product to the cart
    When I add another different product
    Then I can see both products in the cart list

  Scenario: HU-03 Remove a product from the cart
    Given I have added a product to the cart
    And I add another different product
    When I go to the shopping cart
    And I remove one of the products
    Then the product is no longer visible in the cart

  Scenario: HU-04 View product list in the cart
    Given I have added a product to the cart
    When I navigate to the shopping cart
    Then I can see the list with the added products

  Scenario: HU-05 View empty cart
    When I navigate to the shopping cart
    Then the cart is empty
