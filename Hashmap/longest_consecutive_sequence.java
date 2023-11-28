/*

Given an unsorted integer array A of size N.
Find the length of the longest set of consecutive elements from array A.

Input Format :-
First argument is an integer array A of size N.

Output Format :-
Return an integer denoting the length of the
longest set of consecutive elements from the array A.

*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {
        int N= A.length;
        int cnt= 0;

        HashSet<Integer> set= new HashSet<>();

        for(int i= 0; i< N; i++){   //add all A[i] value in hashset
            set.add(A[i]);
        }

        for(int i= 0; i< N; i++)
        {
            int num= A[i];
            int count= 0;
            if(! set.contains(num - 1) ){   //check A[i] previous value if not present then start counting

                while(set.contains(num + count)){   //check all continous number from 'num' till it break.
                    count++;
                    //num++;
                }
                cnt = Math.max(cnt, count);
            }
        }
        return cnt;
    }
}