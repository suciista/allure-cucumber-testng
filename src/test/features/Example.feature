@example
  Feature: Example Test SImple Login

    @success
    Scenario: As User I want to be able to login
      Given I type correct username
      And I type correct password
      When I click login button
      Then I verify login is success

    @fail
    Scenario: As User I get error message when login using wrong credentials
      Given I type wrong username
      And I type wrong password
      When I click login button
      Then I verify login is fail
