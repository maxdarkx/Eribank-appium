Feature: I as an eribank user
  want to make a payment
  To another user account

  Scenario Outline: Juan makes a payment
    Given Juan login into eribank application account using account "company" and password "company"
    When he makes a transaction using data:
      | phone   | name   | amount   | country   |
      | <phone> | <name> | <amount> | <country> |
    Then he should see that the correct amount was sent

    Examples:
      | phone       | name                | amount | country     |
      | 501         | Alberto Marino      | 10     | NEW_ZEALAND |
      | 467 1005090 | Conrad Spencer      | 99     | IRELAND     |
      | 5012678945  | Jose Cansino        | 50     | USA         |
      | 8012678945  | Maria De Las Nieves | 10     | AUSTRALLIA  |
      | 8012678945  | Maria De Las Nieves | 20     | CANADA      |
      | 801267945   | Jose De Las Nieves  | 15     | RUSSIA      |
      | 801267945   | Alberto maya        | 20     | COLOMBIA    |
      | 5012678945  | Jose Cansino        | 50     | ICELAND     |
      | 501         | Alberto Marino      | 10     | GREECE      |
      | 501         | Juan Maya           | 10     | JAPAN       |
      | 801267945   | Alberto maya        | 20     | ITALY      |