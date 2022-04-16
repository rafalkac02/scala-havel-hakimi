# The Havel-Hakimi algorithm for graph realization

It was a dark and stormy night. Detective Havel and Detective Hakimi arrived at the scene of the crime.

Other than the detectives, there were 10 people present. They asked the first person, "out of the 9 other people here, how many had you already met before tonight?" The person answered "5". They asked the same question of the second person, who answered "3". And so on. The 10 answers they got from the 10 people were:

```
5 3 0 2 6 2 0 7 2 5
```

The detectives looked at the answers carefully and deduced that there was an inconsistency, and that somebody must be lying. (For the purpose of this challenge, assume that nobody makes mistakes or forgets, and if X has met Y, that means Y has also met X.)

Your challenge for today is, given a sequence of answers to the question "how many of the others had you met before tonight?", apply the Havel-Hakimi algorithm to determine whether or not it's possible that everyone was telling the truth.


The algorithm is as follows:
1. Remove all 0's from the sequence.
2. If the sequence is now empty (no elements left), stop and return true.
3. Sort the sequence in descending order.
4. Remove the first answer (which is also the largest answer, or tied for the largest) from the sequence and call it N. The sequence is now 1 shorter than it was after the previous step. 
5. If N is greater than the length of this new sequence, stop and return false. 
6. Subtract 1 from each of the first N elements of the new sequence. 
7. Continue from step 1 using the sequence from the previous step.

---
Credits: [Reddit Post](https://www.reddit.com/r/dailyprogrammer/comments/bqy1cf/20190520_challenge_378_easy_the_havelhakimi/)