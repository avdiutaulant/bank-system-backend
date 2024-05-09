# Bank System

This is a banking system mini-project developed using Java, PostgreSQL, Spring Boot, Maven, and Docker.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Ensure you have the following installed:

- Java 17 or higher
- Docker

### Installation

Follow these steps to set up the development environment:

1. Clone the repository:
git clone https://github.com/avdiutaulant/bank-system-backend.git

 
2. Start the services:
- Ensure Docker and Docker Compose are installed on your system.
- Navigate to the directory containing the docker-compose.yml file.
- Run the following command:
  
  docker-compose up -d

## Usage

### Bank Management Service

Exposed endpoints:

- POST /api/banks: Creates a bank.
- POST /api/banks/{bankId}/accounts: Creates an account in the specified bank.
- GET /api/banks/{bankId}/accounts: Retrieves a list of accounts for a specific bank.
- GET /api/banks/{id}: Retrieves a bank by id / checks bank total transaction fee amount, transfer amount.

### Account Management Service

Exposed endpoints:

- GET /api/accounts/{id}: Retrieves an account by id / checks account balance.
- POST /api/accounts/{id}/withdraw: Withdraws money from an account.
- POST /api/accounts/{id}/deposit: Deposits money to an account.
- GET /api/accounts{id}/transactions: Retrieves a list of transactions for a specific account.

### Transaction Management Service

Exposed endpoints:

- POST /api/transactions: Adds a transaction from one account to another including Flat Fee and Percent Fee transactions.



