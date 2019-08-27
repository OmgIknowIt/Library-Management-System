# Library Management System
Users can use this interface to collect books.
## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
### Prerequisites
To run this project you need: 
* [MySQL Workbench](https://www.mysql.com/products/workbench/)
* [Spring Tool Suite](https://spring.io/tools) or [IntelliJ IDEA](https://www.jetbrains.com/idea/) with [Maven](https://maven.apache.org/download.cgi).

When workbench will be installed launch it and import project's database from "DB" folder to mysql workbench.
After that launch project and follow the link http://localhost:8080.

## Interface
After logging in:
* as admin, user can add autors, genres and books. Firstly admin should add author and genre before adding a book (if author or genre of a book doesn't exist in the databse).
* as a common user, user can search books and download them.
