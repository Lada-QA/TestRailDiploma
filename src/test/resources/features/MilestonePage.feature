Feature: Test milestone

  Scenario: User add new milestone for project
    Given User opens TestRail login page
    And filling in standard email and password on Login page
    When User clicks login button
    And goes to the project and add new milestone 'This is Milestone'
    Then Verify milestone was added