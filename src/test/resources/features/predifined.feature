@All_tests
Feature: Google Search

  Scenario: search functionality test
    Given I navigate to "https://www.google.com"
    Then title should be "Google"
    And element with xpath "//*[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//*[@name='q']"
    And I click on element with xpath "//div[@class='lJ9FBc']//input[@name='btnK']"
    And I wait for element with xpath "//h3[normalize-space()='Behavior-driven development']" to be present
    Then element with xpath "//h3[normalize-space()='Behavior-driven development']" should contain text "development"