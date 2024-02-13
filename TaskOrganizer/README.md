# Task Organizer

## Objective

Write a program in which the user can manage a collection of tasks. Each task has an associated action a priority. The tasks must be organized into a collection of different lists based on their priority value, where the highest priority is 0 and the lowest is 4.

## Requirements

### Data Structures

- Use only a Generic Linked List of your own creation.

- You may add, remove, or modify functionality in your generic linked list.

- Do NOT use other built in types like ArrayLists, LinkedLists, etc.

### Clear and Easy-To-Use Interface

- Users should easily understand what the program does and how to use it.

- Users should be prompted for input and should be able to enter data easily.

- Users should be presented with output after major functions, operations, or calculations.

- Users should be able to perform any number of the required functions. In addition, users should be able to choose when to terminate the program.

### Tasks

- The program must group together the task’s action along with its priority.

- The action is a simple non-null String value that explains the tasks and its default value is “none”.

- The priority is a whole number value from 0 to 4 inclusively where its default value is 4.

### Organizing Tasks

- The tasks must then be organized into a collection of Lists of tasks based on their priority.

- This collection must be an Array of Linked Lists of Tasks.

  - **HINT:** This is very similar to multidimensional arrays (array of arrays of objects) except now it is an array of lists of objects. To declare this kind of structure simple requires creating an Array of the Linked Lists of the Tasks similar to this:

  ```
  GenLL<Task>[] organizedTasks;
  ```

  - **HINT:** While the above declares the array, we also must construct it too by providing the size. Luckily we know that the size has to be 5 based on the above description, so the code would be similar to this:

  ```
  organizedTasks = new GenLL[5];
  ```

  - **HINT:** Keep in mind this only constructed the Array and NOT all of the linked lists. Now we need to do that using a simple for-loop similar to this:

  ```
  for(int i=0;i<organizedTasks.length;i++)
      organizedTasks[i] = new GenLL<Task>();
  ```

  - **HINT:** If you are encountered a “NullPointerException” then make sure the above has been done correctly

### Adding Tasks

- The user must be able to add a task by specifying the action and its priority.

- The task then must be organized in its correct location based on its priority.

- The priority must directly correspond to the index of the list, and only add it to the list if it is not already contained.

- If there is a duplicate task, then the user must be informed there was a duplicate task and it was not added.

- While the task’s priority specifies which list the task must be added, the lists themselves do not need to be sorted in any way.

### Removing Tasks

- The user must be able to remove a task by specifying the action and its priority.

- The program must use the tasks priority to quickly search for and remove the task if it exists.

### Printing Tasks to the Console

- The program must print all the tasks to the console upon request.

- It must display both the task’s priority and its action.

- It must print the lists in priority order starting with the highest and ending with the lowest (priority 0 to priority 4).

### Reading a Tasks File

- The program must be able to read from a “Tasks File” and using that information it must populate the collection of lists.

- The user must be able to provide the name of the file.

- Each task in the file has a priority and an action an end line (‘\n’).

- Each task’s priority and action are separated by a tab (‘\t’)

- The “Tasks File” format is:

```
<<Priority 0>>\t<<Action 0>>\n
<<Priority 1>>\t<<Action 1>>\n
```

- The program should ignore items that do not strictly follow the previously stated format.

- An example task file is provided (TasksFile.txt)

- The user must be able to load a different task file at any time, and this should replace the information previously stored.

### Printing a Task File

- The program must be able to print all tasks to a Task File.

- All task information including their priority and action must be included and must be formatted in the same way mentioned above.

## Example Dialogue

