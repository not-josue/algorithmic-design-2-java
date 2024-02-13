# Process Queue Simulator

## Objective

Write a program which simulates first come first serve process scheduling using a queue.

## Requirements

### Setup the Project

- Use the driver file (ProcessSchedulerSimulator.java) in your project.

- Do **NOT** modify the driver file.

### Process Class

- Create a class and name it exactly **Process**.

- This class has two attributes:

  - **Name:** a non-null String, whose default value is “none”
  - **Completion time:** a positive decimal value that indicates how long the process has until it is finished, whose default value is 0.0

- Create accessors and mutators for each attribute. Mutators must check for valid values.

- This class must have a **“toString”** method that returns a type String formatted as:

```
Process Name: <<Name>> Completion Time: <<Completion Time>>
```

### Queue Interface

- Create an interface and name it exactly **QueueI**

- The interface must accept a Generic Type.

- The interface must have the following method signatures:

  - **Enqueue:** A public method that takes in a parameter of the Generic Type returns nothing.

  - **Dequeue:** A public method that takes in no parameters and returns the Generic Type.

  - **Peek:** A public method that takes in no parameters and returns the Generic Type.

  - **Print:** A public method that takes in no parameters and returns nothing.

### Linked List Queue Class

- Create a class and name it exactly **LLQueue**

- The class must accept a Generic Type.

- The class must have the following methods:

  - **Enqueue:** This method returns nothing and takes in some generic data that is added to the end of the queue.

  - **Dequeue:** This method removes and returns the first element’s data of the queue as long as the head is not null.

  - **Peek:** Returns the first element’s data but doesn’t remove the element.

  - **Print:** Prints out the entire queue.

### Process Scheduler Class

- Create a class and name it exactly **ProcessScheduler**

- This class has two properties:

  - **Processes:** This is a linked list queue of processes (referred to as “process queue”). This data structure holds the processes that are waiting to run.

  - **Current Process:** This is the currently running process of type Process. This is a separate value that is not contained in the process queue.

- The class must have the following methods:

  - **getCurrentProcess:** This method takes no parameters and returns the currently running process. **Note that this is not the first element of the process queue.**

  - **addProcess:** Taking in a process via a parameter it either sets the current process if the current process is null or it adds it to the process queue. Also, it doesn’t return any values.

  - **runNextProcess:** This method dequeues from the process queue and sets that to the current process.

  - **cancelCurrentProcess:** The current process is cancelled and is replaced by the first element on the process queue. Make sure that the process is also removed from the process queue after the current process has been set. Neither parameters nor return values are expected for this method.

  - **printProcessQueue:** This method should print all of the elements from the process queue.

## Example Dialogue

