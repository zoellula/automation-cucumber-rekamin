Feature: Cart

  Scenario Outline: User Add Product To Cart
    Given User launch the app web
    And User input registered email <email>
    And User input registered password <password>
    When user submit button login
    Then User success login
    When User add product to cart
    Then cart will show count badge product
    When User click button cart
    Then cart page will show list product
    Examples:
      | email           | password       |
      | "standard_user" | "secret_sauce" |

  Scenario Outline: User Remove Product from Cart
    Given User launch the app web
    And User input registered email <email>
    And User input registered password <password>
    When user submit button login
    Then User success login
    When User add product to cart
    And User click button remove from product
    Then Button will change to button Add
    Examples:
      | email           | password       |
      | "standard_user" | "secret_sauce" |