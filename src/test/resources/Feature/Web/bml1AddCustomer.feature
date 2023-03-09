Feature: Bank Manager Login (addCustomer)

  @addCustomer
  Scenario Outline: Manager adds a customer
    Given Manager lands on the XYZ bank home page
    When manager clicks on bank manager login option
    And clicks on add customer tab
    And sends customer '<firstName>' and '<lastName>' and '<postCode>'
    And clicks on add customer button
    Then manager closes confirmation alert for newly added customer

    Examples:
      | firstName | lastName | postCode |
      | john      | test     | 1111     |