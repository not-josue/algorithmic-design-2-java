# Video Game Database

## Objective

Write a program in which the user loads and searches a database of video games. Users should have the option to search games by their title, their console, or both based on partial matches. In addition, the user can use the wildcard “\*” to indicate they want all results from either titles or consoles. The user should have the option to both print the results of the search via the console or print the results to a file.

## Requirements

### Data Structures

- Use only a Generic Linked List of your own creation.

- You may NOT use other built in types like ArrayLists, LinkedLists, etc.

- You may add, remove, or modify functionality in your generic linked list.

### Clear and Easy To Use Interface

- Users should easily understand what the program does and how to use it.

- Users should be prompted for input and should be able to enter data easily.

- Users should be presented with output after major functions, operations, or calculations.

- Users should be able to perform any number of the required functions. In addition, users should be able to choose when to terminate the program.

### Reading a Video Game Collection File

- The program must read from a “Video Game Collection File” and using that information it must populate a linked list of games.

- The user must be able to provide the name of the file.

- Each game in the file has a name and console separated by and end line (‘\n’).

- Each game’s name and console are separated by a tab (‘\t’)

- The “Video Game Collection File” format is:

```
<<Game’s Name 0>>\t<<Game’s Console 0>>\n
<<Game’s Name 1>>\t<<Game’s Console 1>>\n
```

- The program should ignore items that do not strictly follow the previously stated format.

- A collection example file is provided (Collection.txt)

- The user must be able to load a different game collection file at any time, and this should replace the information previously stored in the linked list.

### Searching for Games

- The program must be able to search for games based on both its name and its console.

- The search results must ignore case and allow partial matches.

- The program must allow users to input the wildcard character, “\*”, to return all matches for either the name, console, or both.

- For Example, let’s assume the game collection file has the following entries:

```
Mega Man\tNintendo Entertainment System\n
Mega Man 2\tNintendo Entertainment System\n
Mega Man X\tSuper Nintendo Entertainment System\n
Sonic the Hedgehog\tSega Genesis\n
Super Mario Bros.\tNintendo Entertainment System\n
```

- Assuming the file has been loaded correctly, and the information has been loaded into a linked list of games correctly, then if the user enters, “mega” for the game title and “\*” for the game console, then the program searches through the linked lists and prints the results:

```
Mega Man\tNintendo Entertainment System\n
Mega Man 2\tNintendo Entertainment System\n
Mega Man X\tSuper Nintendo Entertainment System\n
```

- Another example is if the user enters “\*” for the game title and “Nintendo” for the game console, then the program prints the results:

```
Mega Man\tNintendo Entertainment System\n
Mega Man 2\tNintendo Entertainment System\n
Mega Man X\tSuper Nintendo Entertainment System\n
Super Mario Bros.\tNintendo Entertainment System\n
```

- Note that “\t” and “\n” will not be visibly printed to either the console or a new file and is only used in this example to demonstrate the file format.

### Printing Search Results

- After every search, the program must print the results of the search to the console.

- The user must have the option to print the results to a file. They must be able to specify the file’s name and must be able to either overwrite a previous search results file or append the search to an existing search results file.

- **HINT:** It may be a good idea to create another data structure, like another linked list, that contains the search results.

### Run-Time and Logic Error Checking

- Each major function must check for common run-time and logic errors.

## Example Dialogue

