Feature:

  @makePayment
  Scenario Outline:
    Given user clicks on thr make payment tab
    When user inserts '<phone>' and '<name>' and '<amount>'
    And user selects country
    And user clicks on send payment button
    Then user closes the alert selecting ok and confirms payment
    Examples:
      | phone | name | amount |
      | 12345 | john | 100    |
