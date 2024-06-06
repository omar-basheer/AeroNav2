# AeroNav2: Flight Path Finder

This project is a Java application that finds the shortest flight path between two airports. It uses data from CSV files to build a graph of airports and routes, and then applies a search algorithm to find the shortest path.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You need to have Java installed on your machine to run this application. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

### Installing

Clone the repository to your local machine:

```sh
git clone https://github.com/omar-basheer/AeroNav2
```

### Running the Application

The main entry point of the application is the `Main` class in the `src/Main.java` file. You can run the application in your IDE or from the command line with the following command:

```sh
javac src/*.java && java -cp src Main
```

This will run the application with the default input file (`tests/input.txt`) and write the output to `tests/output.txt`.

## Sample Input and Output

This section provides examples of input and output for the AeroFlight Path Finder application.

### Input

The input file (`tests/input.txt`) should contain the city and country of the source and destination, separated by a newline. For example:

```txt
New York, United States
Tokyo, Japan
```

### Output

The output will be written to `tests/output.txt`. It will list the airports on the shortest flight path, along with the airline available and the  total flight distance. For example:

```txt
Shortest Path:
1. AA from LGA to BOS
2. AA from BOS to NRT
Total flights: 2
Total flight distance: 11057.476983224162 kilometers

All Paths with Distance Information:
Path:
1. AA from LGA to BOS
2. AA from BOS to NRT
Total flights: 2
Total flight distance: 11057.476983224162 kilometers

Path:
1. AA from LGA to DFW
2. AA from DFW to NRT
Total flights: 2
Total flight distance: 12553.729859346357 kilometers
```

### Built With

Java

### Authors
Me

