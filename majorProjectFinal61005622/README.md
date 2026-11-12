# Birthday Budget Planner

## What problems does your application solve?

Birthdays sneak up on people, and the cost of gifts adds up fast. This app helps keep track of friends' birthdays, plan a gift budget for each friend, and check whether the plan fits inside a monthly budget. Users can record gift ideas with prices, mark them as bought, see any month's birthdays and spending, find out who is coming up in the next 30 days, and save everything to a file to reload later.

## A description of the structure of your program

The program is split into layers, and each class has one job.

- **Client**: the driver class and text menu. It reads input, re-asks when the input is bad, and prints results.
- **BirthdayPlanner**: answers the questions (who is in October, is the plan over budget). It owns a Budget and a BirthdayTree.
- **BirthdayTree and BirthdayNode**: a recursive binary search tree that stores people in birthday order (month, then day). Insert, in-order listing, search and remove are all recursive.
- **Person**: holds a name, a Date birthday, a Budget and an ArrayList of Gift objects.
- **Gift, Budget and Date**: small classes for a gift idea, money, and a validated calendar date that handles leap years.
- **PlannerFileIO**: saves and loads the whole planner as a plain text file, planner.csv.
- **Tests**: DateTest, BirthdayTreeTest, BirthdayPlannerTest and PlannerFileIOTest cover edge cases such as leap days, December-to-January wraparound, same-day birthdays and a save and load round trip.

## How to run your application

- Open a terminal in the project folder (the one containing src and lib).
- Create the output folder: `mkdir bin` (skip this if it already exists).
- Compile: `javac -cp lib/junit-platform-console-standalone-1.7.2.jar -d bin src/*.java`
- Run the program: `java -cp bin Client`
- Choose option 11 (Load demo data) to load demoPlanner.csv and try the features straight away.
- Choose option 9 to save. The data is written to planner.csv and loaded automatically next time the program starts.
- Optional, run the tests: `java -jar lib/junit-platform-console-standalone-1.7.2.jar -cp bin --scan-classpath`
