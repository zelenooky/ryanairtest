Feature: This test feature is automating a booking flight process in one way for 2 adults and 1 child with
  card details and visible payment declined message for invalid card input.

  Scenario: Automate a booking up to a declined payment
    Given I make a booking from “DUB” to “SXF” on "22/10/2017" for "2" adults and "1" child
    When I pay for booking with card details “5555555555555557”, “10/18” and “265”
    Then I should get payment declined message