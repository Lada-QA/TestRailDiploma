Feature: Suite

  Scenario: User add new section for project
    Given User opens TestRail login page
    And filling in standard email and password on Login page
    When User clicks login button
    And User add section 'This is a section test' and description 'This is description test' in project - This is a test project API
    Then Verify section was added

  Scenario: User add new test case for test suite
    Given User opens TestRail login page
    And  filling in standard email and password on Login page
    When User clicks login button
    And add test case 'This is a test case'
    Then Verify test case was added