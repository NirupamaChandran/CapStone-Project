Feature: Validate the micro functionalities at the bottom of home page
  @web
  Scenario: Verify user can access the micro functionalities
    When user opens website
    And user clicks on about us link
    Then verify whether about us page is displayed
    When user clicks on contact us
    Then verify contact us page is displayed
