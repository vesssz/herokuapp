Feature: Login

  Scenario: Login with valid credentials
    Given user is on landing page
    When user clicks Basic Auth link
    And user enters username "admin" and password "admin" in the form
    Then user is logged in and a confirmation message appears

  Scenario: Login with invalid credentials
    Given user is on landing page
    When user clicks Basic Auth link
    And user enters username "invalidUsername" and password "invalidPassword" in the form
    Then user is not logged in