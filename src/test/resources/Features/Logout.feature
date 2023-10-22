Feature: Logout

  Scenario Outline: User Logout
    Given User launch the app web
    And User input registered email <email>
    And User input registered password <password>
    When user submit button login
    Then User success login
    When user click menu burger
    And user click menu logout
    Then user back to login page
    Examples:
      | email           | password       |
      | "standard_user" | "secret_sauce" |

  Scenario Outline: User can't access inventory page after logout
    Given User launch the app web
    And User input registered email <email>
    And User input registered password <password>
    When user submit button login
    Then User success login
    When user click menu burger
    And user click menu logout
    Then user back to login page
    When user access inventory page
    Then user can't access another page after logout
    Examples:
      | email           | password       |
      | "standard_user" | "secret_sauce" |

