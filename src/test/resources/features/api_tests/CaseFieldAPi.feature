Feature: Case field

  Scenario: Add a new case field
    When User send POST request for add new case field with Random name
    Then Verify case field is created successfully via API