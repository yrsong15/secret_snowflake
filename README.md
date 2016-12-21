# Secret Snowflake :snowflake: :snowflake: :snowflake:

This program creates a Secret Snowflake matching (it's like Secret Santa, but not everyone celebrates Christmas :christmas_tree: :santa:).

It was motivated by my own experiences as a Resident Assistant, when I had to run a hacky process using an Excel spreadsheet with randomly generated values and awkward sort-by-value of multiple columns just to match my residents with one another - a tedious process which still didn't return the right result because one of my residents was matched with himself.

### Requirements

This program accepts as a parameter a text file (or more specifically, the title of that text file) which contains a list of entries, with each entry containing a person's name, as well as a *category* value - for example, male/female, first floor/second floor etc. 
+ The name and the category value must be separated by whitespace (multiple spaces are perfectly fine).
+ Each entry must be separated by a newline character.

#####Example List
+ Foo Female
+ Bar Male
+ IronMan Male
+ Dory Female

### Compile & Running

+ Note that *test.txt* in the command below should be replaced with the actual file name.

```
<move to source directory; ex: cd workspace/secret_snowflake/src>
javac Main.java
java Main test.txt
```