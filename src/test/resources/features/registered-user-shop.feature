Feature: User shopping on Luma website

  Scenario: User Shopping 2 man jacket and 1 man pants from product detail page
    Given user open chrome browser
    When user navigate to luma website
    And user click sign in on top of the page
    And user enter "TEST_EMAIL" and "TEST_PASSWORD"
    And user click sign in button
    And user navigate to product detail "MAN_TOP_MONTANA_WIND_JACKET"
    And user choose top size "L"
    And user choose color "RED"
    And user set quantity to "2"
    And user click add to cart button
    And user navigate to product detail "MAN_BOTTOM_YOGA_PANTS"
    And user choose bottom size "36"
    And user choose color "BLACK"
    And user click add to cart button
    And user click cart icon
    And user click proceed to checkout button
    And user verify order summary
    And user verify first product name is "Montana Wind Jacket"
    And user verify first product price is "$98.00"
    And user verify second product name is "Cronus Yoga Pant"
    And user verify second product price is "$48.00"
    And user click shipping method best way
    And user click button next
    And user click place order
    And user verify success message "Thank you for your purchase!" is displayed
    And user go to my order page
    And user click view my order to see order detail
    And user verify first product name on my order is "Montana Wind Jacket"
    And user verify first product price on my order is "$98.00"
    And user verify second product name on my order is "Cronus Yoga Pant"
    And user verify second product price on my order is "$48.00"
    Then user close browser
