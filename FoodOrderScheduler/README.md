# Food Order Scheduler

## Objective

During a busy lunch, a chef must cook orders while minimizing the average waiting time per customer. Unfortunately the chef only can cook the orders one at a time. Using a min-heap, schedule food orders based on their shortest cooking times in order to get the best average waiting times.

## Requirements

### Project Setup

- Use the given driver file (OrderSchedulerSimulator.java) which contains the main method

- Do NOT alter the driver file

### Order class

- Implements Type Comparable

#### Instance Variables

- **Customer**: A non-null String representing the name of the customer. Default value is “none”.

- **Food Order:** A non-null String representing the name of the food the customer has ordered. Default value is “none”.

- **Cooking Time:** A positive whole number which represents the number of minutes it takes to cook the order. Default value is 1.

- **Arrival Time:** A positive whole number which represents when (in minutes) the order was placed. Default value is 0.

- **Cooking Time Left:** A positive whole number which represents the amount of time left to cook the food in minutes. This value is always initially set to be the same as Cooking Time.

#### Constructors

- **Default:** Must set all properties to their default values mentioned in the “Instance Variables” section.

- **Parameterized:** Must take in a parameter for each instance variable in the order named above. This means the first instance variable is the first parameter, the second instance variable is the second parameter, and so on; EXCEPT for Cooking Time Left. This must set the instance variable values only if the given values are valid, but otherwise it must set the instance variables to their default values.

#### Methods

- Accessors for the instance variables.

- Mutators for the instance variables.

  - Make sure in the mutators check for valid values named in the “Instance Variables” Section.

- **toString:** This method returns a String with some of the instance variable values concatenated together with the format:
  - Where values in “<<>>” correspond to variable values.

```
Customer: <<customer’s name>>, Order: <<order’s name>>, Cooking Time Left: <<cooking time left>>
```

- **compareTo:** returns an integer value based on the Cooking Time. Shorter times have a higher priority than longer times.

- **cookForOneMinute:** This method subtracts one from the Cooking Time Left. Also it takes in no values and returns no values.

- **isDone:** This method returns true or false based on if the Cooking Time Left is equal to 0.

- **toString:** This method returns a string value containing the Customer’s name, their order, and the cooking time left.

### MinHeap class

- A generic implementation of an Array-Based, Minimum Heap

#### Methods

- **add:** Takes in a new element via a parameter and adds it to the heap

- **remove:** Removes and returns the first element in the heap.

### OrderScheduler class

#### Instance Variables

- **Orders:** a MinHeap of type Order representing the orders waiting to be cooked.

- **Current Order:** The current order that is being cooked. This value is separate from the heap.

- **Current Minute:** The current simulated minute, which by default is 0.

- **Total Orders:** A running total of the number of orders that has been added. Default value is 0.

- **Summed Waiting Times:** The total summed waiting times for each order. Default value is 0.

#### Methods

- **addOrder:** This method takes in an instance of an order, and if the current order is null then the newly added order is assigned to it. Otherwise, it adds the new order to the heap of orders. In either case the total orders is increased by one.

- **advanceOneMinute:** This method adds one to the current minute counter, and then cooks the current order for one minute. If the order is now done, then calculate its waiting time by taking the difference from the current minute and the current order’s arrival time. This value should be added to the summed waiting times. Next replace the current order with the order on top of the heap.

- **isDone:** This method returns true or false based on if the current order is null

- **getAverageWaitingTime:** This returns a decimal value corresponding to the division of the summed waiting times by the total orders.

## Example Dialogue

