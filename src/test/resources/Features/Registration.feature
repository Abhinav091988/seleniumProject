Feature: User Registration
  As a new user
  user want to fill out a registration form
  So that user can create a new account

  Scenario Outline: Successful registration with all mandatory fields
    Given User on the registration page
    When User enter "<First Name>" "<Last Name>" "<E-Mail>" "<Telephone>" "<Password>" "<Password Confirm>" in the mandate field
    And User check the Privacy Policy checkbox
    And User click the Continue button
    Then User should see a confirmation message "<message>" indicating successful registration

    Examples:
      | First Name | Last Name | E-Mail                  | Telephone  | Password     | Password Confirm | message                        |  |
      | John       | Doe       | john.doe778@example.com | 1234567890 | Password123! | Password123!     | Your Account Has Been Created! |  |
      | Jane       | Smith     | jane.smith778@test.com  | 0987654321 | MySecurePwd1 | MySecurePwd1     | Your Account Has Been Created! |  |

  Scenario Outline: Registration with unchecked Privacy Policy
    Given User on the registration page
    When User enter "<First Name>" "<Last Name>" "<E-Mail>" "<Telephone>" "<Password>" "<Password Confirm>" in the mandate field
    And User click the Continue button
    Then User should see an error message <message> for Privacy Policy

    Examples:
      | First Name | Last Name | E-Mail                | Telephone  | Password     | Password Confirm | message                               |
      | John       | Doe       | john.doe779@example.com | 1234567890 | Password123! | Password123!     | Warning: You must agree to the Privacy Policy! |

  Scenario Outline: Registration with an already existing email
    Given User on the registration page
    When User enter "<First Name>" "<Last Name>" "<E-Mail>" "<Telephone>" "<Password>" "<Password Confirm>" in the mandate field
    And User check the Privacy Policy checkbox
    And User click the Continue button
    Then User should see an error message <message> for existing email ID

    Examples:
      | First Name | Last Name | E-Mail               | Telephone  | Password     | Password Confirm | message                               |
      | John       | Doe       | john.doe@example.com | 1234567890 | Password123! | Password123!     | E-Mail Address is already registered! |

  Scenario Outline: Validate for missing mandatory fields
    Given User on the registration page
    When User check the Privacy Policy checkbox
    And User click the Continue button
    Then User should get error message for "first_name" fields <first_name_vmsg>
    Then User should get error message for "last_name" fields <last_name_vmsg>
    Then User should get error message for "emailId" fields <E_Mail_vmsg>
    Then User should get error message for "telephone" fields <Telephone_vmsg>
    Then User should get error message for "password" fields <Password_vmsg>

    Examples:
      | first_name_vmsg                                      | last_name_vmsg | E_Mail_vmsg | Telephone_vmsg | Password_vmsg |
      | First Name must be between 1 and 32 characters! |   Last Name must be between 1 and 32 characters!        |   E-Mail Address does not appear to be valid!      |  Telephone must be between 3 and 32 characters!         |  Password must be between 4 and 20 characters!        |


