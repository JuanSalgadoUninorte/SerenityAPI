# language: en
  # author: Juan Salgado
Feature: Create an user on Reqres.in
  I want to create an user

  Scenario: Creation an user
    When You create an user
      | name    | job  |
      | brandon | java |
    Then I should see the user created