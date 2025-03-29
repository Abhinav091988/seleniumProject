Feature: User Login
  As a registered user
  User want to log in to my account
  So that User can access my account information


  Scenario Outline: Successful login with valid credentials
    Given User is on the login page
    When User enter "<E-Mail>" and "<Password>" in email and password field
    And User click the Login button
    Then User should be redirected to the account dashboard

    Examples:
      | E-Mail            | Password     |
      | test333@gmail.com | qwerty123456 |

  Scenario Outline: Unsuccessful login with invalid credentials
    Given User is on the login page
    When User enter "<E-Mail>" and "<Password>" in email and password field
    And User click the Login button
    Then User should see an error message "<error message>"

    Examples:
      | E-Mail                | Password     | error message |
      | invalid.user@test.com | Password123! | Warning: No match for E-Mail Address and/or Password.              |


  Scenario Outline: Unsuccessful login with missing email
    Given User is on the login page
    And User click the Login button
    Then User should see an error message "<error message>"
    Examples:
    |error message|
    | Warning: No match for E-Mail Address and/or Password.            |

  Scenario Outline: Forgot password functionality
    Given User is on the login page
    When User click the Forgot Password link
    And User should be redirected to the Forgot Password page
    And User enters valid "<Email>"
    And User click on Continue button
    Then User should be on Login page with success message <message>

    Examples:
      | Email             | message                                                             |
      | test333@gmail.com | An email with a confirmation link has been sent your email address. |

  Scenario Outline: Forgot password functionality with invalid Email
    Given User is on the login page
    When User click the Forgot Password link
    And User should be redirected to the Forgot Password page
    And User enters valid "<Email>"
    And User click on Continue button
    Then User should see an error message "<error message>"

    Examples:
      | Email | error message |
      | invalid.user@test.com      | The E-Mail Address was not found in our records, please try again!              |
