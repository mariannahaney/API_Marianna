Feature:

  Background: Connect to api
    Given I establish a connection to the api service

  @US100
Scenario:Get all users
When I send get request to "public/v2/users"
Then Status code should bee 200
And The result should have more than 1 user