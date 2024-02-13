# File I/O Problems

## Objective

Write a solution that performs file input and output (File I/O) using a variety of file types and problems.

## Requirements

### Setup the Project

- Use the provided driver file as the frontend of the program (FileIOProblems.java)

- Use the provided text files (ItIs.txt and Tubes.txt)

- Create a class and name it FileIOSolutions

- Do not modify the provided driver or text files

### Write method pastTense

- This static method returns no values and is provided both with a read file name and an output file name.

- The provided read file is assumed to be plain text and each word is separated using either spaces, tabs, or end-line characters.

- The method reads the provided file word-by-word and changes every instance of “is” to “was” and case does not matter.

- The method must both print each word to the console and to a new file on a new line. The formatting in the read file can be ignored, such as spaces, tabs and end-lines.

### Write method totalTubeVolume

- This static method returns the total combined volumes of tubes in a file.

- The file is assumed to be tab-delimited and has the following format:

```
<<id>>\t<<tube's radius>>\t<<tube's height>>\n
```

- The method must read, parse, and process the information in the file line-by-line to calculate the total combined volumes.

- The method should ignore any lines in the file that are not properly formatted.

- It can be assumed that the amount of tubes in the file will never exceed 100.

- Volume can be calculated by:

$$
Volume = radius^2 * \pi * height
$$

## Example Dialogue

```
Welcome to the File I/O Problem's Solutions!

Enter 1. For Test 1
Enter 2. For Test 2
Enter 9. To Quit
1

-----------------------
Test01
-----------------------

Testing method "pastTense" with the file "ItIs.txt" and outputting to "ItWas.txt"

What
was
it?
It
was
something
after
all,
and
something
was
not
nothing.
How
was
it
described?
was
it
big?
was
it
small?
was
it
green
or
was
it
purple
or
was
it
neither?
was
this
it
or
was
that
it?
Who
knows?

Enter 1. For Test 1
Enter 2. For Test 2
Enter 9. To Quit
2

-----------------------
Test02
-----------------------
Testing method "totalTubeVolume" with the file "./Tubes.txt"
The total combined volume is: 20106.51499622167

Enter 1. For Test 1
Enter 2. For Test 2
Enter 9. To Quit
9
Goodbye!
```
