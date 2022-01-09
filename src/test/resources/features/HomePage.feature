Feature: Logout

  Scenario: User logs out
    Given User opens TestRail login page
    And filling in standard email and password on Login page
    When User clicks login button
    And the user successfully logs out of the system
    Then Verify Login page is opened

  Scenario: Add a new project using API
    Given User set POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    Then Verify project is created successfully via API

  Scenario: Update the project using API
    Given User set POST request for updating the project 'This is a test project API' with changed announcement 'Happy weekends' using API
    Then  Verify project is created successfully via API