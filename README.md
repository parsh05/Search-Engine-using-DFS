# Search Engine Using DFS

This project implements a simple search engine web application using Java servlets, JSP, and MySQL. The application allows users to search for keywords, stores search history, and retrieves search results ranked based on keyword occurrences.

---

## Features

- **Search Functionality:** Users can search for keywords, and the application retrieves results ranked by keyword frequency.
- **Search History:** Keeps a record of user search queries and their corresponding links.
- **Responsive Design:** Styled using CSS for a clean and user-friendly interface.

---

## Technologies Used

- **Frontend:** JSP, HTML, CSS
- **Backend:** Java Servlets, JDBC
- **Database:** MySQL
- **Build Tool:** Maven
- **Server:** Apache Tomcat (or any other servlet container)

---

## Project Structure

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/MySearch/
│   │       ├── DatabaseConnection.java
│   │       ├── History.java
│   │       ├── HistoryResult.java
│   │       ├── Search.java
│   │       └── SearchResult.java
│   ├── webapp/
│       ├── WEB-INF/
│       │   └── web.xml
│       ├── styles.css
│       ├── index.jsp
│       ├── search.jsp
│       └── history.jsp
└── pom.xml
```

---

## Setup and Installation

1. **Clone the Repository:**
   ```bash
   git clone <repository_url>
   cd SearchEngineUsingDFS
   ```

2. **Set Up Database:**
   - Create a MySQL database named `searchEngineApp`.
   - Create the necessary tables:
     ```sql
     CREATE TABLE history (
         keyword VARCHAR(255),
         link VARCHAR(255)
     );

     CREATE TABLE pages (
         pageTitle VARCHAR(255),
         pageLink VARCHAR(255),
         pageText TEXT
     );
     ```
   - Populate the `pages` table with sample data for testing.

3. **Update Database Credentials:**
   - Edit `DatabaseConnection.java` to match your MySQL credentials:
     ```java
     String user = "your_username";
     String password = "your_password";
     String db = "searchEngineApp";
     ```

4. **Build and Deploy:**
   - Build the project using Maven:
     ```bash
     mvn clean install
     ```
   - Deploy the generated `.war` file to a servlet container (e.g., Apache Tomcat).

5. **Run the Application:**
   - Access the application in your browser at `http://localhost:8080/SearchEngineUsingDFS`.

---

## Usage

1. **Search for Keywords:**
   - Enter a keyword on the home page and click "Search."
   - View search results ranked by keyword frequency.

2. **View Search History:**
   - Navigate to `/history.jsp` to view past searches.

---

## Dependencies

- JUnit (for testing)
- MySQL Connector/J

---


