Feature: Test Add Job Title functionality

  Scenario: User adds job title
    Given user is logged in4
    And user is in my info job
    When user updates job title
    Then user attempted to update job title