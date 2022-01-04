Feature: Login
  Scenario: Login in TestRail site with valid data
    Given User opens TestRail login page
    And filling in standard email and password on Login page
    When User clicks login button
    Then Verify Home page is opened