# Grocery List

## Objective

Implement a system that keeps track of groceries in a singly linked-list.

## Requirements

### Setup the Project

- Use the given driver file (GroceryListTester.java) and text file (GroceryList.txt)

- Do NOT modify the driver or the text file

### Grocery Item Class

- Create a class and name it exactly GroceryItem

#### Instance Variables

- **Name:** a string value that contains the name of the grocery item. Its default value is “none” and must not be null.

- **Value:** a decimal value that corresponds to the price of the item. Its default value is 0.

#### Constructors

- **Default:** Must set all properties to their default values mentioned in the “Instance Variables” section.

- **Parameterized:** Must take in a parameter for each instance variable in the order named above. This means the first instance variable is the first parameter, the second instance variable is the second parameter, and so on. This must set the instance variable values only if the given values are valid, but otherwise it must set the instance variables to their default values.

#### Methods

- Create accessors and mutators for each attribute. Mutators must check for valid values.

- **toString:** a method that returns a type String formatted as:

```
Grocery Item Name: <<Name>> Value: <<Value>>
```

- Where values denoted in “<<>>” are assumed to be the instance variable values.

- **equals:** This method takes in another instance of GroceryItem and only returns true if all of the instance variables match.

### Grocery List Class

- Write another class and name it exactly GroceryList.

#### Create an Internal class ListNode

##### Instance Variables

- **Data** of type GroceryItem, where its default value null.

- **Link** of type ListNode, where its default value is null.

##### Constructors

- **Default:** sets the instances variables to null.

- **Parameterized:** sets the instance variables to their respective parameters, and does not need to check for valid values.

#### Instance Variables (for GroceryList not ListNode)

- **Head:** a ListNode which always points to the beginning of the linked list

- **Current:** a ListNode which moves to point at different items in the list

- **Previous:** a ListNode which points to the item behind current.

#### Constructor (for GroceryList not ListNode)

- A default constructor that initializes head to an empty ListNode and sets current and previous to point at the head.

#### Methods (for GroceryList not ListNode)

- **gotoNext:** This moves the current node forward in the list by one node. It doesn’t move forward if that node is null

- **getCurrent:** returns the data at the current node as long as the current isn’t null.

- **setCurrent:** takes in a parameter of type GroceryItem and sets the data at the current node to that value as long as current is not null and the data provided is also not null.

- **addItem:** This method given a grocery item, creates a new list node with the data assigned to the provided grocery item and then adds the new list node to the end of the list. If the list is empty, then it starts the list. Also, if the grocery item is null then the method should do nothing.

- **addItemAfterCurrent:** creates a new node based on data that is passed in by a parameter and puts that node after the current position. If the list is empty or the data provided is null, then this method should do nothing.

- **removeCurrent:** removes the current node from the list by resetting the links.

- **showList:** prints out the contents of the list line-by-line.

- **contains:** returns a true or false value based on whether or not the data passed in via a parameter is in the list.

- **totalCost:** returns the sum of all of the groceries.

## Example Dialogue

