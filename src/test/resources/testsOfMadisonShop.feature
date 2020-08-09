@All
Feature: "Madison Island" Shop

  @Muted
  Scenario: Go to registration page and check that all fields present
    Given I am navigate to "http://magento.mainacad.com/" url
    And I choose "AUTO" language
    And I tap on "Account" button
    And I tap on "My Account" button
    When I tap on "Create An Account" button
    Then I check if "First Name Field" present
    Then I check if "Last Name Field" present
    Then I check if "Email Address Field" present
    Then I check if "Password Field Field" present
    Then I check if "Confirm Pass Field" present

  @Muted
  Scenario: Check Items counter
    Given I am navigate to "http://magento.mainacad.com/" url
    And I choose "AUTO" language
    And I move the cursor to "HOME & DECOR" button
    And I chose "Electronics" page from list
    And I tap on "View As List" Button
    When I choose "Twentyfive" of items on Electronics page
    Then I compare or the count of elements on the page equals elements on the page

  @Muted
  Scenario: Check “SHOW” select
    Given I am navigate to "http://magento.mainacad.com/" url
    And I choose "AUTO" language
    And I move the cursor to "HOME & DECOR" button
    And I chose "Electronics" page from list
    And I tap on "View As List" Button
    When I choose "Five" of items on Electronics page
    Then I verify that only 5 items are shown on each page

  @Muted
  Scenario: Check “SORT BY”
    Given I am navigate to "http://magento.mainacad.com/" url
    And I choose "AUTO" language
    And I move the cursor to "HOME & DECOR" button
    And I chose "Electronics" page from list
    And I tap on "View As List" Button
    And I choose "Twentyfive" of items on Electronics page
    When I select type "Price" of Sort By
    Then I verify sort by price

  @Muted
  Scenario: Check “PRICE” filter
    Given I am navigate to "http://magento.mainacad.com/" url
    And I choose "AUTO" language
    And I move the cursor to "HOME & DECOR" button
    And I chose "Electronics" page from list
    And I tap on "View As List" Button
    And I choose "Twentyfive" of items on Electronics page
    When I tap on "$0.00 - $999.99" price from "Shop By"
    Then I verify that the price of all items is less than "999.99"

  @Muted
  Scenario: Check “Add to Wishlist”
    Given I am navigate to "http://magento.mainacad.com/" url
    And I choose "AUTO" language
    And I tap on "Account" button
    And I tap on "My Account" button
    And I tap on "Create An Account" button
    And I input "Test" in User Name
    And I input "Testovich" in Last Name
    And I input Email Address on Registration Page
    And I input password: "qwert1234" on Registration Page
    And I confirm password: "qwert1234"
    And I tap on "Register" button
    And I move the cursor to "HOME & DECOR" button
    And I chose "Electronics" page from list
    And I tap on "View As List" Button
    And I choose "Twentyfive" of items on Electronics page
    When I choose any random item and tap on "Add to Wishlist" button
    Then I check if name of the chosen item is present

  @Muted
  Scenario: Check “SALE”
    Given I am navigate to "http://magento.mainacad.com/" url
    And I choose "AUTO" language
    And I tap on the "Sale" button
    And I tap on "grid view" button on "Sale" page
    When I choose "ThirtySix" of items on Sale page
    Then I verify that the old price is higher than a sale price for each item


  Scenario: “SHOPING CART”
    Given I am navigate to "http://magento.mainacad.com/" url
    And I choose "AUTO" language
    And I tap on "Account" button
    And I tap on "My Account" button
    And I tap on "Create An Account" button
    And I input "Test" in User Name
    And I input "Testovich" in Last Name
    And I input Email Address on Registration Page
    And I input password: "qwert1234" on Registration Page
    And I confirm password: "qwert1234"
    And I tap on "Register" button
    And I move the cursor to "HOME & DECOR" button
    And I chose "Electronics" page from list
    And I tap on "grid view" button on "Electronics" page
    And I choose "ThirtySix" of items on "Electronics" page on Grid view
    When I choose any random item and tap on "ADD TO CART" button
    Then I verify that "SHOPPING CART" page is open
    Then I verify that name and price are of the chosen item
    Then I verify that "SUBTOTAL" amount is equal to the sum of "GRAND TOTAL"