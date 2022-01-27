Feature: Plans

  Scenario: Add new test plan
    Given User send POST a new project 'This is a test project API' and announcement 'This is test project for API' using API
    And User send POST request for add new suite 'This is a new test suite' with description 'This is a description' in the project using API
    When User send POST request for add new test plan 'System test'
    Then Verify test plan is created successfully via API