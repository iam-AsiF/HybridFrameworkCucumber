Feature: Bank Manager Login (openAccount)

  @openAccount
  Scenario: Manager opens an account by linking newly created customer
    Given Manager clicks on open account tab
    When manager selects customer name
    And selects currency type
    And clicks on process button
    Then manager closes confirmation alert for account creation