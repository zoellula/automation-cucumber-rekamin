Feature: Login

  Scenario Outline: User login using registered email and password
    Given User launch the app web
    And User input registered email <email>
    And User input registered password <password>
    When user submit button login
    Then User success login
    Examples:
      | email           | password       |
      | "standard_user" | "secret_sauce" |

  Scenario Outline: User login using unregistered email and unregistered password
    Given User launch the app web
    And User input registered email <email>
    And User input registered password <password>
    When user submit button login
    Then User failed login and show warning
    Examples:
      | email           | password       |
      | "wrong_user" | "secret_sauce" |

  Scenario Outline: User login using locked user
    Given User launch the app web
    And User input registered email <email>
    And User input registered password <password>
    When user submit button login
    Then User failed login and show warning locked
    Examples:
      | email           | password       |
      | "standard_user" | "secret_sauce" |
      | "locked_out_user" | "secret_sauce" |

  Scenario: access another page before login
    Given User launch the app web
    When user access another page
    Then user can't access another page before login