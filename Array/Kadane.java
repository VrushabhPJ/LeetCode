/* Kadane algorithms
Find the maximum sum of contiguous non-empty
subarray within an array A of length N.

 A = [1, 2, 3, 4, -10]
  10

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10.

 */

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int N= A.length;

        int sum= 0;
        int maxsum= Integer.MIN_VALUE;

        //kadane's algorithm
        for(int i= 0; i < N; i++)
        {
            sum= sum + A[i];
            maxsum = Math.max(sum , maxsum);
            if(sum < 0){
                sum = 0;
            }

        }

        return maxsum;
    }
}