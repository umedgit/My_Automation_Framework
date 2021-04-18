Feature: Add to card as a guest
  Scenario: As a guest, I want to add a searched item into cart

    Given navigate to "https://www.amazon.com/"
    And user is on "Amazon Main Page"
    When user types "qa testing for beginners" into "Search field"
    And user clicks on "Search button"
    Then a list of items should display
    When user gets the price and clicks on the first item on the list



