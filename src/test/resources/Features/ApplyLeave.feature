Feature: test Apply Leave functionality

  Scenario: User Applies Leave
    Given user is logged in
    And user is in apply leave
    When user inputs leave details
    And user clicks apply
    Then user successfully applied leave