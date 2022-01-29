Feature: Test runs and result

  @SmokeTest @Ui
  Scenario: User add new test run for project
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    And User send POST request for add new suite 'This is a new test suite' with description 'Use the description to add additional context details' in the project using API
    And User opens TestRail login page
    And filling in standard email and password on Login page
    And User clicks login button
    And goes to the project and add new milestone 'This is Milestone'
    When goes to the project and add new test run
    Then Verify test run was added

    @SmokeTest @Ui
  Scenario: User adds new test and the test result
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    And User send POST request for add new suite 'This is a new test suite' with description 'Use the description to add additional context details' in the project using API
    And User opens TestRail login page
    And filling in standard email and password on Login page
    And User clicks login button
    And User add section 'This is a test' and description 'This is description test' in project - This is a test project API
    And User add new test case 'Result test' in section
    When goes to the runs page and add the test result
    Then Verify test result was added