Mini Search Engine (Java + Data Structures)

A console-based Mini Search Engine built using Java and Data Structures & Algorithms.
This project demonstrates how search engines process text documents, build indexes, and retrieve results efficiently.

The system supports document indexing, keyword search, multi-word search, phrase search, autocomplete, and search history tracking.

🚀 Features
1️⃣ Add Document

Users can insert text documents into the search engine.
Each document is automatically assigned a unique Document ID.

2️⃣ AutoComplete

Suggests words based on a prefix input.

Example:

Input:
Prefix → dat

Output:
data
database
dataset
3️⃣ Single Word Search

Search for documents containing a specific word.

Example:

Input:
data

Output:
Document ID: 1
"data" structures are important in computer science

The searched word is highlighted with quotes.

4️⃣ Multi Word Search

Users can search multiple words separated by commas.

Example:

Input:
data,structures

Output shows documents containing both words, with highlighted results.

"data" "structures" are important for algorithms
5️⃣ Phrase Search

Search for an exact phrase inside documents.

Example:

Input:
"data structures"

Output:

Document ID: 2
Learning "data structures" improves problem solving
6️⃣ Delete Document

Allows users to remove documents from the index using Document ID.

7️⃣ Show Vocabulary

Displays all indexed words in the search engine.

Example:

algorithms
computer
data
structures
tree
8️⃣ Search History

Tracks previous search queries.

Example:

Search History:
data
algorithms
data,structures



How to Run the Project
1️⃣ Clone the repository
git clone https://github.com/yourusername/mini-search-engine.git
2️⃣ Compile the project
javac Main.java
3️⃣ Run the program
java Main
