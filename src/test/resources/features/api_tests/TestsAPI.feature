Feature: API Tests

  @SmokeTest @API
  Scenario: Add a new project using API
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    Then Verify project is created successfully via API

  @SmokeTest @API
  Scenario: Update the project using API
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    And User send POST request for updating the project 'This is a test project API' with changed announcement 'Happy weekends' using API
    Then  Verify project is created successfully via API

  @SmokeTest @API
  Scenario: Add new suite in the project
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    And User send POST request for add new suite 'This is a new test suite' with description 'Use the description to add additional context details' in the project using API
    Then Verify suite is created successfully via API

  @SmokeTest @API
  Scenario: Delete project - This is a test project API
    Given User send POST to create a new project 'This is a test project API' using API
    Then User send POST request for delete the project 'This is a test project API'
    And Verify project is delete successfully via API