# Mini Search Engine (Java)

## Project Description

The Mini Search Engine is a console-based Java application that simulates the core functionality of a basic search engine. The system allows users to store documents and perform keyword-based searches on them. It processes text content, indexes the words, and retrieves relevant documents when a user enters a search query.

The project demonstrates how search engines organize and retrieve information using Data Structures and Algorithms. It uses Java collections to store and manage indexed words, enabling efficient lookup and search operations.

This project focuses on implementing the backend logic of a search system and understanding how document indexing and keyword searching work internally.


## Features

- Add multiple documents to the system
- Search using a single keyword
- Search using multiple keywords
- Highlight searched words in results
- Simple document indexing
- Console-based user interaction


## Technologies Used

- Java
- Data Structures (HashMap, List, Set)
- String Processing
- Object-Oriented Programming


## Project Structure

MiniSearchEngine
│
├── Main.java
│
├── engine
│   └── SearchEngine.java
│
├── model
│   └── Document.java
│
└── utils
    └── TextProcessor.java


## How to Run the Project

1. Clone the Repository

git clone https://github.com/your-username/mini-search-engine.git

2. Navigate to Project Folder

cd mini-search-engine

3. Compile the Java Files

javac Main.java engine/*.java model/*.java utils/*.java

4. Run the Program

java Main


## Example Usage

Enter document content:
Java is a powerful programming language

Enter search keyword:
Java

Search Results:
Document 1 → Java is a powerful programming language


## Learning Outcomes

- Understanding the basics of search engine design
- Implementing document indexing
- Working with Java collections
- Building console-based applications
