Feature: Logout

  @SmokeTest @Ui
  Scenario: User logs out
    Given User opens TestRail login page
    And filling in standard email and password on Login page
    When User clicks login button
    And the user successfully logs out of the system
    Then Verify Login page is opened