Feature: Online Process

  @goToWebsite
  Scenario: Website Test Scenario
    Given Go to "http://www.google.com/"
    When Wait "3" seconds
    And Send keys to element by css "input[role='combobox']" text "testinium"
    And Send key code to element by css "input[role='combobox']" code "ENTER"
    Then Wait "3" seconds
