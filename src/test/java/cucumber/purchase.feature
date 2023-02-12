@tag
Feature: Purchase products form ecommerce site

Background: 
Given User landed on the landing page

  @Regression
  Scenario: Purchase the product
    Given User is logged in with username <name> and password <password>
    When User add the product <productName> to cart
    And Checkout <productName> and submit the order
    Then order is placed and order id is generated successfully

    Examples: 
      | name               | password   | productName     |
      | qazplm@gmail.com   | Qazplm@890 | ZARA COAT 3     | 
      | abcxyz92@gmail.com | Abcxyz@123 | ADIDAS ORIGINAL |


 