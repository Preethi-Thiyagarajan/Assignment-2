Feature: Registration scenario

  @Preethi
  Scenario Outline: 
    Given User is on home Page
    When User clicks on Account icon
    When User clicks on Login/Register link
    Then User enters "<data>" mandatory fields and click on Register button
    And User verifies the success message

    Examples: 
      | data                  |
      | RegistrationData.xlsx |
