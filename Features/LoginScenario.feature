Feature: Login scenario

  @Preethi
  Scenario Outline: 
    Given User is on home Page
    When User clicks on Account icon
    Then User enters "<email>" and "<password>" details
    And User clicks on login button

    Examples: 
      | email             | password |
      | manzoor@gmail.com | manzoor  |
