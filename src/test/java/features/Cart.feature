Feature: Cart

  Scenario: Add a t-shirt on cart
    Given I am on the Landing page
    When I add the t-shirt to cart
    Then I should see successfully message

  Scenario: Go to checkout by Proceed to checkout button
    Given I am on the Landing page
    When I add the t-shirt to cart
    And I click on Proceed to checkout button
    Then I should be redirected to Order page
    And I should see my added product

  Scenario: Go to checkout by Shopping cart button
    Given I am on the Landing page
    When I add the t-shirt to cart
    And I click on Shopping cart button
    Then I should be redirected to Order page
    And I should see my added product

  Scenario: Remove item from cart by trash button
    Given I am on the Landing page
    And I have one t-shirt in cart
    And I am on the Order page
    When I delete the product
    Then I should see the cart empty

  Scenario: Remove item from cart by minus button
    Given I am on the Landing page
    And I have one t-shirt in cart
    And I am on the Order page
    When I click on minus button
    Then I should see the cart empty

  Scenario: Change quantity by text
    Given I am on the Landing page
    And I have one t-shirt in cart
    And I am on the Order page
    When I type 10 on quantity
    Then I should see "$167.10" on Total field

  Scenario: Change quantity by plus button
    Given I am on the Landing page
    And I have one t-shirt in cart
    And I am on the Order page
    When I click on plus button
    Then I should see "$35.02" on Total field

  Scenario: Change quantity by minus button
    Given I am on the Landing page
    And I have one t-shirt in cart
    And I am on the Order page
    And I add one more t-shirt
    When I click on minus button
    Then I should see "$18.51" on Total field

  Scenario: Shop as a guess
    Given I am on the Landing page
    And I have one t-shirt in cart
    And I am on the Order page
    When I Proceed to chekcout
    Then I should be redirected to Login tab

  Scenario: Shop authenticated
    Given I am logged
    And I have one t-shirt in cart
    And I am on the Order page
    When I Proceed to chekcout
    Then I should be redirected to Address tab

  Scenario: Proceed without agree the terms of service
    Given I am logged
    And I have one t-shirt in cart
    And I am on the Order page
    And I proceed to Shipping tab
    When I click on Proceed to Payment whiout check therms
    Then I should see "You must agree to the terms of service before continuing." alert

  Scenario: Finish paying by bank wire
    Given I am logged
    And I have one t-shirt in cart
    And I am on the Order page
    And I proceed to Shipping tab
    And I click on Proceed to Payment
    When I select pay by bank wire
    And I confirm my order
    Then I should see order confirmation by bank wire

  Scenario: Finish paying by check
    Given I am logged
    And I have one t-shirt in cart
    And I am on the Order page
    And I proceed to Shipping tab
    And I click on Proceed to Payment
    When I select pay by check
    And I confirm my order
    Then I should see order confirmation by check




