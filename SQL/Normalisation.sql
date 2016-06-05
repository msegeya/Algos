Normalization Rules:
1NF
2NF
3NF
BCNF
----------------------------------------------------------------
1NF: No two rows should contain repeating information. 
Refer: 1NF-1.png and 1NF-2.png
----------------------------------------------------------------
2NF: First read the below points,
	Prime attribute − An attribute, which is a part of the prime-key, is known as a prime attribute.
	Non-prime attribute − An attribute, which is not a part of the prime-key, is said to be a non-prime attribute.
If we follow the 2NF then non-prime attributes should be fully functionally dependent on prim attributes
That is, if x -> A then there should not be any proper set where Y -> A. (That is no other attribute should define A other than the key.)

See 2NF-1.png, here Stu_ID and Proj_ID are the keys. But the non-prime attributes Stu_Name and Proj_Name are not depending on both the prime-keys. So there is a partial dependency here.
So to remove this partial dependency we will separate them. ==> See 2NF-2.png

Refer: 2NF-1.png and 2NF-2.png
----------------------------------------------------------------
3NF: 
	No non-prime attribute is transitively dependent on prime key attribute.
	For any non-trivial dependeny, X -> A, then either X is a super key or A is a prime.
 See 3NF-1.png where Stu_ID is the key but country can also be identified by Zip. So there is a trnasitive dependeny here. 
 After removing it see .. 3NF-2.png

 Refer: 3NF-1.png and 3NF-2.png
----------------------------------------------------------------
BCNF: (Boyce Code Normal Form)
	It is an extension of 3NF. 
	For any non-trivial functional dependeny, X -> A, X must be the super key.
Take a look at 3NF-2.png where STU_ID is the super key since STU_ID -> Stu_Name, Zip
							and Zip -> City
==> Both Stu_ID and Zip are the super-keys.
----------------------------------------------------------------
