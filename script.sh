#!/bin/bash

# Check if file path is provided
if [ -z "$1" ]; then
    echo "Usage: $0 <Java file path>"
    exit 1
fi

JAVA_FILE="$1"
CLASS_NAME=$(basename "$JAVA_FILE" .java)

# Check if the file exists
if [ ! -f "$JAVA_FILE" ]; then
    echo "Error: File '$JAVA_FILE' not found."
    exit 1
fi

# Compile the Java file
javac "$JAVA_FILE"
if [ $? -ne 0 ]; then
    echo "Compilation failed."
    exit 1
fi

# Run the Java program
java "$CLASS_NAME"

# Clean up - Remove the compiled class file
rm -f "$CLASS_NAME.class"

