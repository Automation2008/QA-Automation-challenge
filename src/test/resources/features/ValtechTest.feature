Feature: Purchasing and reviewing of order

  @test1
  Scenario: Valtech test
    Given I go to Test Url "https://www.valtech.com"
    And I accept the cookie
    Then I verify "LATEST NEWS" page is present
    And I click on toggle button
    And I click "About" page link
    Then I verify "About" page is present
    And I click on toggle button
    And I click "Services" page link
    Then I verify "Services" page is present
    And I click on toggle button
    And I click "Work" page link
    Then I verify "Work" page is present
    And I click on valtech logo
    And I click on contactUs toggle button
    Then I find number of offices
    
    
