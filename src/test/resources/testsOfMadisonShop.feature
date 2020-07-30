@All
Feature: "Madison Island" Shop

  Scenario: Go to registration page and check that all fields present
    Given I am navigate to "http://magento.mainacad.com/" url
    And I choose "AUTO" language
    And I tap on "Account" Button
    And I tap on "My Account" button
    When I tap on "Create An Account" Button
    Then I check if "First Name Field" present
    Then I check if "Last Name Field" present
    Then I check if "Email Address Field" present
    Then I check if "Password Field Field" present
    Then I check if "Confirm Pass Field" present