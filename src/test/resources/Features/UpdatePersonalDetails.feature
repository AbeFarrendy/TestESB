Feature: Test Update Personal Details functionality

  Scenario: User Update Personal Details successfully
    Given user is logged in2
    And user is in my info personal details
    When user updates personal details
    And user clicks save
    Then user successfully updated personal details
