Feature:

  Background: Connect to api
    Given I establish a connection to the api service

  @US101
  Scenario:Get all posts
    When I send get request to "public/v2/posts"
    Then Status code should bee 200