```
Welcome to the Video Game Database!

Enter 1 to load the video game database
Enter 2 to search the database
Enter 3 to print current results to the console
Enter 4 to print current results to file
Enter 0 to quit
1

Enter the file name
Collection.txt

Enter 1 to load the video game database
Enter 2 to search the database
Enter 3 to print current results to the console
Enter 4 to print current results to file
Enter 0 to quit
2

Enter the name of the game or '*' for all
super
Enter the name of the console or '*' for all
Nintendo

Super Alfred Chicken Super Nintendo [NA]
"Super Aquatic Games Starring the Aquabats, The" Super Nintendo [NA]
Super Castlevania IV Super Nintendo [NA]
Super Dodge Ball Nintendo Entertainment System [US]
Super Empire Strikes Back Super Nintendo [NA]
Super Ghouls 'N Ghosts Super Nintendo [NA]
Super Glove Ball Nintendo Entertainment System [US]
Super Mario All-Stars Super Nintendo [NA]
Super Mario Bros.  (5 Screw Cartridge) Nintendo Entertainment System [US]
Super Mario Bros. / Duck Hunt (No Nintendo Seal of Quality) Nintendo Entertainment System [US]
Super Mario Bros. 2 (No Nintendo Seal of Quality) Nintendo Entertainment System [US]
Super Mario Bros. 3 (Bros. above Mario's Head) Nintendo Entertainment System [US]
Super Mario Kart Super Nintendo [NA]
Super Mario World Super Nintendo [NA]
Super Mario World 2: Yoshi's Island Super Nintendo [NA]
Super Metroid Super Nintendo [NA]
Super Pitfall (3 Screw Cartridge) Nintendo Entertainment System [US]
Super Punch-Out!! Super Nintendo [NA]
Super Scope 6 Super Nintendo [NA]
Super Spike V'Ball / Nintendo World Cup Nintendo Entertainment System [US]
Super Star Wars (JVC) Super Nintendo [NA]
Super Star Wars: Return of the Jedi (JVC) Super Nintendo [EU]
Super Street Fighter II Super Nintendo [NA]
Super Team Games Nintendo Entertainment System [US]
Super Tennis Super Nintendo [NA]

Enter 1 to load the video game database
Enter 2 to search the database
Enter 3 to print current results to the console
Enter 4 to print current results to file
Enter 0 to quit
4

Enter the file name
SuperGames.txt
Would you like to append? True or false?
false

Enter 1 to load the video game database
Enter 2 to search the database
Enter 3 to print current results to the console
Enter 4 to print current results to file
Enter 0 to quit
2

Enter the name of the game or '*' for all
Mega
Enter the name of the console or '*' for all
*

Mega Man (Oval Seal) Nintendo Entertainment System [US]
Mega Man 2 (No Stripe on Box) Nintendo Entertainment System [US]
Mega Man 3 Nintendo Entertainment System [US]
Mega Man 4 Nintendo Entertainment System [US]
Mega Man 5 Nintendo Entertainment System [US]
Mega Man 6 Nintendo Entertainment System [US]
Mega Man Soccer Super Nintendo [NA]
Mega Man X Super Nintendo [NA]
Mega Man X2 Super Nintendo [NA]
Mega Man X3 Super Nintendo [NA]
Megamania Atari 2600 [NA]
Omega Race ColecoVision [NA]

Enter 1 to load the video game database
Enter 2 to search the database
Enter 3 to print current results to the console
Enter 4 to print current results to file
Enter 0 to quit
4

Enter the file name
SuperGames.txt
Would you like to append? True or false?
true

Enter 1 to load the video game database
Enter 2 to search the database
Enter 3 to print current results to the console
Enter 4 to print current results to file
Enter 0 to quit
0
Goodbye!
```

- **Note:** The file created called “SuperGames.txt” in the previous example dialog would contain:

```
Super Alfred Chicken    Super Nintendo [NA]
"Super Aquatic Games Starring the Aquabats, The"      Super Nintendo [NA]
Super Castlevania IV    Super Nintendo [NA]
Super Dodge Ball  Nintendo Entertainment System [US]
Super Empire Strikes Back     Super Nintendo [NA]
Super Ghouls 'N Ghosts  Super Nintendo [NA]
Super Glove Ball  Nintendo Entertainment System [US]
Super Mario All-Stars   Super Nintendo [NA]
Super Mario Bros.  (5 Screw Cartridge)    Nintendo Entertainment System [US]
Super Mario Bros. / Duck Hunt (No Nintendo Seal of Quality) Nintendo Entertainment System [US]
Super Mario Bros. 2 (No Nintendo Seal of Quality)     Nintendo Entertainment System [US]
Super Mario Bros. 3 (Bros. above Mario's Head)  Nintendo Entertainment System [US]
Super Mario Kart  Super Nintendo [NA]
Super Mario World Super Nintendo [NA]
Super Mario World 2: Yoshi's Island Super Nintendo [NA]
Super Metroid     Super Nintendo [NA]
Super Pitfall (3 Screw Cartridge)   Nintendo Entertainment System [US]
Super Punch-Out!! Super Nintendo [NA]
Super Scope 6     Super Nintendo [NA]
Super Spike V'Ball / Nintendo World Cup   Nintendo Entertainment System [US]
Super Star Wars (JVC)   Super Nintendo [NA]
Super Star Wars: Return of the Jedi (JVC) Super Nintendo [EU]
Super Street Fighter II Super Nintendo [NA]
Super Team Games  Nintendo Entertainment System [US]
Super Tennis      Super Nintendo [NA]
Mega Man (Oval Seal)    Nintendo Entertainment System [US]
Mega Man 2 (No Stripe on Box) Nintendo Entertainment System [US]
Mega Man 3  Nintendo Entertainment System [US]
Mega Man 4  Nintendo Entertainment System [US]
Mega Man 5  Nintendo Entertainment System [US]
Mega Man 6  Nintendo Entertainment System [US]
Mega Man Soccer   Super Nintendo [NA]
Mega Man X  Super Nintendo [NA]
Mega Man X2 Super Nintendo [NA]
Mega Man X3 Super Nintendo [NA]
Megamania   Atari 2600 [NA]
Omega Race  ColecoVision [NA]
```
