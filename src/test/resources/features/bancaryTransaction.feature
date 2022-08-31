Feature: I as an eribank user
  want to make a payment
  To another user account

  Scenario Outline: Juan makes a $50 payment
    Given Juan login into eribank application account using account "company" and password "company"
    When he makes a transaction using data:
      | phone   | name   | amount   | country   |
      | <phone> | <name> | <amount> | <country> |
    Then he should see that the correct amount was sent

    Examples:
      | phone          | name         | amount | country |
      | +39 5012678945 | Jose Cansino | 50     | Italy   |