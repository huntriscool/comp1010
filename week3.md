# ARRAY LISTS!!!!!

## Array lists can:
- Grow (u can keep adding elements to the list) // listName.add(30); - adds the int 30 to the end of the list  
- Get the size/length (how many items in the list) // listName.size(); - returns the length of the list as an int  
- Set a specific index to a value (set index 0 to 1) // listName.set(0, 1); - sets the number at index 0 to 1  
- Remove an index (anything after the index removed is shifted backed 1) // listName.remove(0); - removes the number at index 0  
- Add a number at an index (the index u selected and anything after will be shifted forward 1) // listName.add(3, 99) - adds 99 to index 3  

  
## MAKING AN ARRAY LIST:
U have to import ArrayList library for creating an ArrayList if you want to start the list with numbers alr in it  
  
### SYNTAX FOR AN ARRAY LIST  
ArrayList\<datatype> nameOfList = new ArraryList\<datatype>();  
therfore an integer Array List would look like  
ArrayList\<Integer> listOfIntegers = new ArrayList\<Integer>();  
  
- \<Integer> is a generic(whatever is inside of the pointy brackets is the data that will be held in the array list) if that makes any sence lol  
  
- Integer is different to int (basically Integer is a wrapper class which holds an int inside of it)  
  - same goes with Boolean and boolean and Double and double etc etc  
  
- The reason it is ArrayList\<Integer> and not ArrayList\<int> is because array lists only hold objects not perimitive data  
  - int, boolean, double, etc, are all perimitve data types which cant be used in an array  
    - HOWEVER! Integer is a wrapper class (which is an object) that holds an int..... more later  
  
  
For wrapper classes(Integer, and the other data types with a captial letter instead of lowercase),   
there is something called auto boxing and unboxing  
When u assign an int into an Integer, it gets automatically gets boxed into an Integer as an Integer is able to wrap an int inside it  
And when u assign an Integer to an int it gets unboxed into an in as it is able to unwrap the int inside it  
  
THAT MIGHT BE SO CONFUSING SORRY! maybe just watch the lecture for this topic a few times and then read these notes  
  
  
## EXAMPLES  
  
ArrayList\<Integer> list = new ArrayList\<Integer>(); // creates an Array List called 'list' which holds Integers   
list.add(50); // as the list is empty, adds the int 50 to index 0  
list.add(70); // as the list has 1 item, adds the int 70 to idex 1  
list.add(90); // yk how this works now  
the list would would be [50,70,90]  
list.size(); // returns  3  
list.remove(0);  
list is now [70,90]  
list.set(0, 20);  
list is now [20,90]  
list.add(1, 50);  
list is now [20,50,90]  



