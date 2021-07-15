Feature: As a public user i want to verify a Github users stars count

  Scenario: Verify that stars displayed is matching with the API response
    Given user is on users HomePage
    When user clicked on any of the Repo
    Then the Stars displayed is matching with the Git Hub API response

    