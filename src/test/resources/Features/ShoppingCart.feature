Feature: Validating e2e functionality of adding a product in Shopping cart
  and validating the same in shopping cart page

  Scenario Outline: Validating added product in shopping cart page
    Given User is on the login page
    When User enter "<E-Mail>" and "<Password>" in email and password field
    And User click the Login button
    And User should be redirected to the account dashboard
    When User search for product <ProductName>
    And User clicks on product on search page
    And User gets the price of product
    And User clicks on "Add to cart" on product page
    Then User should get success message Success: You have added <ProductName> to your "shopping cart"
    When User clicks on Shopping cart
    Then User should validate same product name <ProductName> and price

    Examples:
      | E-Mail            | Password     | ProductName |
      | test333@gmail.com | qwerty123456 | HP LP3065   |
      | test333@gmail.com | qwerty123456 | Samsung SyncMaster 941BW   |
      | test333@gmail.com | qwerty123456 | Apple Cinema 30"   |