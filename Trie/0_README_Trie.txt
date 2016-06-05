Trie: http://www.geeksforgeeks.org/data-structures/

Trie | (Insert and Search)
Trie.java

Trie | (Delete)
Trie.java

Longest prefix matching – A Trie based solution in Java
LongestPrefix.java

Print unique rows in a given boolean matrix
PrintUniqueRows.java

Auto complete using Trie
AutoComplete.java

************************************************************************************************************************
How to Implement Reverse DNS Look Up Cache? and How to Implement Forward DNS Look Up Cache?
DnsTrie.java

For both these question it is good to use Hashing.
For Reverse DNS, store IP as key and domain name as value. Order of retireval is O(1)
For Forward DNS, store domain name as key and IP address as value. Order of retireval is O(1)
See Hashing directory under Java for example.

But before starting to implement make sure you validate the IP address .. look at "CheckIPAddValidity.java" in String dir.

We can also do the same using Trie. One advantage we have using Trie is that we can save the space.
In trie we store only the values which are continous with a little change. But when we use Hasing space is a problem. Even if the last digit of the IP is different then we still have to save the whole string in a new bucket.

Also when we use Trie we can get the IP's which start with so and so address.
************************************************************************************************************************

Ternary Search (A space efficient approach of Trie)
TernarySearch.java


Given a string of words. Your task is to split the words in the given string.
TextToWords.java