Feature: Test milestone

  @SmokeTest
  Scenario: User add new milestone for project
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    When User opens TestRail login page
    And filling in standard email and password on Login page
    When User clicks login button
    And goes to the project and add new milestone 'This is Milestone'
    Then Verify milestone was added