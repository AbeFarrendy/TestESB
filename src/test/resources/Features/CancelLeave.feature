Feature: test Cancel Leave functionality

  Scenario: User Cancels Leave
    Given user is logged in5
    And user is in my leave
    When user clicks cancel
    Then user successfully cancels leave