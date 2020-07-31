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

  Scenario: Check Items counter
    Given I am navigate to "http://magento.mainacad.com/" url
    And I choose "AUTO" language
    And I move the cursor to "HOME & DECOR" button
    And I chose "Electronics" page from list
    And I tap on "View As List" Button
    When I choose "Twentyfive" of items on page
    Then I compare or the count of elements on the page equals elements on the page

