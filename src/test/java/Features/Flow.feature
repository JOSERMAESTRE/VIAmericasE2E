Feature: Sauce labs E2E

  Scenario Outline: Shopping flow
    Given User is on login page
    When User enters "<username>" and "<password>" and clicks login button
    Then The inventory is displayed
    Then User adds product "<product_name>" to cart
    Then User goes to the cart and verifies product "<product_name>"
    Then User proceeds to checkout with first name "<First_name>", last name "<Last_name>", and postal code "<Zip_cod>"
    Then User completes the checkout process
    Then The order confirmation message is displayed
    Examples:
      | username      | password     | product_name             | First_name | Last_name | Zip_cod |
      | standard_user | secret_sauce | Sauce Labs Fleece Jacket | joseR      | Maestre   | 20005   |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt  | Rafael     | Diaz      | 200005  |

