Feature: Test runs

  Scenario: User add new test run for project
    Given User opens TestRail login page
    And filling in standard email and password on Login page
    When User clicks login button
    And goes to the project and add new test run
    Then Verify test run was added