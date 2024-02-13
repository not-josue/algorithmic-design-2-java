# SORT sort

## Objective

I really like the word SORT! SORT SORT SORT SORT! All SORTS of SORTS! Anyways, I like it so much that I want you to write a program to analyze some strings inputted from the user, count the number of times SORT (case doesn’t matter) appears in each string, then sort them from least number of SORT’s to most number of SORT’s!

## Requirements

### Entering Data

- The user must be able to enter any number of Strings that will be sorted.

- The Strings must be stored inside of a data structure; either an Array or a Data Structure of your own creation (like a Generic Linked List).

### Counting "Sort"

- The program must then count the number of times the String “SORT” appears for each String.

- Case does not matter, so “SORT”, “sort”, or “sOrT” would all count.

### Sorting "Sort"

- Strings must be sorted based on the number of times that “SORT” appears from least to most.

- A sorting algorithm of one’s on creation must be used.

- The program must use a sorting algorithm that is either O(nlg(n)) or Ɵ(nlg(n)) time complexity.

### Printing the results and Restarting

- Once sorted, the program must print out the results.

- Then the program must prompt the user if they would like to sort anymore Strings, and must restart if they choose to sort more Strings.

## Example Dialogue

```
Enter any number of strings and I will sort by SORT’s. Once you’re done entering sentences enter “quit”.

Sort
asdf
asdfsort
asdfasdfsortSortSORTsort
sortsortsortsortSORTSORTSORTSORT
qwertqwertqwertqwertsortSORT
sortzilla
quit

sort SORTED!

asdf
Sort
asdfsort
sortzilla
qwertqwertqwertqwertsortSORT
asdfasdfsortSortSORTsort
sortsortsortsortSORTSORTSORTSORT

Would you like to sort more Strings?
No

Goodbye!
```
