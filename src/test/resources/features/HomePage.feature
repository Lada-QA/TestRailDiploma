Feature: Logout

  Scenario: User logs out
    Given User opens TestRail login page
    And filling in standard email and password on Login page
    When User clicks login button
    And the user successfully logs out of the system
    Then Verify Login page is opened

  Scenario: Add a new project using API
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    Then Verify project is created successfully via API

  Scenario: Update the project using API
    Given User send POST request for updating the project 'This is a test project API' with changed announcement 'Happy weekends' using API
    Then  Verify project is created successfully via API

  Scenario: Add new suite in the project
    Given User send POST request for add new suite 'This is a new test suite' with description 'Use the description to add additional context details' in the project using API
    Then Verify suite is created successfully via API

  Scenario: Delete project - This is a test project API
    Given User send POST request for delete the project 'This is a test project API'
    Then Verify project is delete successfully via API