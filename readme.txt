================================================================================
                        LIBRARY MANAGER
                    Java Console Application
================================================================================

DESCRIPTION
-----------
Java console application for managing a book collection.
You can add, display, modify and delete books with their detailed information
(title, author, price, number of pages, reading status).

ARCHITECTURE
------------
The project follows a layered architecture:

- Frontend (User Interface)
  * Menu.java          : Main application menu
  * BookView.java      : Display management and user interactions

- Backend (Business Logic)
  * Models
    - Book.java        : Data model representing a book
  * Services
    - BookService.java : Book management service (CRUD)
  * Enums
    - BookReadStatus.java : Possible reading statuses (NOT_STARTED, STARTED, FINISHED)

- App.java            : Application entry point

FEATURES
--------
1. Add a book
   - Enter title, author, price, number of pages
   - Select reading status (Not started, Started, Finished)
   - Automatic generation of a unique UUID for each book

2. Display all books
   - Numbered list of all books with their titles

3. Display a book
   - Detailed display of a selected book (all information)

4. Modify a book
   - Modify all fields of a book
   - Option to keep current values by pressing Enter
   - Error handling for numeric fields

5. Delete a book
   - Remove a book from the collection

6. Exit the application

PREREQUISITES
-------------
- Java JDK 8 or higher
- Maven 3.6 or higher
- Lombok (automatically generated via Maven)

DEPENDENCIES
------------
- Lombok 1.18.34 : Reduces boilerplate code (getters, setters, etc.)
- Log4j2 2.24.1 : Log management
- JUnit 3.8.1 : Unit tests

INSTALLATION
------------
1. Clone or download the project
2. Open a terminal in the project directory
3. Compile the project with Maven:
   mvn clean compile

EXECUTION
---------
1. Compile and run with Maven:
   mvn clean compile exec:java -Dexec.mainClass="com.amolixs.App"

   OR

2. Compile first:
   mvn clean package
   
   Then run the JAR:
   java -cp target/classes com.amolixs.App

PROJECT STRUCTURE
-----------------
library-manager/
├── pom.xml                                    # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/amolixs/
│   │   │       ├── App.java                   # Entry point
│   │   │       ├── frontend/
│   │   │       │   ├── Menu.java              # Main menu
│   │   │       │   └── BookView.java          # Book view
│   │   │       └── backend/
│   │   │           ├── models/
│   │   │           │   └── Book.java          # Book model
│   │   │           ├── services/
│   │   │           │   └── BookService.java   # Management service
│   │   │           └── enums/
│   │   │               └── BookReadStatus.java # Status enum
│   │   └── resources/
│   │       └── log4j2.xml                     # Log4j2 configuration
│   └── test/
│       └── java/
│           └── com/amolixs/
│               └── AppTest.java               # Unit tests
└── target/                                    # Compiled files

USAGE
-----
When the application starts, a menu is displayed:

1-Add a book
2-Display books
3-Display a book
4-Modify a book
5-Delete a book
6-Exit
[*] Your choice: 

Select an option by typing the corresponding number and follow the instructions.

USAGE EXAMPLE
-------------
1. Add a book:
   - Choose option 1
   - Enter title: "The Red and the Black"
   - Enter author: "Stendhal"
   - Enter price: 9.99
   - Enter number of pages: 500
   - Choose status: 0 (Not started), 1 (Started) or 2 (Finished)

2. Display all books:
   - Choose option 2
   - The numbered list is displayed

3. Modify a book:
   - Choose option 4
   - Select the number of the book to modify
   - For each field, enter a new value or press Enter
     to keep the current value

TECHNICAL FEATURES
------------------
- Layered architecture (frontend/backend separation)
- Use of Lombok to reduce boilerplate code
- Exception handling (InputMismatchException, NumberFormatException)
- Automatic UUID generation for each book
- Interactive console interface with Scanner
- User input validation

AUTHOR
------
Developed by javaamodev

VERSION
-------
1.0-SNAPSHOT

LICENSE
-------
This project is provided as-is, without warranty.

================================================================================
