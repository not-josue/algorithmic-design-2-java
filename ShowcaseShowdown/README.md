# Showcase Showdown

## Objective

Write a program which replicates the final game of a famous price related game show. In this version, a “Showcase” contains exactly 5 unique randomly selected prizes. The user must guess the sum of the prizes within $1,300 below or equal to the sum in order to win.

## Requirements

### Data Structures

- Use only Arrays

### Interface

- Users should easily understand what the program does and how to use it.
- Users should be prompted for input and should be able to enter data easily.
- Users should be presented with output after major functions, operations, or calculations.
- Users should be able to perform any number of the required functions. In addition, users should be able to choose when to terminate the program.

### Reading a Prize File

- The program must read from a “Prize File” and using that information it must populate a data structure of prizes.
- Each prize in the file has a name and price separated by and end line (‘\n’).
- Each prize’s name and price are separated by a tab (‘\t’)
- The “Prize File” format is:

```
<<Prize’s Name 0>>\t<<Prize’s Price 0>>\n
<<Prize’s Name 1>>\t<<Prize’s Price 1>>\n
```

- The program should ignore items that do not strictly follow the previously stated format. (HINT! There’s at least one item in the file that is not formatted correctly)
- An example Prize File is provided (prizesdb.txt)
- You may either assume the “Prize File” is constant or you may ask the user to enter a prize filename.
- You do not need to create the file yourself, and you may use the provided example file.

### Select Prize for Showcase

- The program should randomly pick exactly 5 unique prizes from the prize data structure.
- No prize should ever repeat in this selection.

### Determine if the user won or lost

- The user must be presented with the prizes’ names before they make a guess, and it must clearly prompt the user for a guess.
- The user should be able to enter their guess.
- The program then must determine if the user’s guess was less than or equal the sum of the prizes and greater than or equal the sum of the prizes minus $1,300. If both are true, then the program must inform the user they won! Otherwise the program must inform the user they lost.

### Run-Time and Logic Error Checking

- Each major function must check for common run-time and logic errors.

## Example Dialogue

```
Welcome to the showcase show down!

Your prizes are:
Car
Antacid
Cheese
Goat
Guitar

You must guess the total cost of the prizes without going over and within $1,300 of its actual price
Enter your guess
22000

The actual cost was 21710.0
Your guess was over. You lose

Would you like to quit? Enter "yes" to quit
no

Your prizes are:
Fiber Supplement
Espresso Making Ferrets
A Very Very Pretty Ring
Goat
200 Dollars in Cash

You must guess the total cost of the prizes without going over and within $1,300 of its actual price
Enter your guess
1000

The actual cost was 2806.0
Your guess was close, but not close enough. You lose.

Would you like to quit? Enter "yes" to quit
no

Your prizes are:
Car
Beard Supplies
Watch
Microwave
Milk

You must guess the total cost of the prizes without going over and within $1,300 of its actual price
Enter your guess
21000

The actual cost was 21585.0
You win!!!

Would you like to quit? Enter "yes" to quit
yes

Goodbye!
```
