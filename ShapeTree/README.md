# Shape Tree

## Objective:

Write a program where a user can maintain a collection of shapes that are organized by their area using a binary search tree data structure. The program must be able to add/remove shapes, read/write to shape files, search for shapes, and perform a variety of other operations

## Requirements

### Data Structures

- Use only a Binary Search Tree of your own creation.

  - Other Java built-in types ArrayLists, LinkedLists, Queues, etc are not allowed.

- You may add, remove, or modify functionality in your generic Binary Search Tree.
  - **HINT:** It also valid to create a specific binary search tree instead of using the generic version. In other words, a Binary Search Tree specifically for Shapes and nothing else.

### Interface

- Users should easily understand what the program does and how to use it.

- Users should be prompted for input and should be able to enter data easily.

- Users should be presented with output after major functions, operations, or calculations.

- Users should be able to perform any number of the required functions. In addition, users should be able to choose when to terminate the program.

- Users must be able to easily add shapes, remove shapes, search for a shape, find the shape with the maximum area, remove all shapes greater than a certain area, read from a shape file, or write to a shape file.

- The user must also be able to print the data to the console by specifying either Pre-Order, In-Order, or Post-Order traversals.

### Add a Shape

- The program must be able to add new shapes to the tree, and these shapes can either be a Rectangle, Circle, or Right Triangle.

- Depending on the type of shape to be added, the program must prompt the user for the required shape information to calculate its area. For instance, the program must ask the user for a length and width for a rectangle, a base and height for a triangle, and a radius for a circle.

- The shape must then be added to the Shape Tree its location must be determined by its area. If two shapes have the same area, then place it based on the type of shape in the order Circle, then Rectangle, finally Right Triangle. If the area and the type are the same, then do not add the duplicate shape.

- After adding a shape, the structure of the binary search tree must be preserved.

### Remove a Shape

- The program must be able to remove shapes from the tree.

- Remove is not based on the area but is based on the type of shape and that shape’s information. The user must provide the type of shape and the information related to that type of shape to be removed. For instance, if the user wanted to remove a Rectangle, then they must provide the length and width associated with that rectangle, and similarly if the user wanted to remove a Circle, then they must provide the radius of the circle.

- After removing a shape, the structure of the binary search tree must be preserved.

### Search for a Shape

- The program must be able to determine, true or false, if a shape is found in the tree.

- The program must use the properties of a binary search tree to do this quickly.

- The user must supply the shape’s information including the type and its properties. For instance, if the user wanted to search for a triangle, then they must specify “Triangle” and then provide its base and height.

### Max Area

- The program must return the shape that has the maximum area.

- This must use the properties of a binary search tree to quickly determine the shape with the largest area.

### Removes Shapes Greater Than

- The program must be able to remove all shapes that have areas greater than a specified area.

- The program must use the properties of a binary search tree to do this quickly.

- After this occurs, the binary search tree’s structure must be preserved.

### Reading a Shape File

- The program must be able to read a Shape file and have these shapes added to the current shape tree.

- The file format is TAB delimited and always starts with the kind of shape followed by its information. This information is further separated using an END-LINE. For example,

```
<<Shape Type 00>>\t<<Shape Information 00>>\n
<<Shape Type 01>>\t<<Shape Information 00>>\n
…
<<Shape Type N>>\t<<Shape Information N>>\n
```

- This does change depending on the type of shape, for example

```
Rectangle\t<<Length>>\t<<Width>>\n
Circle\t<<Radius>>\n
Right Triangle\t<<Base>>\t<<Height>>\n
```

- The previous shapes in the tree must remain there, and when these new shapes are added they must preserve the properties of a binary search tree.

- An example file is provided (Shapes.txt)

### Writing the Shape File

- The program must be able to write to a Shape file in the specified format.

- The file format is TAB delimited and always starts with the kind of shape followed by its information. This information is further separated using an END-LINE. For example,

```
<<Shape Type 00>>\t<<Shape Information 00>>\n
<<Shape Type 01>>\t<<Shape Information 00>>\n
…
<<Shape Type N>>\t<<Shape Information N>>\n
```

- This does change depending on the type of shape, for example

```
Rectangle\t<<Length>>\t<<Width>>\n
Circle\t<<Radius>>\n
Right Triangle\t<<Base>>\t<<Height>>\n
```

## More Notes

- Area for each shape is assumed to be
  - Circle = $\text{radius}^2$ x PI
  - Rectangle = length x width
  - Right Triangle = ½ base x height

## Example Diaglogue

