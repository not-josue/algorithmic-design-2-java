# Sheep Shearing Scheduler

## Objective

Write a program which will generate a sheep shearing schedule based on a given file and priority scheduling. Only one sheep can be sheared at a time and the other sheep must wait to be sheared. While the other sheep are waiting, they are prioritize by smaller shearing times and then by their name in alphabetical order. The next sheep to be sheared has the highest priority.

## Requirements

### Data Structures

- Use only a Heap of your own creation

### Reading a Sheep Scheduling File

- The program must be able to read a sheep scheduling file that has the format:

```
<<name>>\t<<shearing time>>\t<<arrival time>>\n
```

- The user must be able to provide the name of the file.

- Use the given file (Sheep.txt) to test your solution.

### Sheep Information

- Each sheep has a name, shearing time, and arrival time.

- Sheep must be comparable by their shearing time, and by their name. All assume ascending order.

### Sheep (Wait) Heap

- The program must use a generic implementation of a MinHeap, of one’s own creation, to schedule the sheep who are waiting.

- This MinHeap must have both add and remove implemented properly.

- After every operation the MinHeap must remain a MinHeap.

### Scheduling Sheep

- The program must then simulate and print to the console a sheep shearing schedule using the sheep found in the file.

- The first sheep to arrive is the first sheep to be sheared. While that sheep is being sheared if other sheep arrive, then they are put into the sheep wait heap and prioritized based on their shearing time and their name alphabetically.

- Only sheep who have arrived and who are waiting are added to the sheep heap.

- Once the last sheep has been sheared and the sheep heap is empty, then the program must print the schedule to the console and ask the user if they would like to run it again.

## Schedule from the Provided File (Sheep.txt)

```
Name: Correa, Sheer Time: 15, Arrival Time: 0
Name: Howarth, Sheer Time: 6, Arrival Time: 14
Name: Reyna, Sheer Time: 7, Arrival Time: 17
Name: Harper, Sheer Time: 3, Arrival Time: 27
Name: Amiyah, Sheer Time: 8, Arrival Time: 2
Name: Key, Sheer Time: 5, Arrival Time: 32
Name: Atlas, Sheer Time: 1, Arrival Time: 43
Name: Arnold, Sheer Time: 2, Arrival Time: 42
Name: Roach, Sheer Time: 4, Arrival Time: 41
Name: Jay, Sheer Time: 9, Arrival Time: 23
Name: Miranda, Sheer Time: 10, Arrival Time: 35
Name: Emerson, Sheer Time: 11, Arrival Time: 29
Name: Contreras, Sheer Time: 12, Arrival Time: 15
Name: Marlie, Sheer Time: 12, Arrival Time: 44
Name: Hudson, Sheer Time: 13, Arrival Time: 39
Name: Mccallum, Sheer Time: 13, Arrival Time: 39
Name: Kenny, Sheer Time: 14, Arrival Time: 19
Name: Kearney, Sheer Time: 15, Arrival Time: 49
Name: Wiggins, Sheer Time: 16, Arrival Time: 24
Name: Aimie, Sheer Time: 17, Arrival Time: 7
Name: Mcdowell, Sheer Time: 18, Arrival Time: 46
Name: Avery, Sheer Time: 19, Arrival Time: 6
Name: Tiah, Sheer Time: 20, Arrival Time: 15
Name: Buxton, Sheer Time: 21, Arrival Time: 5
Name: Hickman, Sheer Time: 21, Arrival Time: 29
Name: Fabian, Sheer Time: 22, Arrival Time: 3
Name: Wilder, Sheer Time: 23, Arrival Time: 33
Name: Lim, Sheer Time: 24, Arrival Time: 43
Name: Traynor, Sheer Time: 24, Arrival Time: 18
Name: Finnian, Sheer Time: 25, Arrival Time: 26
Name: Heather, Sheer Time: 26, Arrival Time: 9
Name: Monaghan, Sheer Time: 26, Arrival Time: 23
Name: Jeffery, Sheer Time: 27, Arrival Time: 36
Name: Rasmussen, Sheer Time: 27, Arrival Time: 2
Name: Jordi, Sheer Time: 28, Arrival Time: 11
Name: Maximus, Sheer Time: 29, Arrival Time: 16
Name: Anastazja, Sheer Time: 30, Arrival Time: 12
Name: Lara, Sheer Time: 30, Arrival Time: 40
Name: Knox, Sheer Time: 31, Arrival Time: 21
Name: Wooten, Sheer Time: 32, Arrival Time: 37
Name: Paula, Sheer Time: 33, Arrival Time: 1
Name: Cortes, Sheer Time: 34, Arrival Time: 50
Name: Danielius, Sheer Time: 34, Arrival Time: 4
Name: Antoine, Sheer Time: 35, Arrival Time: 38
Name: Pierce, Sheer Time: 36, Arrival Time: 28
Name: Marni, Sheer Time: 37, Arrival Time: 22
Name: Becker, Sheer Time: 38, Arrival Time: 40
Name: Courteney, Sheer Time: 39, Arrival Time: 10
Name: Clemons, Sheer Time: 40, Arrival Time: 25
Name: Sulayman, Sheer Time: 41, Arrival Time: 30
Name: Asa, Sheer Time: 42, Arrival Time: 45
Name: Florrie, Sheer Time: 43, Arrival Time: 48
Name: Jeremy, Sheer Time: 44, Arrival Time: 13
Name: Manveer, Sheer Time: 45, Arrival Time: 47
Name: Mayo, Sheer Time: 46, Arrival Time: 31
Name: Percy, Sheer Time: 47, Arrival Time: 34
Name: Chadwick, Sheer Time: 48, Arrival Time: 8
Name: Effie, Sheer Time: 49, Arrival Time: 50
Name: Mueller, Sheer Time: 49, Arrival Time: 41
Name: Kumar, Sheer Time: 50, Arrival Time: 20
```
