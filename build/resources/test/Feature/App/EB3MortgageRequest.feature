Feature:
  @mortgageRequest
 Scenario Outline:
    Given user clicks on the mortgage request tab
    When user inserts '<firstName>' and '<lastName>'
    And user selects '<age>' and '<address1>' and '<address2>'
    And selects country for mortgage
    And press next button
    And selects type of loan from dropdown
    And selects number of years from dropdown
    And selects type of occupation from dropdown
    And selects yearly income from dropdown
    Then closes mortgage payment by clicking on save button
    Examples:
      | firstName | lastName | age | address1 | address2 |
      | john      | test     | 30  | road 19  | Banani   |