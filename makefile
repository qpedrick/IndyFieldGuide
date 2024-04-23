# Define the compiler and the compiler flags
JAVAC = javac
JAVA = java
JAR = jar
FLAGS = -g

# Define source directory and output directory
SRCDIR = src/main/java
BINDIR = target
DATA = src/main/resources/data

# Find all Java files in the source directory
SOURCES := $(shell find $(SRCDIR) -name '*.java')

# Define the main class and the name of the jar file
MAINCLASS = FieldGuide.Main
JARFILE = FieldGuide.jar

# Default target
all: $(BINDIR)/.done

# Rule to compile all Java files
$(BINDIR)/.done: $(SOURCES)
	@mkdir -p $(BINDIR)
	$(JAVAC) $(FLAGS) -d $(BINDIR) -cp $(BINDIR) $(SOURCES)
	@touch $(BINDIR)/.done

# Target to create a jar file
jar: all
	$(JAR) cfe $(JARFILE) $(MAINCLASS) -C $(BINDIR) .

# Target to run the program
run: all
	$(JAVA) -cp $(BINDIR) FieldGuide.Main

# Target to run the program with the jar file
runjar: jar
	$(JAVA) -jar $(JARFILE)

# Target to clean the project
clean:
	@rm -rf $(BINDIR)

cleanData:
	@rm -rf $(DATA)

# Help
help:
	@echo "Makefile for Java Project"
	@echo "Usage:"
	@echo " make           : Compiles all java source files"
	@echo " make run       : Runs the main application"
	@echo " make jar       : Creates a jar file from compiled classes"
	@echo " make runjar    : Runs the jar file"
	@echo " make clean     : Removes all compiled files and the jar"
	@echo " make cleanData : Removes all data files"
	@echo " make help      : Displays this help"

.PHONY: all run clean help
