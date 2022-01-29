Feature: Test milestone

  @SmokeTest @Ui
  Scenario: User add new milestone for project
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    And User opens TestRail login page
    And filling in standard email and password on Login page
    And User clicks login button
    When goes to the project and add new milestone 'This is Milestone'
    Then Verify milestone was added