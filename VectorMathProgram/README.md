# Vector Math Program

## Objective

- Write a program that performs a variety of vector math operations. These operations include adding vectors, subtracting vectors, and finding the magnitude of a vector.

## Requirements

### Data Structures

- Use only Arrays to represent the Vectors and assume a decimal type.

### Clear and Easy-To-Use Interface

- Users should easily understand what the program does and how to use it.
- Users should be prompted for input and should be able to enter data easily.
- Users should be presented with output after major functions, operations, or calculations.
- Users should be able to perform any number of the required functions. In addition, users should be able to choose when to terminate the program.

### Adding Two Vectors

- Users should be able to enter the size and values for both Vectors. The size of a vector must be greater or equal to 1 and the two vectors being added must have the exact same size. Otherwise, the user must be prompted there is an error and the program must continue and not terminate.
- The program should clearly output the resulting Vector to the user.

### Subtracting Two Vectors

- Users should be able to enter the size and values for both Vectors. The size of a vector must be greater or equal to 1 and the two vectors being added must have the exact same size. Otherwise, the user must be prompted there is an error and the program must continue and not terminate.
- The program should clearly output the resulting Vector to the user.

### Find the Magnitude of a Vector

- Users should be able to enter the size and values of the Vector. The size of a vector must be greater or equal to 1. Otherwise, the user must be prompted there is an error and the program must continue and not terminate.
- The program should clearly output the resulting magnitude to the user.

### Run-Time and Logic Error Checking

- Each major function must check for common run-time and logic errors.

## Additional Notes

### Vector Addition

- Adding together two vectors first requires each vector have the same number of components (the same size). The result of vector addition creates a new vector where its components are the result of each component-wise addition.
- Example:

\[
\begin{pmatrix}
5 \\
7
\end{pmatrix}
{+}
\begin{pmatrix}
12 \\
3
\end{pmatrix}
{=}
\begin{pmatrix}
17 \\
10
\end{pmatrix}
\]

### Vector Subtraction

- Subtracting two vectors first requires each vector have the same number of components (the same size). The result of vector subtraction creates a new vector where its components are the result of each component-wise subtraction.
- Example:

\[
\begin{pmatrix}
5 \\
7 \\
9 \\
15
\end{pmatrix}
{-}
\begin{pmatrix}
12 \\
3 \\
13 \\
1
\end{pmatrix}
{=}
\begin{pmatrix}
-7 \\
4 \\
-4 \\
14
\end{pmatrix}
\]

### Vector Magnitude

- Finding the magnitude of a vector requires finding the square root of the sum of its components squared.
- Example:

\[
\left |
\begin{pmatrix}
2 \\
3 \\
4 \\
5 \\
\end{pmatrix}
\right |
{=}
\sqrt{2^2 + 3^2 + 4^2 + 5^2 + 6^2}
{=}
\sqrt{90}
\approx
9.48
\]

## Example Dialogue

```
Welcome to the Vector Operations Program!

Enter 1. To Add 2 Vectors
Enter 2. To Subtract 2 Vectors
Enter 3. To Find the Magnitude of a Vector
Enter 9. To Quit
1

Enter the size of the Vectors
3
Enter values for Vector1
1.0
2.0
3.0
Enter values for Vector2
4.0
5.0
6.0

Result:
1.0
2.0
3.0
+
4.0
5.0
6.0
=
5.0
7.0
9.0

Enter 1. To Add 2 Vectors
Enter 2. To Subtract 2 Vectors
Enter 3. To Find the Magnitude of a Vector
Enter 9. To Quit
2

Enter the size of the Vectors
3
Enter values for Vector1
1.0
2.0
3.0
Enter values for Vector2
4.0
5.0
6.0

Result:
1.0
2.0
3.0
-
4.0
5.0
6.0
=
-3.0
-3.0
-3.0.

Enter 1. To Add 2 Vectors
Enter 2. To Subtract 2 Vectors
Enter 3. To Find the Magnitude of a Vector
Enter 9. To Quit
3

Enter the size of the Vector
5
Enter values for the Vector
1.0
2.0
3.0
4.0
5.0

The magnitude is: 7.416198487095663

Enter 1. To Add 2 Vectors
Enter 2. To Subtract 2 Vectors
Enter 3. To Find the Magnitude of a Vector
Enter 9. To Quit
2

Enter the size of the Vectors
0
Invalid Size

Enter 1. To Add 2 Vectors
Enter 2. To Subtract 2 Vectors
Enter 3. To Find the Magnitude of a Vector
Enter 9. To Quit
9

Goodbye!
```