```
Welcome to the Shape Tree!

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
1

Enter the file's name
shapes.txt

Printing after Reading In-Order

Right Triangle Base: 2.0 Height: 2.0 Area: 2.0
Right Triangle Base: 3.0 Height: 2.0 Area: 3.0
Circle Radius: 2.0 Area: 12.566370614359172
Rectangle Length: 2.0  Width: 7.0 Area: 14.0
Right Triangle Base: 5.0 Height: 6.0 Area: 15.0
Rectangle Length: 9.0  Width: 2.0 Area: 18.0
Rectangle Length: 5.0  Width: 4.0 Area: 20.0
Rectangle Length: 3.0  Width: 8.0 Area: 24.0
Rectangle Length: 5.0  Width: 5.0 Area: 25.0
Right Triangle Base: 9.0 Height: 9.0 Area: 40.5
Circle Radius: 4.0 Area: 50.26548245743669
Circle Radius: 7.0 Area: 153.93804002589985
Circle Radius: 8.0 Area: 201.06192982974676
Circle Radius: 9.0 Area: 254.46900494077323

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
2

Which traversal?
Enter 1. For Pre-order.
Enter 2. For In-order
Enter 3. For Post-order
1

Rectangle Length: 5.0  Width: 4.0 Area: 20.0
Right Triangle Base: 3.0 Height: 2.0 Area: 3.0
Right Triangle Base: 2.0 Height: 2.0 Area: 2.0
Rectangle Length: 2.0  Width: 7.0 Area: 14.0
Circle Radius: 2.0 Area: 12.566370614359172
Right Triangle Base: 5.0 Height: 6.0 Area: 15.0
Rectangle Length: 9.0  Width: 2.0 Area: 18.0
Circle Radius: 4.0 Area: 50.26548245743669
Rectangle Length: 5.0  Width: 5.0 Area: 25.0
Rectangle Length: 3.0  Width: 8.0 Area: 24.0
Right Triangle Base: 9.0 Height: 9.0 Area: 40.5
Circle Radius: 8.0 Area: 201.06192982974676
Circle Radius: 7.0 Area: 153.93804002589985
Circle Radius: 9.0 Area: 254.46900494077323

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
3

Enter the type of shape to add
Right triangle
Enter the base followed by the height
36
47

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
2

Which traversal?
Enter 1. For Pre-order.
Enter 2. For In-order
Enter 3. For Post-order
2

Right Triangle Base: 2.0 Height: 2.0 Area: 2.0
Right Triangle Base: 3.0 Height: 2.0 Area: 3.0
Circle Radius: 2.0 Area: 12.566370614359172
Rectangle Length: 2.0  Width: 7.0 Area: 14.0
Right Triangle Base: 5.0 Height: 6.0 Area: 15.0
Rectangle Length: 9.0  Width: 2.0 Area: 18.0
Rectangle Length: 5.0  Width: 4.0 Area: 20.0
Rectangle Length: 3.0  Width: 8.0 Area: 24.0
Rectangle Length: 5.0  Width: 5.0 Area: 25.0
Right Triangle Base: 9.0 Height: 9.0 Area: 40.5
Circle Radius: 4.0 Area: 50.26548245743669
Circle Radius: 7.0 Area: 153.93804002589985
Circle Radius: 8.0 Area: 201.06192982974676
Circle Radius: 9.0 Area: 254.46900494077323
Right Triangle Base: 36.0 Height: 47.0 Area: 846.0

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
4

Enter the type of shape to remove
Rectangle
Enter the length followed by the width
5
4

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
2

Which traversal?
Enter 1. For Pre-order.
Enter 2. For In-order
Enter 3. For Post-order
2

Right Triangle Base: 2.0 Height: 2.0 Area: 2.0
Right Triangle Base: 3.0 Height: 2.0 Area: 3.0
Circle Radius: 2.0 Area: 12.566370614359172
Rectangle Length: 2.0  Width: 7.0 Area: 14.0
Right Triangle Base: 5.0 Height: 6.0 Area: 15.0
Rectangle Length: 9.0  Width: 2.0 Area: 18.0
Rectangle Length: 3.0  Width: 8.0 Area: 24.0
Rectangle Length: 5.0  Width: 5.0 Area: 25.0
Right Triangle Base: 9.0 Height: 9.0 Area: 40.5
Circle Radius: 4.0 Area: 50.26548245743669
Circle Radius: 7.0 Area: 153.93804002589985
Circle Radius: 8.0 Area: 201.06192982974676
Circle Radius: 9.0 Area: 254.46900494077323
Right Triangle Base: 36.0 Height: 47.0 Area: 846.0

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
5

Enter the type of shape to Search
Circle
Enter the radius
4

Was the shape in the tree? true

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
6

The shape with the max area Right Triangle Base: 36.0 Height: 47.0 Area: 846.0

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
7

Enter the maximum area
100

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
2

Which traversal?
Enter 1. For Pre-order.
Enter 2. For In-order
Enter 3. For Post-order
2

Right Triangle Base: 2.0 Height: 2.0 Area: 2.0
Right Triangle Base: 3.0 Height: 2.0 Area: 3.0
Circle Radius: 2.0 Area: 12.566370614359172
Rectangle Length: 2.0  Width: 7.0 Area: 14.0
Right Triangle Base: 5.0 Height: 6.0 Area: 15.0
Rectangle Length: 9.0  Width: 2.0 Area: 18.0
Rectangle Length: 3.0  Width: 8.0 Area: 24.0
Rectangle Length: 5.0  Width: 5.0 Area: 25.0
Right Triangle Base: 9.0 Height: 9.0 Area: 40.5
Circle Radius: 4.0 Area: 50.26548245743669

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
8

Enter the file's name
newShapes.txt

Enter 1. To Read a Shape Tree from a File.
Enter 2. To Print a Tree Traversal to the Console
Enter 3. To Add a Shape.
Enter 4. To Remove a Shape.
Enter 5. To Search for a Shape.
Enter 6. To Find the Shape with the Max Area.
Enter 7. To Remove All Shapes Greater than an Area.
Enter 8. To Print Shape Tree to File.
Enter 0. To Quit.
0

Goodbye!
```

### newShapes.txt

```
Right Triangle	2.0	2.0
Right Triangle	3.0	2.0
Circle	2.0
Rectangle	2.0	7.0
Right Triangle	5.0	6.0
Rectangle	9.0	2.0
Rectangle	3.0	8.0
Rectangle	5.0	5.0
Right Triangle	9.0	9.0
Circle	4.0
```
