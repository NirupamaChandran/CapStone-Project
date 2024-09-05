Feature: Validate navigation to tata cliq luxury

  @web
  Scenario: Verify user can navigate to tata luxury
    Given user opens website
    Then verify user is on homepage
    When user clicks tata cliq luxury from home page
    Then verify tata cliq luxury site is displayed