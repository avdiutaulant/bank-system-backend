#Bank System

This is a banking system mini-project developed using Java, PostgreSQL, Spring Boot, Maven and Docker.

#Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them:

Java 17 or higher
Docker

### Installing

A step by step series of examples that tell you how to get a development environment running:

1.Clone the repository:

https://github.com/avdiutaulant/bank-system-backend.git

2.Start the services, make sure you have Docker and Docker Compose installed on your system. Then, navigate to the directory containing the docker-compose.yml file and run the following command:

docker-compose up -d

## Usage

Bank Management Service exposes the following endpoints:

POST /api/banks: Creates bank.
POST /api/banks/{bankId}/accounts: Create an account in the specified bank
GET /api/banks/{bankId}/accounts: Get a list of accounts for a specific bank
GET /api/banks/{id}:  Get a bank by id / check bank total transaction fee amount, transfer amount

Account Management Service exposes the following endpoints:

GET /api/accounts/{id}: Get an account by id / check account balance
POST /api/accounts/{id}/withdraw: Withdraw money to an account 
POST /api/accounts/{id}/deposit: Deposit money to an account 
GET /api/accounts{id}/transactions: Get a list of transactions for a specific account

Transaction Management Service exposes the following endpoints:

POST /api/transactions: Add a transaction from one account to another including Flat Fee and Percent Fee transactionsr 


