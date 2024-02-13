# Robot Command Simulator

## Objective

Write a program that simulates a robot running a queue of commands to move around a board with obstacles.

## Requirements

### Use only a Generic Queue of your own creation

- Do NOT use other Java built-in types like ArrayLists, LinkedLists, Queues, etc.

### Interface

- Users should easily understand what the program does and how to use it.

- Users should be prompted for input and should be able to enter data easily.

- Users should be presented with output after major functions, operations, or calculations.

- Users should be able to perform any number of the required functions. In addition, users should be able to choose when to terminate the program.

- Users must be able to provide both the filename’s for the board and the robot commands.

- Testing files are provided for the board and the robot commands (board.txt, board2.txt, robotCommands.txt, robotCommands2.txt, and robotCommandsBad.txt).

### Reading the Board File

- The program must be able to read a Board File that represents the robot’s environment.

- Board Files contain characters that represent empty spaces (“\_”) or obstacles (“X”).

- The Board File follows the format:

```
<<character00>><<character01>>…<<chracter08>><<character09>>\n
<<character10>><<character11>>…<<character18>><<chracter19>>\n
...
...
...
<<character90>><<character91>>…<<character98>><<chracter99>>
```

- **HINT:** This file can be read line-by-line and for each line it can be read character-by-character to create a board of empty spaces and obstacles.

### Reading the Robot Command File

- The program must be able to read a Robot Command File and populate a Queue of robot commands.

- The Robot Command File follows the format:

```
<<Command00>>\n
<<Command01>>\n
…
<<Command n>>
```

- Robot commands are either “Move Up”, “Move Down”, “Move Left”, or “Move Right”, and any other command is invalid and should be ignored. These commands are used to move the robot around the board.

### Simulating Commands

- After the Board File and Robot Command File has been read, the program must then simulate the robot moving on the board in the command line.

- The robot starts in the top-left corner of the board.

- Each command must be dequeued, the command must be applied to the robot, and both the board and the robot’s location on the board must be shown after every command. You may pick any character to represent the robot.

- In the event that the robot collides with an obstacle or attempts to go outside the bounds of the board, then the program must say “CRASH” and the simulation must immediately stop.

- Once there are no more commands or the robot crashed, then the program must prompt the user to either quit or restart the program.

## Example Dialogue

```
Welcome to the Robot Simulator

Enter file for the Board
board.txt
Enter file for the Robot Commands
robotCommands.txt

O____X____
_______X__
_______X__
X____X____
_X________
__X___X___
_________X
___X__X___
___X______
__XX______

Simulation begin

Command 0

_O___X____
_______X__
_______X__
X____X____
_X________
__X___X___
_________X
___X__X___
___X______
__XX______

Command 1

_____X____
_O_____X__
_______X__
X____X____
_X________
__X___X___
_________X
___X__X___
___X______
__XX______

Command 2

_____X____
_______X__
_O_____X__
X____X____
_X________
__X___X___
_________X
___X__X___
___X______
__XX______

Command 3

_____X____
_______X__
_______X__
XO___X____
_X________
__X___X___
_________X
___X__X___
___X______
__XX______

Command 4

_____X____
_______X__
_______X__
X_O__X____
_X________
__X___X___
_________X
___X__X___
___X______
__XX______

Command 5

_____X____
_______X__
_______X__
X__O_X____
_X________
__X___X___
_________X
___X__X___
___X______
__XX______

Command 6

_____X____
_______X__
_______X__
X___OX____
_X________
__X___X___
_________X
___X__X___
___X______
__XX______

Command 7

_____X____
_______X__
_______X__
X____X____
_X__O_____
__X___X___
_________X
___X__X___
___X______
__XX______

Command 8

_____X____
_______X__
_______X__
X____X____
_X___O____
__X___X___
_________X
___X__X___
___X______
__XX______

Command 9

_____X____
_______X__
_______X__
X____X____
_X____O___
__X___X___
_________X
___X__X___
___X______
__XX______

Command 10

_____X____
_______X__
_______X__
X____X____
_X_____O__
__X___X___
_________X
___X__X___
___X______
__XX______

Command 11

_____X____
_______X__
_______X__
X____X____
_X______O_
__X___X___
_________X
___X__X___
___X______
__XX______

Command 12

_____X____
_______X__
_______X__
X____X____
_X________
__X___X_O_
_________X
___X__X___
___X______
__XX______

Command 13

_____X____
_______X__
_______X__
X____X____
_X________
__X___X___
________OX
___X__X___
___X______
__XX______

Command 14

_____X____
_______X__
_______X__
X____X____
_X________
__X___X___
_________X
___X__X_O_
___X______
__XX______

Command 15

_____X____
_______X__
_______X__
X____X____
_X________
__X___X___
_________X
___X__X___
___X____O_
__XX______

Command 16

_____X____
_______X__
_______X__
X____X____
_X________
__X___X___
_________X
___X__X___
___X______
__XX____O_

Command 17

_____X____
_______X__
_______X__
X____X____
_X________
__X___X___
_________X
___X__X___
___X______
__XX_____O

Simulation end

Quit? Enter "true" to quit or hit enter to run another simulation
True

Example Dialog 2:

Welcome to the Robot Simulator

Enter file for the Board
board2.txt
Enter file for the Robot Commands
robotCommands2.txt

OX___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Simulation begin

Command 0

_X___XXX__
O__X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 1

_X___XXX__
_O_X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 2

_X___XXX__
__OX___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 3

_XO__XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 4

_X_O_XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 5

_X__OXXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 6

_X___XXX__
___XO__X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 7

_X___XXX__
___X_O_X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 8

_X___XXX__
___X__OX__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 9

_X___XXX__
___X___X__
XXXXX_OX__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 10

_X___XXX__
___X___X__
XXXXX__X__
X____XOX__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 11

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X__O___
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 12

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X_O____
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 13

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_XO_____
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 14

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X_OXX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 15

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
____O_XXXX
___X__XXXX
___X__XXXX
__XX______

Command 16

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___XO_XXXX
___X__XXXX
__XX______

Command 17

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___XO_XXXX
__XX______

Command 18

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XXO_____

Command 19

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX_O____

Command 20

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX__O___

Command 21

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX___O__

Command 22

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX____O_

Command 23

_X___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX_____O

Simulation end

Quit? Enter "true" to quit or hit enter to run another simulation
True

Example Dialog 3:

Welcome to the Robot Simulator

Enter file for the Board
board2.txt
Enter file for the Robot Commands
robotCommandsBad.txt

OX___XXX__
___X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Simulation begin

Command 0

_X___XXX__
O__X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 1

_X___XXX__
_O_X___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 2

_X___XXX__
__OX___X__
XXXXX__X__
X____X_X__
_X_X______
__X__XX___
______XXXX
___X__XXXX
___X__XXXX
__XX______

Command 3

CRASH!

Simulation end

Quit? Enter "true" to quit or hit enter to run another simulation
True
```
