Feature: Bank Manager Login (deleteCustomer)

  @deleteCustomer
  Scenario: Manager deletes the new customer
    Given manager clicks on the customers tab
    When manager searches for the newly added customer
    Then manager deletes the customer

