Feature:
  @expenseReport
  Scenario:
    Given user taps on the expense report button
    When user adds two  expense report
    And removes one report
    Then user goes back and logs out and quits the app