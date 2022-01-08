Feature: Logout

  Scenario: User logs out
    Given User opens TestRail login page
    And filling in standard email and password on Login page
    When User clicks login button
    And the user successfully logs out of the system
    Then Verify Login page is opened

  Scenario: Add a new project using API
    Given User set POST a new project using API
    Then Verify project is created successfully via API