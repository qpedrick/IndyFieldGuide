# Indy Field Guide

[![Java](https://img.shields.io/badge/Java-orange?style=flat&logo=java)](https://java.com)

This project is a Java-based Command Line Interface (CLI) application inspired by the Model-View-Controller architecture. The general concept is a field guide for the Greater Indianapolis region. Users can create an account or log in, then explore different locations and species. When exploring a location, users receive a quiz and, if answered correctly, the species is added to their field guide.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## Installation

### Prerequisites
Ensure you have Java installed on your system. You can verify this by running:
java --version
If Java is not installed, follow the [installation instructions](https://java.com/en/download/help/download_options.html).

### Cloning the Repository
Clone the repository to your local machine:
git clone [REPLACE WITH YOUR REPOSITORY URL]
cd [REPLACE WITH YOUR PROJECT NAME]

### Using the Makefile
The project includes a Makefile with various commands to simplify running the application:
make help  # Displays all commands available in the Makefile
Other useful commands:
make        # Compiles all Java source files
make run    # Runs the main application
make jar    # Creates a jar file from compiled classes
make runjar # Runs the jar file
make clean  # Removes all compiled files and the jar
make cleanData # Removes all data files

### Manual Compilation and Execution
If you prefer not to use the Makefile, compile and run the application using:
mkdir -p target
javac -d target -cp target -sourcepath src $(find src -name '*.java')
java -cp target FieldGuide.Main

## Usage
Provide detailed instructions on how to use the application, including any available commands or features.

## Features
List and describe the key features of the application. For example:
- User authentication (signup and login)
- Interactive quizzes for species discovery
- Persistent data storage for user sessions

## Contributing
Encourage other developers to contribute to your project by providing guidelines on how they can contribute. For example:
1. Fork the repository.
2. Create a new branch (git checkout -b feature/AmazingFeature).
3. Make the appropriate changes in the files.
4. Commit your changes (git commit -am 'Add some AmazingFeature').
5. Push to the branch (git push origin feature/AmazingFeature).
6. Create a new Pull Request.

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
