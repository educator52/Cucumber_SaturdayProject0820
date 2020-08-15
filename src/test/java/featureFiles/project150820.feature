Feature: Project150820 Social Media Test

  Scenario: Successful link to social media in automationpractice.com
    Given I navigate to "http://automationpractice.com/index.php"
    Then I try to login in by email and password.
    And I click on following elemen and check them than can I reach to correct site.
      | facebook | twitter | youtube | google |
