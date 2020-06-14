@Exercise
Feature: Exercise

  Scenario: Automation Exercise
    Given I navigate to Home page
      And select "Best Sellers" tab
    Then the "Printed Chiffon Dress" discount is "20%"
    When I add "Printed Chiffon Dress" to Cart
      And click 'Continue Shopping' button
      And add "Blouse" to Cart
      And click 'Continue Shopping' button
      And click Check out from Cart
    Then verify following items are displayed in the summary table
      | Printed Chiffon Dress | In stock |
      | Blouse                | In stock |
      And remove "Blouse" from Cart
    Then verify following item is not displayed in the summary table
      | Blouse | In stock |
      And verify total amount to pay is "$18.40"
