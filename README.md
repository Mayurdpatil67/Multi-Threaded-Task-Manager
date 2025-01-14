## Multi-threaded Task Manager

This is a simple multi-threaded task manager system that allows you to add, update, remove, and process tasks concurrently. The system demonstrates key concepts of **Object-Oriented Programming (OOP)**, **multithreading**, **exception handling**, **generics**, **Java Collections**, and **streams**.

## Features
- **Task Management**: Add, update, and remove tasks.
- **Concurrency**: Process tasks using multiple threads in parallel.
- **Streams**: Use Java Streams for filtering and processing tasks.
- **Exception Handling**: Custom exception handling for task retrieval and removal.
- **Generics**: A generic `TaskManager` class for type safety and reusability.

## Project Structure
The project contains the following key classes:

1. **`Task`**: Represents a task with a title, description, and completion status. Includes methods to mark tasks as completed.
2. **`TaskManager`**: Manages tasks using a `HashMap` and `ArrayList`. It allows adding, removing, retrieving, and updating tasks. It also supports filtering and mapping tasks using Java Streams.
3. **`TaskProcessor`**: Implements the `Runnable` interface to simulate task processing in a separate thread. This class is used to demonstrate multithreading.
4. **`TaskNotFoundException`**: A custom exception class to handle cases where a task is not found.
5. **`Main`**: The entry point of the program that orchestrates task creation, addition, and processing using threads.

## How to Run the Project

### Prerequisites
Make sure you have the following installed:
- **Java 8 or higher**: The project uses Java Streams, Generics, and `ExecutorService` for multithreading.
- A text editor or IDE of your choice (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code).

### Steps to Run

1. **Clone the repository** (or copy the project files to your local machine).

   ```bash
   git clone https://github.com/your-username/multi-threaded-task-manager.git
   cd multi-threaded-task-manager
