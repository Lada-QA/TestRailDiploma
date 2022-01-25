Feature: Test runs

  @SmokeTest @Ui
  Scenario: User add new test run for project
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    And User send POST request for add new suite 'This is a new test suite' with description 'Use the description to add additional context details' in the project using API
    When User opens TestRail login page
    And filling in standard email and password on Login page
    When User clicks login button
    And goes to the project and add new milestone 'This is Milestone'
    Then goes to the project and add new test run
    And Verify test run was added