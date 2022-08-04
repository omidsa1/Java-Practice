Problem Definition:

Given an list of strings:
First, create a map from a integer to a list of strings having that integer as their character count
Then, create a nested map from number of strings with each character count (length of previous step's list)
to a list of strings with that character count (the map from previous step). 

It is guaranteed that the no set of two string lists with different length and same number of members would be 
present in the input list.

Input: {"a" , "bb", "cc", "dd", "eeee", "ffff", "gggg", "hhhh"}

Output: {1={1=[a]}, 3={2=[bb, cc, dd]}, 4={4=[eeee, ffff, gggg, hhhh]}}
