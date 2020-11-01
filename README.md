# trivia
Trivia game created for Tandem code challenge.

## How to Run

## Assumptions
* 10 questions per trivia round
* all questions are multiple choice
* data in json is formatted in a list of objects, each object containing a "question", "incorrect", and "correct" property
    * program does(will) account for potential data issues and will display a message to users

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