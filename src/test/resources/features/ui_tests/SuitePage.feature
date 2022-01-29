Feature: Suite

  @SmokeTest @Ui
  Scenario: User add new section for project
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    And User send POST request for add new suite 'This is a new test suite' with description 'Use the description to add additional context details' in the project using API
    And User opens TestRail login page
    And filling in standard email and password on Login page
    And User clicks login button
    When User add section 'This is a section test' and description 'This is description test' in project - This is a test project API
    Then Verify section was added

  @SmokeTest @Ui
  Scenario: User add new test case for test suite
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    And User send POST request for add new suite 'This is a new test suite' with description 'Use the description to add additional context details' in the project using API
    And User opens TestRail login page
    And filling in standard email and password on Login page
    And User clicks login button
    When add test case 'This is a test case'
    Then Verify test case was added