```
Welcome to the Task Organizer!

Enter 1. To Add a Task
Enter 2. To Remove a Task
Enter 3. To Print Tasks To Console
Enter 4. To Read from a Task File
Enter 5. To Write to a Task File
Enter 9. To Quit
4

Enter the file name
TasksFile.txt

Enter 1. To Add a Task
Enter 2. To Remove a Task
Enter 3. To Print Tasks To Console
Enter 4. To Read from a Task File
Enter 5. To Write to a Task File
Enter 9. To Quit
3

[Task] Priority: 0 Task: Action 03
[Task] Priority: 0 Task: Action 05
[Task] Priority: 0 Task: Action 11
[Task] Priority: 0 Task: Action 20
[Task] Priority: 0 Task: Action 32
[Task] Priority: 0 Task: Action 36
[Task] Priority: 0 Task: Action 37
[Task] Priority: 0 Task: Action 41
[Task] Priority: 0 Task: Action 57
[Task] Priority: 0 Task: Action 67
[Task] Priority: 0 Task: Action 68
[Task] Priority: 0 Task: Action 69
[Task] Priority: 0 Task: Action 80
[Task] Priority: 0 Task: Action 82
[Task] Priority: 1 Task: Action 01
[Task] Priority: 1 Task: Action 04
[Task] Priority: 1 Task: Action 10
[Task] Priority: 1 Task: Action 17
[Task] Priority: 1 Task: Action 18
[Task] Priority: 1 Task: Action 23
[Task] Priority: 1 Task: Action 28
[Task] Priority: 1 Task: Action 33
[Task] Priority: 1 Task: Action 35
[Task] Priority: 1 Task: Action 43
[Task] Priority: 1 Task: Action 47
[Task] Priority: 1 Task: Action 51
[Task] Priority: 1 Task: Action 54
[Task] Priority: 1 Task: Action 58
[Task] Priority: 1 Task: Action 63
[Task] Priority: 1 Task: Action 74
[Task] Priority: 1 Task: Action 87
[Task] Priority: 1 Task: Action 91
[Task] Priority: 1 Task: Action 92
[Task] Priority: 1 Task: Action 94
[Task] Priority: 1 Task: Action 98
[Task] Priority: 1 Task: Action 99
[Task] Priority: 2 Task: Action 02
[Task] Priority: 2 Task: Action 06
[Task] Priority: 2 Task: Action 09
[Task] Priority: 2 Task: Action 13
[Task] Priority: 2 Task: Action 22
[Task] Priority: 2 Task: Action 24
[Task] Priority: 2 Task: Action 25
[Task] Priority: 2 Task: Action 26
[Task] Priority: 2 Task: Action 40
[Task] Priority: 2 Task: Action 42
[Task] Priority: 2 Task: Action 45
[Task] Priority: 2 Task: Action 49
[Task] Priority: 2 Task: Action 52
[Task] Priority: 2 Task: Action 53
[Task] Priority: 2 Task: Action 56
[Task] Priority: 2 Task: Action 59
[Task] Priority: 2 Task: Action 64
[Task] Priority: 2 Task: Action 66
[Task] Priority: 2 Task: Action 70
[Task] Priority: 2 Task: Action 77
[Task] Priority: 2 Task: Action 79
[Task] Priority: 2 Task: Action 83
[Task] Priority: 2 Task: Action 89
[Task] Priority: 2 Task: Action 96
[Task] Priority: 2 Task: Action 97
[Task] Priority: 3 Task: Action 07
[Task] Priority: 3 Task: Action 08
[Task] Priority: 3 Task: Action 12
[Task] Priority: 3 Task: Action 14
[Task] Priority: 3 Task: Action 21
[Task] Priority: 3 Task: Action 27
[Task] Priority: 3 Task: Action 29
[Task] Priority: 3 Task: Action 30
[Task] Priority: 3 Task: Action 31
[Task] Priority: 3 Task: Action 34
[Task] Priority: 3 Task: Action 44
[Task] Priority: 3 Task: Action 50
[Task] Priority: 3 Task: Action 55
[Task] Priority: 3 Task: Action 60
[Task] Priority: 3 Task: Action 61
[Task] Priority: 3 Task: Action 72
[Task] Priority: 3 Task: Action 73
[Task] Priority: 3 Task: Action 81
[Task] Priority: 3 Task: Action 95
[Task] Priority: 4 Task: Action 00
[Task] Priority: 4 Task: Action 15
[Task] Priority: 4 Task: Action 16
[Task] Priority: 4 Task: Action 19
[Task] Priority: 4 Task: Action 38
[Task] Priority: 4 Task: Action 39
[Task] Priority: 4 Task: Action 46
[Task] Priority: 4 Task: Action 48
[Task] Priority: 4 Task: Action 62
[Task] Priority: 4 Task: Action 65
[Task] Priority: 4 Task: Action 71
[Task] Priority: 4 Task: Action 75
[Task] Priority: 4 Task: Action 76
[Task] Priority: 4 Task: Action 78
[Task] Priority: 4 Task: Action 84
[Task] Priority: 4 Task: Action 85
[Task] Priority: 4 Task: Action 86
[Task] Priority: 4 Task: Action 88
[Task] Priority: 4 Task: Action 90
[Task] Priority: 4 Task: Action 93

Enter 1. To Add a Task
Enter 2. To Remove a Task
Enter 3. To Print Tasks To Console
Enter 4. To Read from a Task File
Enter 5. To Write to a Task File
Enter 9. To Quit
2

Enter the task's priority
0
Enter the task's action
Action 03

Enter 1. To Add a Task
Enter 2. To Remove a Task
Enter 3. To Print Tasks To Console
Enter 4. To Read from a Task File
Enter 5. To Write to a Task File
Enter 9. To Quit
3

[Task] Priority: 0 Task: Action 05
[Task] Priority: 0 Task: Action 11
[Task] Priority: 0 Task: Action 20
[Task] Priority: 0 Task: Action 32
[Task] Priority: 0 Task: Action 36
[Task] Priority: 0 Task: Action 37
[Task] Priority: 0 Task: Action 41
[Task] Priority: 0 Task: Action 57
[Task] Priority: 0 Task: Action 67
[Task] Priority: 0 Task: Action 68
[Task] Priority: 0 Task: Action 69
[Task] Priority: 0 Task: Action 80
[Task] Priority: 0 Task: Action 82
[Task] Priority: 1 Task: Action 01
[Task] Priority: 1 Task: Action 04
[Task] Priority: 1 Task: Action 10
[Task] Priority: 1 Task: Action 17
[Task] Priority: 1 Task: Action 18
[Task] Priority: 1 Task: Action 23
[Task] Priority: 1 Task: Action 28
[Task] Priority: 1 Task: Action 33
[Task] Priority: 1 Task: Action 35
[Task] Priority: 1 Task: Action 43
[Task] Priority: 1 Task: Action 47
[Task] Priority: 1 Task: Action 51
[Task] Priority: 1 Task: Action 54
[Task] Priority: 1 Task: Action 58
[Task] Priority: 1 Task: Action 63
[Task] Priority: 1 Task: Action 74
[Task] Priority: 1 Task: Action 87
[Task] Priority: 1 Task: Action 91
[Task] Priority: 1 Task: Action 92
[Task] Priority: 1 Task: Action 94
[Task] Priority: 1 Task: Action 98
[Task] Priority: 1 Task: Action 99
[Task] Priority: 2 Task: Action 02
[Task] Priority: 2 Task: Action 06
[Task] Priority: 2 Task: Action 09
[Task] Priority: 2 Task: Action 13
[Task] Priority: 2 Task: Action 22
[Task] Priority: 2 Task: Action 24
[Task] Priority: 2 Task: Action 25
[Task] Priority: 2 Task: Action 26
[Task] Priority: 2 Task: Action 40
[Task] Priority: 2 Task: Action 42
[Task] Priority: 2 Task: Action 45
[Task] Priority: 2 Task: Action 49
[Task] Priority: 2 Task: Action 52
[Task] Priority: 2 Task: Action 53
[Task] Priority: 2 Task: Action 56
[Task] Priority: 2 Task: Action 59
[Task] Priority: 2 Task: Action 64
[Task] Priority: 2 Task: Action 66
[Task] Priority: 2 Task: Action 70
[Task] Priority: 2 Task: Action 77
[Task] Priority: 2 Task: Action 79
[Task] Priority: 2 Task: Action 83
[Task] Priority: 2 Task: Action 89
[Task] Priority: 2 Task: Action 96
[Task] Priority: 2 Task: Action 97
[Task] Priority: 3 Task: Action 07
[Task] Priority: 3 Task: Action 08
[Task] Priority: 3 Task: Action 12
[Task] Priority: 3 Task: Action 14
[Task] Priority: 3 Task: Action 21
[Task] Priority: 3 Task: Action 27
[Task] Priority: 3 Task: Action 29
[Task] Priority: 3 Task: Action 30
[Task] Priority: 3 Task: Action 31
[Task] Priority: 3 Task: Action 34
[Task] Priority: 3 Task: Action 44
[Task] Priority: 3 Task: Action 50
[Task] Priority: 3 Task: Action 55
[Task] Priority: 3 Task: Action 60
[Task] Priority: 3 Task: Action 61
[Task] Priority: 3 Task: Action 72
[Task] Priority: 3 Task: Action 73
[Task] Priority: 3 Task: Action 81
[Task] Priority: 3 Task: Action 95
[Task] Priority: 4 Task: Action 00
[Task] Priority: 4 Task: Action 15
[Task] Priority: 4 Task: Action 16
[Task] Priority: 4 Task: Action 19
[Task] Priority: 4 Task: Action 38
[Task] Priority: 4 Task: Action 39
[Task] Priority: 4 Task: Action 46
[Task] Priority: 4 Task: Action 48
[Task] Priority: 4 Task: Action 62
[Task] Priority: 4 Task: Action 65
[Task] Priority: 4 Task: Action 71
[Task] Priority: 4 Task: Action 75
[Task] Priority: 4 Task: Action 76
[Task] Priority: 4 Task: Action 78
[Task] Priority: 4 Task: Action 84
[Task] Priority: 4 Task: Action 85
[Task] Priority: 4 Task: Action 86
[Task] Priority: 4 Task: Action 88
[Task] Priority: 4 Task: Action 90
[Task] Priority: 4 Task: Action 93

Enter 1. To Add a Task
Enter 2. To Remove a Task
Enter 3. To Print Tasks To Console
Enter 4. To Read from a Task File
Enter 5. To Write to a Task File
Enter 9. To Quit
1

Enter the task's priority
2
Enter the task's action
Plan to Add More Actions

Enter 1. To Add a Task
Enter 2. To Remove a Task
Enter 3. To Print Tasks To Console
Enter 4. To Read from a Task File
Enter 5. To Write to a Task File
Enter 9. To Quit
3

[Task] Priority: 0 Task: Action 05
[Task] Priority: 0 Task: Action 11
[Task] Priority: 0 Task: Action 20
[Task] Priority: 0 Task: Action 32
[Task] Priority: 0 Task: Action 36
[Task] Priority: 0 Task: Action 37
[Task] Priority: 0 Task: Action 41
[Task] Priority: 0 Task: Action 57
[Task] Priority: 0 Task: Action 67
[Task] Priority: 0 Task: Action 68
[Task] Priority: 0 Task: Action 69
[Task] Priority: 0 Task: Action 80
[Task] Priority: 0 Task: Action 82
[Task] Priority: 1 Task: Action 01
[Task] Priority: 1 Task: Action 04
[Task] Priority: 1 Task: Action 10
[Task] Priority: 1 Task: Action 17
[Task] Priority: 1 Task: Action 18
[Task] Priority: 1 Task: Action 23
[Task] Priority: 1 Task: Action 28
[Task] Priority: 1 Task: Action 33
[Task] Priority: 1 Task: Action 35
[Task] Priority: 1 Task: Action 43
[Task] Priority: 1 Task: Action 47
[Task] Priority: 1 Task: Action 51
[Task] Priority: 1 Task: Action 54
[Task] Priority: 1 Task: Action 58
[Task] Priority: 1 Task: Action 63
[Task] Priority: 1 Task: Action 74
[Task] Priority: 1 Task: Action 87
[Task] Priority: 1 Task: Action 91
[Task] Priority: 1 Task: Action 92
[Task] Priority: 1 Task: Action 94
[Task] Priority: 1 Task: Action 98
[Task] Priority: 1 Task: Action 99
[Task] Priority: 2 Task: Action 02
[Task] Priority: 2 Task: Action 06
[Task] Priority: 2 Task: Action 09
[Task] Priority: 2 Task: Action 13
[Task] Priority: 2 Task: Action 22
[Task] Priority: 2 Task: Action 24
[Task] Priority: 2 Task: Action 25
[Task] Priority: 2 Task: Action 26
[Task] Priority: 2 Task: Action 40
[Task] Priority: 2 Task: Action 42
[Task] Priority: 2 Task: Action 45
[Task] Priority: 2 Task: Action 49
[Task] Priority: 2 Task: Action 52
[Task] Priority: 2 Task: Action 53
[Task] Priority: 2 Task: Action 56
[Task] Priority: 2 Task: Action 59
[Task] Priority: 2 Task: Action 64
[Task] Priority: 2 Task: Action 66
[Task] Priority: 2 Task: Action 70
[Task] Priority: 2 Task: Action 77
[Task] Priority: 2 Task: Action 79
[Task] Priority: 2 Task: Action 83
[Task] Priority: 2 Task: Action 89
[Task] Priority: 2 Task: Action 96
[Task] Priority: 2 Task: Action 97
[Task] Priority: 2 Task: Plan to Add More Actions
[Task] Priority: 3 Task: Action 07
[Task] Priority: 3 Task: Action 08
[Task] Priority: 3 Task: Action 12
[Task] Priority: 3 Task: Action 14
[Task] Priority: 3 Task: Action 21
[Task] Priority: 3 Task: Action 27
[Task] Priority: 3 Task: Action 29
[Task] Priority: 3 Task: Action 30
[Task] Priority: 3 Task: Action 31
[Task] Priority: 3 Task: Action 34
[Task] Priority: 3 Task: Action 44
[Task] Priority: 3 Task: Action 50
[Task] Priority: 3 Task: Action 55
[Task] Priority: 3 Task: Action 60
[Task] Priority: 3 Task: Action 61
[Task] Priority: 3 Task: Action 72
[Task] Priority: 3 Task: Action 73
[Task] Priority: 3 Task: Action 81
[Task] Priority: 3 Task: Action 95
[Task] Priority: 4 Task: Action 00
[Task] Priority: 4 Task: Action 15
[Task] Priority: 4 Task: Action 16
[Task] Priority: 4 Task: Action 19
[Task] Priority: 4 Task: Action 38
[Task] Priority: 4 Task: Action 39
[Task] Priority: 4 Task: Action 46
[Task] Priority: 4 Task: Action 48
[Task] Priority: 4 Task: Action 62
[Task] Priority: 4 Task: Action 65
[Task] Priority: 4 Task: Action 71
[Task] Priority: 4 Task: Action 75
[Task] Priority: 4 Task: Action 76
[Task] Priority: 4 Task: Action 78
[Task] Priority: 4 Task: Action 84
[Task] Priority: 4 Task: Action 85
[Task] Priority: 4 Task: Action 86
[Task] Priority: 4 Task: Action 88
[Task] Priority: 4 Task: Action 90
[Task] Priority: 4 Task: Action 93

Enter 1. To Add a Task
Enter 2. To Remove a Task
Enter 3. To Print Tasks To Console
Enter 4. To Read from a Task File
Enter 5. To Write to a Task File
Enter 9. To Quit
5

Enter the file name
NewTasks.txt

Enter 1. To Add a Task
Enter 2. To Remove a Task
Enter 3. To Print Tasks To Console
Enter 4. To Read from a Task File
Enter 5. To Write to a Task File
Enter 9. To Quit
9

Goodbye!
```
