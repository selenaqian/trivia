# trivia
Trivia game created for Tandem code challenge.

## How to Run
Uses [OpenJDK 14 full](https://bell-sw.com/pages/downloads/?version=java-14) version.

1. In a command line, navigate to the root of this repository (trivia, containing src, test, etc.).
1. Inside that folder, there is a trivia.jar file. Run ```java -jar trivia.jar```. This should start the program.
1. It will first ask whether you want to see the questions in order or in a random order. Enter a or b (can be lower or
uppercase). If an invalid input is entered, the program should catch that.
1. Then, you should see a welcome message and the first question. Enter your answer. Again, it should catch invalid inputs
and prompt you with what you should enter instead.
1. After each question, it will tell you if you were correct or incorrect (with correct answer) and show your updated score.
1. After 10 questions, the program will end and show your total score.

Running JUnit Tests:

It's easiest to run the JUnit tests from an IDE (I currently use IntelliJ). In order to run from the command line,
1. Compile all of the classes and test classes using ```javac <classname>``` when in the directory. Put all of these classes
in the test/trivia directory.
1. Download this jar file for the console launcher: https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0.jar
1. Run ```java -jar junit-platform-console-standalone-1.7.0.jar --cp :trivia --scan-classpath```. Currently, this only discovers
the PlayerTest and QuestionTest classes and runs those (not sure why).

## Assumptions
* 10 questions per trivia round
* all questions are multiple choice
* data in json is formatted in a list of objects, each object containing a "question", "incorrect", and "correct" property
    * program does account for potential data issues and will display a message to users

## Desired Potential Additional Features
* UI - I have experience working with javaFX (see [moono project](https://github.com/selenaqian/moono)), but I chose to
focus on creating clean, tested code rather than working on a user interface.
* Question difficulty - This code could definitely be extended to allow for variable point values based on a data file or
some other method of determining how hard a question is.
* Multiplayer - I could see this also being extended into something web-based or otherwise that allows for multiple people
to be playing the same set of questions and getting a ranking at the end.
* If didn't have assumptions for 10 questions per round and all multiple choice, would be fairly easy to add in a settable
parameter for the number of questions, and would be interesting to learn about evaluation of short answer type questions.
Could also add in more aspects for the user to choose at the start, such as what file of questions they want to use, how many
points each question should be worth, etc.
