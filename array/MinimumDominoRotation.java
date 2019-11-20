1007. Minimum Domino Rotations For Equal Row
Medium

#1

Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

#2

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.

Solution 1:
Count the occurrence of all numbers in A and B,
and also the number of domino with two same numbers.

Try all possibilities from 1 to 6.
If we can make number i in a whole row,
it should satisfy that countA[i] + countB[i] - same[i] = n

Take example of
A = [2,1,2,4,2,2]
B = [5,2,6,2,3,2]

countA[2] = 4, as A[0] = A[2] = A[4] = A[5] = 2
countB[2] = 3, as B[1] = B[3] = B[5] = 2
same[2] = 1, as A[5] = B[5] = 2

We have countA[2] + countB[2] - same[2] = 6,
so we can make 2 in a whole row.

Time O(N), Space O(1)


class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if(A == null || B == null || A.length == 0 || B.length == 0){
            return -1;
        }
        if (A.length != B.length) {
           return -1; 
        }
        
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] same = new int[7];
        int length = A.length;

        for (int i = 0; i < length ; i++) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i]) {
                same[A[i]]++;
            }
        }

        for (int i = 1; i < 7; i++) {
            if (countA[i] + countB[i] - same[i] == length) {
               return length - Math.max(countA[i],countB[i]); 
            }
        }
        return -1;
        
    }
}