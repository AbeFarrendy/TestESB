Feature: test Login Logout functionality

  Scenario: User Login Logout successful
    Given user is on login page
    When user enters username and password
    And user clicks on login button
    Then user is navigated to the homepage
    And user logs out

