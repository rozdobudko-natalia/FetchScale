Feature: Find the best algorithm to find the fake gold bar

  @wip
  Scenario: Find the best algorithm
    Given user is on the fake gold bar page
    When user writes "first three gold bars numbers" in "left" bowl grid
    And user writes "second three gold bars numbers" in "right" bowl grid
    And user clicks on "Weigh" button
    Then user should see which side weighs more or less or the same
    When user clicks on "Reset" button
    And user writes "first gold bar number" in "left" bowl grid
    And user writes "second gold bar number" in "right" bowl grid
    And user clicks on "Weigh" button
    Then user should see which side weighs more or less or the same
    And user now selects number corresponding to the fake gold
    And user sees an alert "Yay! You found it!"






