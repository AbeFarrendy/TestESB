Feature: Test Update Contact Details functionality

  Scenario: User Updates Contact Details successfully
    Given user is logged in3
    And user is in my info contact details
    When user updates contact details
    And user clicks save2
    Then user successfully updated contact details