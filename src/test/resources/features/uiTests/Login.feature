Feature: Login

  @SmokeTest @Ui
  Scenario: Login in TestRail site with valid data
    Given User opens TestRail login page
    And filling in standard email and password on Login page
    When User clicks login button
    Then Verify Home page is opened

  @SmokeTest @Ui
  Scenario: Login in TestRail site with invalid data
    Given User opens TestRail login page
    And filling in invalid email and password on Login page
    When User clicks login button
    Then User getting error text - Sorry, there was a problem.