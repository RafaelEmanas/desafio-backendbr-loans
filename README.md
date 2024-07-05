A challenge i coded, in order to better understand how to use Java and its framework spring boot.
Disclaimer: I used chatgpt 4o to translate the text below, the original text is is in this link: https://github.com/backend-br/desafios/blob/master/loans/PROBLEM.md

Loans

Your challenge will be to implement a service that determines which types of loans a person has access to.
Example

The types of loans to be analyzed are:

    Personal loan: Interest rate of 4%.
    Payroll loan: Interest rate of 2%.
    Secured loan: Interest rate of 3%.

The types of loans available to a person are based on specific variables, which are:

    Age
    Income
    Location

Your service receives a request to determine which types of loans a person has access to.

bash

[POST] {{host}}/customer-loans

{
  "age": 26,
  "cpf": "275.484.389-23",
  "name": "Vuxaywua Zukiagou",
  "income": 7000.00,
  "location": "SP"
}

Your service should return a response containing the customer's name and a list of loans they have access to, with the respective types and interest rates.


HTTP/1.1 200 Ok

{
  "customer": "Vuxaywua Zukiagou",
  "loans": [
    {
      "type": "PERSONAL",
      "interest_rate": 4
    },
    {
      "type": "GUARANTEED",
      "interest_rate": 3
    },
    {
      "type": "CONSIGNMENT",
      "interest_rate": 2
    }
  ]
}

Requirements

    Grant the personal loan if the customer's income is equal to or less than R$ 3000.
    Grant the personal loan if the customer's income is between R$ 3000 and R$ 5000, if the customer is under 30 years old and resides in São Paulo (SP).
    Grant the payroll loan if the customer's income is equal to or greater than R$ 5000.
    Grant the secured loan if the customer's income is equal to or less than R$ 3000.
    Grant the secured loan if the customer's income is between R$ 3000 and R$ 5000, if the customer is under 30 years old and resides in São Paulo (SP).