```java
-------------------------------------------

Starting Order Scheduler Simulation

-------------------------------------------

-------------------------------------------Minute 0-------------------------------------------

ORDER ADDED: Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 20

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 20

-------------------------------------------Minute 1-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 19

-------------------------------------------Minute 2-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 18

-------------------------------------------Minute 3-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 17

-------------------------------------------Minute 4-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 16

-------------------------------------------Minute 5-------------------------------------------

ORDER ADDED: Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 15

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 15

-------------------------------------------Minute 6-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 14

-------------------------------------------Minute 7-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 13

-------------------------------------------Minute 8-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 12

-------------------------------------------Minute 9-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 11

-------------------------------------------Minute 10-------------------------------------------

ORDER ADDED: Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 19

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 10

-------------------------------------------Minute 11-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 9

-------------------------------------------Minute 12-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 8

-------------------------------------------Minute 13-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 7

-------------------------------------------Minute 14-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 6

-------------------------------------------Minute 15-------------------------------------------

ORDER ADDED: Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 13

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 5

-------------------------------------------Minute 16-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 4

-------------------------------------------Minute 17-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 3

-------------------------------------------Minute 18-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 2

-------------------------------------------Minute 19-------------------------------------------

Currently Cooking Order:

Customer: Alicja Ulderico, Order: Raisin and strawberry yoghurt, Cooking Time Left: 1

-------------------------------------------Minute 20-------------------------------------------

ORDER ADDED: Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 16

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 13

-------------------------------------------Minute 21-------------------------------------------

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 12

-------------------------------------------Minute 22-------------------------------------------

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 11

-------------------------------------------Minute 23-------------------------------------------

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 10

-------------------------------------------Minute 24-------------------------------------------

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 9

-------------------------------------------Minute 25-------------------------------------------

ORDER ADDED: Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 11

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 8

-------------------------------------------Minute 26-------------------------------------------

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 7

-------------------------------------------Minute 27-------------------------------------------

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 6

-------------------------------------------Minute 28-------------------------------------------

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 5

-------------------------------------------Minute 29-------------------------------------------

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 4

-------------------------------------------Minute 30-------------------------------------------

ORDER ADDED: Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 21

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 3

-------------------------------------------Minute 31-------------------------------------------

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 2

-------------------------------------------Minute 32-------------------------------------------

Currently Cooking Order:

Customer: Frauke George, Order: Cuttlefish with rice, Cooking Time Left: 1

-------------------------------------------Minute 33-------------------------------------------

Currently Cooking Order:

Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 11

-------------------------------------------Minute 34-------------------------------------------

Currently Cooking Order:

Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 10

-------------------------------------------Minute 35-------------------------------------------

ORDER ADDED: Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 13

Currently Cooking Order:

Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 9

-------------------------------------------Minute 36-------------------------------------------

Currently Cooking Order:

Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 8

-------------------------------------------Minute 37-------------------------------------------

Currently Cooking Order:

Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 7

-------------------------------------------Minute 38-------------------------------------------

Currently Cooking Order:

Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 6

-------------------------------------------Minute 39-------------------------------------------

Currently Cooking Order:

Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 5

-------------------------------------------Minute 40-------------------------------------------

ORDER ADDED: Customer: Imtiyaz Umar, Order: Spaghetti squash, Cooking Time Left: 8

Currently Cooking Order:

Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 4

-------------------------------------------Minute 41-------------------------------------------

Currently Cooking Order:

Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 3

-------------------------------------------Minute 42-------------------------------------------

Currently Cooking Order:

Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 2

-------------------------------------------Minute 43-------------------------------------------

Currently Cooking Order:

Customer: Onesiphoros Davorka, Order: Mulberry and broccoli salad, Cooking Time Left: 1

-------------------------------------------Minute 44-------------------------------------------

Currently Cooking Order:

Customer: Imtiyaz Umar, Order: Spaghetti squash, Cooking Time Left: 8

-------------------------------------------Minute 45-------------------------------------------

ORDER ADDED: Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 18

Currently Cooking Order:

Customer: Imtiyaz Umar, Order: Spaghetti squash, Cooking Time Left: 7

-------------------------------------------Minute 46-------------------------------------------

Currently Cooking Order:

Customer: Imtiyaz Umar, Order: Spaghetti squash, Cooking Time Left: 6

-------------------------------------------Minute 47-------------------------------------------

Currently Cooking Order:

Customer: Imtiyaz Umar, Order: Spaghetti squash, Cooking Time Left: 5

-------------------------------------------Minute 48-------------------------------------------

Currently Cooking Order:

Customer: Imtiyaz Umar, Order: Spaghetti squash, Cooking Time Left: 4

-------------------------------------------Minute 49-------------------------------------------

Currently Cooking Order:

Customer: Imtiyaz Umar, Order: Spaghetti squash, Cooking Time Left: 3

-------------------------------------------Minute 50-------------------------------------------

Currently Cooking Order:

Customer: Imtiyaz Umar, Order: Spaghetti squash, Cooking Time Left: 2

-------------------------------------------Minute 51-------------------------------------------

Currently Cooking Order:

Customer: Imtiyaz Umar, Order: Spaghetti squash, Cooking Time Left: 1

-------------------------------------------Minute 52-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 13

-------------------------------------------Minute 53-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 12

-------------------------------------------Minute 54-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 11

-------------------------------------------Minute 55-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 10

-------------------------------------------Minute 56-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 9

-------------------------------------------Minute 57-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 8

-------------------------------------------Minute 58-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 7

-------------------------------------------Minute 59-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 6

-------------------------------------------Minute 60-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 5

-------------------------------------------Minute 61-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 4

-------------------------------------------Minute 62-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 3

-------------------------------------------Minute 63-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 2

-------------------------------------------Minute 64-------------------------------------------

Currently Cooking Order:

Customer: Nirmala Erna, Order: Chestnut and chorizo soup, Cooking Time Left: 1

-------------------------------------------Minute 65-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 15

-------------------------------------------Minute 66-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 14

-------------------------------------------Minute 67-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 13

-------------------------------------------Minute 68-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 12

-------------------------------------------Minute 69-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 11

-------------------------------------------Minute 70-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 10

-------------------------------------------Minute 71-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 9

-------------------------------------------Minute 72-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 8

-------------------------------------------Minute 73-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 7

-------------------------------------------Minute 74-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 6

-------------------------------------------Minute 75-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 5

-------------------------------------------Minute 76-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 4

-------------------------------------------Minute 77-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 3

-------------------------------------------Minute 78-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 2

-------------------------------------------Minute 79-------------------------------------------

Currently Cooking Order:

Customer: Philomel Olivette, Order: Roquefort salad, Cooking Time Left: 1

-------------------------------------------Minute 80-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 16

-------------------------------------------Minute 81-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 15

-------------------------------------------Minute 82-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 14

-------------------------------------------Minute 83-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 13

-------------------------------------------Minute 84-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 12

-------------------------------------------Minute 85-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 11

-------------------------------------------Minute 86-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 10

-------------------------------------------Minute 87-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 9

-------------------------------------------Minute 88-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 8

-------------------------------------------Minute 89-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 7

-------------------------------------------Minute 90-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 6

-------------------------------------------Minute 91-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 5

-------------------------------------------Minute 92-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 4

-------------------------------------------Minute 93-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 3

-------------------------------------------Minute 94-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 2

-------------------------------------------Minute 95-------------------------------------------

Currently Cooking Order:

Customer: Goodwin Kendra, Order: Sausage with berry salad, Cooking Time Left: 1

-------------------------------------------Minute 96-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 18

-------------------------------------------Minute 97-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 17

-------------------------------------------Minute 98-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 16

-------------------------------------------Minute 99-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 15

-------------------------------------------Minute 100-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 14

-------------------------------------------Minute 101-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 13

-------------------------------------------Minute 102-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 12

-------------------------------------------Minute 103-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 11

-------------------------------------------Minute 104-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 10

-------------------------------------------Minute 105-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 9

-------------------------------------------Minute 106-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 8

-------------------------------------------Minute 107-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 7

-------------------------------------------Minute 108-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 6

-------------------------------------------Minute 109-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 5

-------------------------------------------Minute 110-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 4

-------------------------------------------Minute 111-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 3

-------------------------------------------Minute 112-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 2

-------------------------------------------Minute 113-------------------------------------------

Currently Cooking Order:

Customer: Marita Adel, Order: Cheddar and ham sandwich, Cooking Time Left: 1

-------------------------------------------Minute 114-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 19

-------------------------------------------Minute 115-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 18

-------------------------------------------Minute 116-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 17

-------------------------------------------Minute 117-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 16

-------------------------------------------Minute 118-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 15

-------------------------------------------Minute 119-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 14

-------------------------------------------Minute 120-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 13

-------------------------------------------Minute 121-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 12

-------------------------------------------Minute 122-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 11

-------------------------------------------Minute 123-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 10

-------------------------------------------Minute 124-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 9

-------------------------------------------Minute 125-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 8

-------------------------------------------Minute 126-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 7

-------------------------------------------Minute 127-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 6

-------------------------------------------Minute 128-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 5

-------------------------------------------Minute 129-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 4

-------------------------------------------Minute 130-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 3

-------------------------------------------Minute 131-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 2

-------------------------------------------Minute 132-------------------------------------------

Currently Cooking Order:

Customer: Ines Marleen, Order: Mussels, Cooking Time Left: 1

-------------------------------------------Minute 133-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 21

-------------------------------------------Minute 134-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 20

-------------------------------------------Minute 135-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 19

-------------------------------------------Minute 136-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 18

-------------------------------------------Minute 137-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 17

-------------------------------------------Minute 138-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 16

-------------------------------------------Minute 139-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 15

-------------------------------------------Minute 140-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 14

-------------------------------------------Minute 141-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 13

-------------------------------------------Minute 142-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 12

-------------------------------------------Minute 143-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 11

-------------------------------------------Minute 144-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 10

-------------------------------------------Minute 145-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 9

-------------------------------------------Minute 146-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 8

-------------------------------------------Minute 147-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 7

-------------------------------------------Minute 148-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 6

-------------------------------------------Minute 149-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 5

-------------------------------------------Minute 150-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 4

-------------------------------------------Minute 151-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 3

-------------------------------------------Minute 152-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 2

-------------------------------------------Minute 153-------------------------------------------

Currently Cooking Order:

Customer: Albin Bao, Order: Feta and apricot salad, Cooking Time Left: 1

-------------------------------------------Minute 154-------------------------------------------

ALL ORDERS COMPLETE

The average Waiting Time is: 56.6 minutes
```
