@All_tests
Feature: Google Search
  @Google
  Scenario: search functionality test
    Given I navigate to "https://www.google.com"
    Then title should be "Google"
    And element with xpath "//*[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//*[@name='q']"
    And I click on element with xpath "//div[@class='lJ9FBc']//input[@name='btnK']"
    And I wait for element with xpath "//h3[normalize-space()='Behavior-driven development']" to be present
    Then element with xpath "//h3[normalize-space()='Behavior-driven development']" should contain text "development"
    
    @bing
    Scenario: Bing search
      Given I navigate to "https://www.bing.com"
      Then title should be "Search - Microsoft Bing"
      And element with xpath "//textarea[@id='sb_form_q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//textarea[@id='sb_form_q']"
      And then I hit enter
#      Then I wait 2 seconds
      And I wait for element with xpath "//a[normalize-space()='Behavior-driven development - Wikipedia']" to be present
      Then element with xpath "//a[normalize-space()='Behavior-driven development - Wikipedia']" should contain text "development"