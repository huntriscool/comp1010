# Week 1 - Transition from Processing to Java

## Recap

### Data Types

- **int**'s are perimitive (actual data) that are numbers: 1, -10, 99, e.t.c
- **String**'s are locations to objects (holds data): "Hello!" is the data inside the object String
- **booleans** are either true or false
- **char**'s are a single letter/character value: "a", "?", "1", e.t.c
- **float**'s are perimitve data that holds fractional numbers: 1.2, 100.0, 20.67
- **double**'s are double the precision of floats

### Variables

- Variables hold data
- You can create a variable and modify the data inside
- Syntax is: _dataType variableName = value;_
  - An int variable would look like: _int a = 10;_
  - A string variable would look like: _String text = "Hello!";_
  - A boolean variable would look like: _boolean hasPassed = false;_

### Conditions & Comparrisons

- if/else, and/or, equal to/not equal too, greater than/less than, while

#### Examples

- lessthan: 10 < 0 = false
- equalto: 2 == 2 = true
- greaterthan: 2+7 > 9 = false
- greterthan or equalto: 2+7 >= 9 = true
- if(10 > 0) print("YES") - as the condition is TRUE it moves forward in printing
- if(2 == 2) print("YES") - as the condition is TRUE it moves forward
- if(9 != 9) print("YES") - as the condition is FALSE it doesnt move forward

### Loops

#### FOR

int count = 0;  
for(int i = 0; i < 5; i++){  
      count++;  
}  
count = ??

#### WHILE

int count = 0;  
while(count < 5){  
     count++;  
}  
count = ??

### Arrays

- Arrays hold multiple values of 1 data type
- Lets say u have 4 assessments and want to store each mark in one place, an array is how you do that!
- Syntax is _dataType[] arrayName = new dataType[arraySize]_
  - An array that holds 5 different int's would look like
    - _int[] array1 = new int[5];_
  - An array that holds 3 different String's would look like
    - _String[] array2 = new String[3];_

- To access an item in the array use arrayName[indexOfValue]
  - e.g. u want the **second** item in an array called marks
    - _int mark2 = marks[1];_ // the reason its 1 not 2 is beacause index's start counting from 0
      - So the first item of an array is arr[0], second item is arr[1], e.t.c

# HOMEWORK

## ANSWER ALL QUESTIONS IN PRACTICE PACKAGE INTRO FOLDER STAGE 1 & 2