```
Grocery List Tester.

-----------------------------------------------

Test 1

-----------------------------------------------

Reading the grocery list.

Grocery Item Name: Apples Value: 4.42
Grocery Item Name: Bananas Value: 1.51
Grocery Item Name: Strawberries Value: 2.51
Grocery Item Name: Bell Peppers Value: 0.98
Grocery Item Name: Carrots Value: 3.52
Grocery Item Name: Broccoli Value: 2.04
Grocery Item Name: Garlic Value: 6.12
Grocery Item Name: Lemons/Limes Value: 0.32
Grocery Item Name: Onion Value: 5.74
Grocery Item Name: Parsley Value: 2.16
Grocery Item Name: Cilantro Value: 3.11
Grocery Item Name: Basil Value: 6.98
Grocery Item Name: Potatoes Value: 5.32
Grocery Item Name: Spinach Value: 4.11
Grocery Item Name: Tomatoes Value: 7.38
Grocery Item Name: Butter Value: 5.51
Grocery Item Name: Sliced Cheese Value: 1.26
Grocery Item Name: Shredded Cheese Value: 3.63
Grocery Item Name: Milk Value: 4.67
Grocery Item Name: Sour Cream Value: 0.74
Grocery Item Name: Greek Yogurt Value: 7.21
Grocery Item Name: Breadcrumbs Value: 4.93
Grocery Item Name: Pasta Value: 1.49
Grocery Item Name: Quinoa Value: 4.78
Grocery Item Name: Rice Value: 6.96
Grocery Item Name: Sandwich Bread Value: 1.22
Grocery Item Name: Tortillas Value: 4.17

-----------------------------------------------

Test 2

-----------------------------------------------

Finding the total cost.
Total Cost: 102.78999999999998

-----------------------------------------------

Test 3

-----------------------------------------------

Checking Contains with item known to be in the list

Grocery Item Name: Potatoes Value: 5.32
Contains? true

Checking Contains with item known to NOT be in the list

Grocery Item Name: none Value: 0.0
Contains? false

-----------------------------------------------

Test 4

-----------------------------------------------

Accessing First Item in the list
Grocery Item Name: Apples Value: 4.42

Removing First Item in the list

Grocery Item Name: Bananas Value: 1.51
Grocery Item Name: Strawberries Value: 2.51
Grocery Item Name: Bell Peppers Value: 0.98
Grocery Item Name: Carrots Value: 3.52
Grocery Item Name: Broccoli Value: 2.04
Grocery Item Name: Garlic Value: 6.12
Grocery Item Name: Lemons/Limes Value: 0.32
Grocery Item Name: Onion Value: 5.74
Grocery Item Name: Parsley Value: 2.16
Grocery Item Name: Cilantro Value: 3.11
Grocery Item Name: Basil Value: 6.98
Grocery Item Name: Potatoes Value: 5.32
Grocery Item Name: Spinach Value: 4.11
Grocery Item Name: Tomatoes Value: 7.38
Grocery Item Name: Butter Value: 5.51
Grocery Item Name: Sliced Cheese Value: 1.26
Grocery Item Name: Shredded Cheese Value: 3.63
Grocery Item Name: Milk Value: 4.67
Grocery Item Name: Sour Cream Value: 0.74
Grocery Item Name: Greek Yogurt Value: 7.21
Grocery Item Name: Breadcrumbs Value: 4.93
Grocery Item Name: Pasta Value: 1.49
Grocery Item Name: Quinoa Value: 4.78
Grocery Item Name: Rice Value: 6.96
Grocery Item Name: Sandwich Bread Value: 1.22
Grocery Item Name: Tortillas Value: 4.17

Accessing Fourth Item in the list
Grocery Item Name: Carrots Value: 3.52

Removing Fourth Item in the list

Grocery Item Name: Bananas Value: 1.51
Grocery Item Name: Strawberries Value: 2.51
Grocery Item Name: Bell Peppers Value: 0.98
Grocery Item Name: Broccoli Value: 2.04
Grocery Item Name: Garlic Value: 6.12
Grocery Item Name: Lemons/Limes Value: 0.32
Grocery Item Name: Onion Value: 5.74
Grocery Item Name: Parsley Value: 2.16
Grocery Item Name: Cilantro Value: 3.11
Grocery Item Name: Basil Value: 6.98
Grocery Item Name: Potatoes Value: 5.32
Grocery Item Name: Spinach Value: 4.11
Grocery Item Name: Tomatoes Value: 7.38
Grocery Item Name: Butter Value: 5.51
Grocery Item Name: Sliced Cheese Value: 1.26
Grocery Item Name: Shredded Cheese Value: 3.63
Grocery Item Name: Milk Value: 4.67
Grocery Item Name: Sour Cream Value: 0.74
Grocery Item Name: Greek Yogurt Value: 7.21
Grocery Item Name: Breadcrumbs Value: 4.93
Grocery Item Name: Pasta Value: 1.49
Grocery Item Name: Quinoa Value: 4.78
Grocery Item Name: Rice Value: 6.96
Grocery Item Name: Sandwich Bread Value: 1.22
Grocery Item Name: Tortillas Value: 4.17
```
