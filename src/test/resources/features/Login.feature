Feature: Login
  Scenario: Login in TestRail site with valid data
    Given Open site TestRail
    When Filling fields with email and password
    Then Click login button and getting to the main page of the site