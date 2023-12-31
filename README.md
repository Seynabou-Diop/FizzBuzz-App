FizzBuzz Application
FizzBuzz Application is a graphical implementation of the classic FizzBuzz programming problem. It displays the numbers from 1 to 100 with specific conditions in a GUI (Graphical User Interface).

Description
In FizzBuzz, we iterate through the numbers from 1 to 100. For every number:

If it is divisible by 3 or contains 3, we replace it with "Fizz".
If it is divisible by 5 or contains 5, we replace it with "Buzz".
If both conditions are true, we replace it with "FizzBuzz".
Otherwise, we just display the number itself.
This application uses Java's Swing library to create the GUI. It displays a button to start the game and a JTextPane to display the results.

Features
Interactive FizzBuzz game with a start button.
Results are displayed in a graphical window.
The results include a small icon next to each line.
Number "1" is also displayed in the results as per the usual game rules.
Usage
To run the application, you need to have Java installed on your machine. You can compile and run the program with the following commands:

sh
Copy code
javac FizzBuzz.java
java FizzBuzz
Testing
This project includes unit tests for the getFizzBuzz() method. The tests are implemented with JUnit, a popular Java testing framework.
