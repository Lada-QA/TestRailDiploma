Feature: Login
  Scenario: Login in TestRail site with valid data
    Given User opens TestRail base page
    When Filling fields with email and password
    Then Click login button