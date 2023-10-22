Feature: Checkout

  Scenario Outline: User Checkout Cart
    Given User launch the app web
    And User input registered email <email>
    And User input registered password <password>
    When user submit button login
    Then User success login
    When User add product to cart
    Then cart will show count badge product
    When User click button cart
    Then cart page will show list product
    When User click button checkout
    Then page will show form information
    And User input first name "aa"
    And User input last name "bb"
    And User input zip code "123"
    When User click button Continue
    Then page will show overview order
    When User click button finish
    Then page will show completion order page
    Examples:
      | email           | password       |
      | "standard_user" | "secret_sauce" |

  Scenario Outline: User failed Checkout after can't input form information
    Given User launch the app web
    And User input registered email <email>
    And User input registered password <password>
    When user submit button login
    Then User success login
    When User add product to cart
    Then cart will show count badge product
    When User click button cart
    Then cart page will show list product
    When User click button checkout
    Then page will show form information
    When User click button Continue
    Then User failed checkout and show error required
    Examples:
      | email           | password       |
      | "standard_user" | "secret_sauce" |