```
---------------------------
Welcome to the process scheduler simulator
---------------------------

---------------------------
Time Step 0
---------------------------

***No processes currently running***
***Current Process Queue***

---------------------------
Time Step 1
---------------------------

***Adding a new Process Process Name: Process1 Completion Time: 6.193690462232073***
***Current Process Process Name: Process1 Completion Time: 6.193690462232073***
***Updating Completion Time Process Name: Process1 Completion Time: 5.193690462232073***
***Current Process Queue***

---------------------------
Time Step 2
---------------------------

***Current Process Process Name: Process1 Completion Time: 5.193690462232073***
***Updating Completion Time Process Name: Process1 Completion Time: 4.193690462232073***
***Current Process Queue***

---------------------------
Time Step 3
---------------------------

***Adding a new Process Process Name: Process2 Completion Time: 5.351469525086384***
***Current Process Process Name: Process1 Completion Time: 4.193690462232073***
***Updating Completion Time Process Name: Process1 Completion Time: 3.193690462232073***

***Current Process Queue***
Process Name: Process2 Completion Time: 5.351469525086384

---------------------------
Time Step 4
---------------------------

***Adding a new Process Process Name: Process3 Completion Time: 13.384343172978909***
***Current Process Process Name: Process1 Completion Time: 3.193690462232073***
***Updating Completion Time Process Name: Process1 Completion Time: 2.193690462232073***

***Current Process Queue***
Process Name: Process2 Completion Time: 5.351469525086384
Process Name: Process3 Completion Time: 13.384343172978909

---------------------------
Time Step 5
---------------------------

***Current Process Process Name: Process1 Completion Time: 2.193690462232073***
***Updating Completion Time Process Name: Process1 Completion Time: 1.1936904622320732***

***Current Process Queue***
Process Name: Process2 Completion Time: 5.351469525086384
Process Name: Process3 Completion Time: 13.384343172978909

---------------------------
Time Step 6
---------------------------

***Current Process Process Name: Process1 Completion Time: 1.1936904622320732***
***Updating Completion Time Process Name: Process1 Completion Time: 0.1936904622320732***

***Current Process Queue***
Process Name: Process2 Completion Time: 5.351469525086384
Process Name: Process3 Completion Time: 13.384343172978909

---------------------------
Time Step 7
---------------------------

***Current Process Process Name: Process1 Completion Time: 0.1936904622320732***
***Updating Completion Time Process Name: Process1 Completion Time: 0.0***

***Current Process Queue***
Process Name: Process2 Completion Time: 5.351469525086384
Process Name: Process3 Completion Time: 13.384343172978909

---------------------------
Time Step 8
---------------------------

***Adding a new Process Process Name: Process4 Completion Time: 1.7423775117100637***
***Current Process Complete***
***New current process Process Name: Process2 Completion Time: 5.351469525086384***

***Current Process Queue***
Process Name: Process3 Completion Time: 13.384343172978909
Process Name: Process4 Completion Time: 1.7423775117100637

---------------------------
Time Step 9
---------------------------

***Current Process Process Name: Process2 Completion Time: 5.351469525086384***
***Updating Completion Time Process Name: Process2 Completion Time: 4.351469525086384***

***Current Process Queue***
Process Name: Process3 Completion Time: 13.384343172978909
Process Name: Process4 Completion Time: 1.7423775117100637

---------------------------
Time Step 10
---------------------------

***Current Process Process Name: Process2 Completion Time: 4.351469525086384***
***Updating Completion Time Process Name: Process2 Completion Time: 3.351469525086384***

***Current Process Queue***
Process Name: Process3 Completion Time: 13.384343172978909
Process Name: Process4 Completion Time: 1.7423775117100637

---------------------------
Time Step 11
---------------------------

***Current Process Process Name: Process2 Completion Time: 3.351469525086384***
***Updating Completion Time Process Name: Process2 Completion Time: 2.351469525086384***

***Current Process Queue***
Process Name: Process3 Completion Time: 13.384343172978909
Process Name: Process4 Completion Time: 1.7423775117100637

---------------------------
Time Step 12
---------------------------

***Current Process Process Name: Process2 Completion Time: 2.351469525086384***
***Updating Completion Time Process Name: Process2 Completion Time: 1.351469525086384***

***Current Process Queue***
Process Name: Process3 Completion Time: 13.384343172978909
Process Name: Process4 Completion Time: 1.7423775117100637

---------------------------
Time Step 13
---------------------------

***Current Process Process Name: Process2 Completion Time: 1.351469525086384***
***Updating Completion Time Process Name: Process2 Completion Time: 0.35146952508638396***

***Current Process Queue***
Process Name: Process3 Completion Time: 13.384343172978909
Process Name: Process4 Completion Time: 1.7423775117100637

---------------------------
Time Step 14
---------------------------

***Adding a new Process Process Name: Process5 Completion Time: 10.03799757890731***
***Current Process Process Name: Process2 Completion Time: 0.35146952508638396***
***Updating Completion Time Process Name: Process2 Completion Time: 0.0***

***Current Process Queue***
Process Name: Process3 Completion Time: 13.384343172978909
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731

---------------------------
Time Step 15
---------------------------

***Current Process Complete***
***New current process Process Name: Process3 Completion Time: 13.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731

---------------------------
Time Step 16
---------------------------

***Current Process Process Name: Process3 Completion Time: 13.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 12.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731

---------------------------
Time Step 17
---------------------------

***Adding a new Process Process Name: Process6 Completion Time: 3.131933765050175***
***Current Process Process Name: Process3 Completion Time: 12.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 11.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175

---------------------------
Time Step 18
---------------------------

***Current Process Process Name: Process3 Completion Time: 11.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 10.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175

---------------------------
Time Step 19
---------------------------

***Adding a new Process Process Name: Process7 Completion Time: 8.836364654497665***
***Current Process Process Name: Process3 Completion Time: 10.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 9.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665

---------------------------
Time Step 20
---------------------------

***Adding a new Process Process Name: Process8 Completion Time: 11.102678058945164***
***Current Process Process Name: Process3 Completion Time: 9.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 8.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164

---------------------------
Time Step 21
---------------------------

***Adding a new Process Process Name: Process9 Completion Time: 10.71699362560612***
***Current Process Process Name: Process3 Completion Time: 8.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 7.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612

---------------------------
Time Step 22
---------------------------

***Current Process Process Name: Process3 Completion Time: 7.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 6.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612

---------------------------
Time Step 23
---------------------------

***Current Process Process Name: Process3 Completion Time: 6.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 5.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612

---------------------------
Time Step 24
---------------------------

***Current Process Process Name: Process3 Completion Time: 5.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 4.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612

---------------------------
Time Step 25
---------------------------

***Current Process Process Name: Process3 Completion Time: 4.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 3.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612

---------------------------
Time Step 26
---------------------------

***Adding a new Process Process Name: Process10 Completion Time: 6.378047723810189***
***Current Process Process Name: Process3 Completion Time: 3.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 2.384343172978909***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189

---------------------------
Time Step 27
---------------------------

***Adding a new Process Process Name: Process11 Completion Time: 2.3695120975249573***
***Current Process Process Name: Process3 Completion Time: 2.384343172978909***
***Updating Completion Time Process Name: Process3 Completion Time: 1.3843431729789089***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573

---------------------------
Time Step 28
---------------------------

***Current Process Process Name: Process3 Completion Time: 1.3843431729789089***
***Updating Completion Time Process Name: Process3 Completion Time: 0.38434317297890885***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573

---------------------------
Time Step 29
---------------------------

***Adding a new Process Process Name: Process12 Completion Time: 14.651153475837111***
***Current Process Process Name: Process3 Completion Time: 0.38434317297890885***
***Updating Completion Time Process Name: Process3 Completion Time: 0.0***

***Current Process Queue***
Process Name: Process4 Completion Time: 1.7423775117100637
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111

---------------------------
Time Step 30
---------------------------

***Current Process Complete***
***New current process Process Name: Process4 Completion Time: 1.7423775117100637***

***Current Process Queue***
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111

---------------------------
Time Step 31
---------------------------

***Current Process Process Name: Process4 Completion Time: 1.7423775117100637***
***Updating Completion Time Process Name: Process4 Completion Time: 0.7423775117100637***

***Current Process Queue***
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111

---------------------------
Time Step 32
---------------------------

***Adding a new Process Process Name: Process13 Completion Time: 9.898589698658695***
***Current Process Process Name: Process4 Completion Time: 0.7423775117100637***
***Updating Completion Time Process Name: Process4 Completion Time: 0.0***

***Current Process Queue***
Process Name: Process5 Completion Time: 10.03799757890731
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695

---------------------------
Time Step 33
---------------------------

***Current Process Complete***
***New current process Process Name: Process5 Completion Time: 10.03799757890731***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695

---------------------------
Time Step 34
---------------------------

***Current Process Process Name: Process5 Completion Time: 10.03799757890731***
***Updating Completion Time Process Name: Process5 Completion Time: 9.03799757890731***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695

---------------------------
Time Step 35
---------------------------

***Adding a new Process Process Name: Process14 Completion Time: 0.4854788654270631***
***Current Process Process Name: Process5 Completion Time: 9.03799757890731***
***Updating Completion Time Process Name: Process5 Completion Time: 8.03799757890731***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631

---------------------------
Time Step 36
---------------------------

***Adding a new Process Process Name: Process15 Completion Time: 14.048683911108137***
***Current Process Process Name: Process5 Completion Time: 8.03799757890731***
***Updating Completion Time Process Name: Process5 Completion Time: 7.03799757890731***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137

---------------------------
Time Step 37
---------------------------

***Adding a new Process Process Name: Process16 Completion Time: 13.564303723296447***
***Current Process Process Name: Process5 Completion Time: 7.03799757890731***
***Updating Completion Time Process Name: Process5 Completion Time: 6.03799757890731***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447

---------------------------
Time Step 38
---------------------------

***Current Process Process Name: Process5 Completion Time: 6.03799757890731***
***Updating Completion Time Process Name: Process5 Completion Time: 5.03799757890731***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447

---------------------------
Time Step 39
---------------------------

***Current Process Process Name: Process5 Completion Time: 5.03799757890731***
***Updating Completion Time Process Name: Process5 Completion Time: 4.03799757890731***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447

---------------------------
Time Step 40
---------------------------

***Current Process Process Name: Process5 Completion Time: 4.03799757890731***
***Updating Completion Time Process Name: Process5 Completion Time: 3.0379975789073104***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447

---------------------------
Time Step 41
---------------------------

***Adding a new Process Process Name: Process17 Completion Time: 6.959902263530519***
***Current Process Process Name: Process5 Completion Time: 3.0379975789073104***
***Updating Completion Time Process Name: Process5 Completion Time: 2.0379975789073104***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447
Process Name: Process17 Completion Time: 6.959902263530519

---------------------------
Time Step 42
---------------------------

***Current Process Process Name: Process5 Completion Time: 2.0379975789073104***
***Updating Completion Time Process Name: Process5 Completion Time: 1.0379975789073104***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447
Process Name: Process17 Completion Time: 6.959902263530519

---------------------------
Time Step 43
---------------------------

***Current Process Process Name: Process5 Completion Time: 1.0379975789073104***
***Updating Completion Time Process Name: Process5 Completion Time: 0.03799757890731037***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447
Process Name: Process17 Completion Time: 6.959902263530519

---------------------------
Time Step 44
---------------------------

***Current Process Process Name: Process5 Completion Time: 0.03799757890731037***
***Updating Completion Time Process Name: Process5 Completion Time: 0.0***

***Current Process Queue***
Process Name: Process6 Completion Time: 3.131933765050175
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447
Process Name: Process17 Completion Time: 6.959902263530519

---------------------------
Time Step 45
---------------------------

***Current Process Complete***
***New current process Process Name: Process6 Completion Time: 3.131933765050175***

***Current Process Queue***
Process Name: Process7 Completion Time: 8.836364654497665
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447
Process Name: Process17 Completion Time: 6.959902263530519

---------------------------
Time Step 46
---------------------------

***Adding a new Process Process Name: Process18 Completion Time: 12.128243531992108***
***Cancelling current Process***
***Current Process Process Name: Process7 Completion Time: 8.836364654497665***
***Updating Completion Time Process Name: Process7 Completion Time: 7.836364654497665***

***Current Process Queue***
Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447
Process Name: Process17 Completion Time: 6.959902263530519
Process Name: Process18 Completion Time: 12.128243531992108

---------------------------
Time Step 47
---------------------------

***Current Process Process Name: Process7 Completion Time: 7.836364654497665***
***Updating Completion Time Process Name: Process7 Completion Time: 6.836364654497665***

***Current Process Queue***

Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447
Process Name: Process17 Completion Time: 6.959902263530519
Process Name: Process18 Completion Time: 12.128243531992108

---------------------------
Time Step 48
---------------------------

***Current Process Process Name: Process7 Completion Time: 6.836364654497665***
***Updating Completion Time Process Name: Process7 Completion Time: 5.836364654497665***

***Current Process Queue***

Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447
Process Name: Process17 Completion Time: 6.959902263530519
Process Name: Process18 Completion Time: 12.128243531992108

---------------------------
Time Step 49
---------------------------

***Adding a new Process Process Name: Process19 Completion Time: 1.4169154838875002***
***Current Process Process Name: Process7 Completion Time: 5.836364654497665***
***Updating Completion Time Process Name: Process7 Completion Time: 4.836364654497665***

***Current Process Queue***

Process Name: Process8 Completion Time: 11.102678058945164
Process Name: Process9 Completion Time: 10.71699362560612
Process Name: Process10 Completion Time: 6.378047723810189
Process Name: Process11 Completion Time: 2.3695120975249573
Process Name: Process12 Completion Time: 14.651153475837111
Process Name: Process13 Completion Time: 9.898589698658695
Process Name: Process14 Completion Time: 0.4854788654270631
Process Name: Process15 Completion Time: 14.048683911108137
Process Name: Process16 Completion Time: 13.564303723296447
Process Name: Process17 Completion Time: 6.959902263530519
Process Name: Process18 Completion Time: 12.128243531992108
Process Name: Process19 Completion Time: 1.4169154838875002
```
