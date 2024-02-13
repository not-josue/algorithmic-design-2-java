# Sorting Various Words by Various Properties

## Objective

Write a program that analyzes a collection of words and sorts them in ascending order by the number of vowels, consonants, and the length of the word.

## Requirements

### Do not use built-in array sorters

- Using any built-in or automatic sorting methods (such as Arrays.sort()) is not allowed.

### Setup the Project

- Use the driver file (WordSorterFrontEnd) and the text file (randomWords.txt)

- Create a class and name it, exactly, WordHelper.

- Do not modify the provided driver or text file.

### Write method sortByVowels.

- This static method returns a sorted String array, takes in an array of Strings via a parameter, and sorts them from smallest to largest by the number of vowels.

- In addition, this method must create a copy of the String array parameter, sort the copied array, and return the sorted copied array.

- A character’s case does not matter, and you may assume that all words only contain alphabet characters and no digits or special symbols.

### Write method sortByConsonants.

- This static method returns a sorted String array, takes in an array of Strings via a parameter, and sorts them from smallest to largest by the number of consonants.

- In addition, this method must create a copy of the String array parameter, sort the copied array, and return the sorted copied array.

- A character’s case does not matter, and you may assume that all words only contain alphabet characters and no digits or special symbols.

### Write method sortByLength.

- This static method returns a sorted String array, takes in an array of Strings via a parameter, and sorts them from smallest to largest by the number of letters.

- In addition, this method must create a copy of the String array parameter, sort the copied array, and return the sorted copied array.

- A character’s case does not matter, and you may assume that all words only contain alphabet characters and no digits or special symbols.

## Additional Notes

Arrays in Java are considered class/object types which means they are referenced by their memory addresses. Just like other class/object types, passing an Array via a parameter DOES NOT create a clone.

Each method mentions to first create a copy of the provided array, sort it, and then return the sorted copied array, and this is a very important detail to get the same example dialog as below.

If this step is left out, the solution will only appear to sort only by the length as the initial array was first sorted by vowels, then the SAME array was then sorted by consonants, then the SAME array was sorted by length, and finally the SAME array is printed three times.

We instead need to make copies so that we can retain the original while also having 3 additional version sorted in a variety of ways.

## Example Dialogue

```
The original word list

century
army
spit
twin
frog
guideline
impulse
distributor
hallway
appeal
fitness
pudding
mild
enter
kitchen
constitutional
die
condition
morsel
jealous
colorful
myth
belly
rugby
valid
shot
locate
preference
representative
chart
prince
think
threshold
health
sweater
volume
poison
lease
toast
diplomat
trait
cower
slime
handy
example
sanctuary
board
crash
large
attract
censorship
room
license
smoke
roll
taste
inflate
continuation
establish
fault
gown
dirty
width
qualify
reference
excitement
vegetable
wear
confusion
concept
willpower
snarl
develop
integration
pie
respectable
fast
limit
shaft
acceptance
insert
brown
death
effective
ticket
play
highway
lot
tablet
mother
pier
facility
match
animal
sport
laundry
negligence
white
vat
nuclear

The word list sorted by Vowels

spit
twin
frog
mild
myth
shot
chart
think
crash
roll
gown
width
snarl
fast
shaft
brown
lot
match
sport
vat
army
fitness
pudding
enter
kitchen
die
morsel
belly
rugby
valid
prince
threshold
health
toast
trait
cower
slime
handy
board
large
attract
room
smoke
taste
fault
dirty
wear
concept
pie
limit
insert
death
ticket
play
tablet
mother
pier
white
century
impulse
hallway
appeal
colorful
locate
sweater
volume
poison
lease
diplomat
example
censorship
license
inflate
establish
willpower
develop
highway
animal
laundry
nuclear
distributor
condition
jealous
preference
sanctuary
qualify
reference
excitement
vegetable
confusion
respectable
acceptance
effective
facility
negligence
guideline
integration
constitutional
representative
continuation

The word list sorted by Consonants

die
pie
army
lease
room
wear
play
lot
pier
vat
spit
twin
frog
appeal
mild
enter
jealous
myth
belly
rugby
valid
shot
locate
volume
poison
toast
trait
cower
slime
handy
board
large
smoke
roll
taste
fault
gown
dirty
qualify
fast
limit
death
animal
white
century
guideline
impulse
hallway
morsel
chart
prince
think
health
sweater
example
crash
license
inflate
width
snarl
develop
shaft
insert
brown
ticket
highway
tablet
mother
facility
match
sport
laundry
nuclear
fitness
pudding
kitchen
condition
colorful
diplomat
sanctuary
attract
reference
vegetable
confusion
concept
effective
preference
continuation
establish
excitement
willpower
integration
acceptance
negligence
distributor
threshold
censorship
respectable
constitutional
representative

The word list sorted by Length

die
pie
lot
vat
army
spit
twin
frog
mild
myth
shot
room
roll
gown
wear
fast
play
pier
enter
belly
rugby
valid
chart
think
lease
toast
trait
cower
slime
handy
board
crash
large
smoke
taste
fault
dirty
width
snarl
limit
shaft
brown
death
match
sport
white
appeal
morsel
locate
prince
health
volume
poison
insert
ticket
tablet
mother
animal
century
impulse
hallway
fitness
pudding
kitchen
jealous
sweater
example
attract
license
inflate
qualify
concept
develop
highway
laundry
nuclear
colorful
diplomat
facility
guideline
condition
threshold
sanctuary
establish
reference
vegetable
confusion
willpower
effective
preference
censorship
excitement
acceptance
negligence
distributor
integration
respectable
continuation
constitutional
representative
```
