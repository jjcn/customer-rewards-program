# customer-rewards-program
A reward program backend, built with Spring Boot + Java 8, access with RESTful API.

## Reward Point Calculation
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every
dollar spent over $50 in each transaction.
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points)

## Dataset
The H2 database is pre-populated with data:
| customer ID | YearMonth | Amount of Purchase |
| :---: | :---: | :---: |
(1, 202112, 1),
(1, 202112, 50),
(1, 202112, 75),

(1, 202201, 100),
(2, 202201, 101),
(2, 202201, 0),

(1, 202202, 100),
(2, 202202, 100),

(1, 202203, 100),
(3, 202203, 100);