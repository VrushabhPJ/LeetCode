package Array;/*

Q. Given a vector A of non-negative integers representing an elevation map where
the width of each bar is 1, compute how much water it is able to trap after raining.

Problem Constraints

1 <= |A| <= 100000

Example Input
A = [0, 1, 0, 2]

Example Output
1

Explanation 1:
1 unit is trapped on top of the 3rd element.

*/

public class Rain_Water_Trapped {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int n= A.length;
        int right_max= Integer.MIN_VALUE;
        int left_max= Integer.MIN_VALUE;

        //prefix sum array
        int[] pre_A= new int[n];

        for(int i= 0; i < n; i++){
            left_max= Math.max(left_max , A[i]);
            pre_A[i] = left_max;
        }

        //suffix sum array
        int[] suff_A= new int[n];

        for(int i= n-1; i >= 0; i--){
            right_max= Math.max(right_max , A[i]);
            suff_A[i] = right_max;
        }

        int ans= 0;

        for(int i= 0; i< n; i++)
        {
            int trap= Math.min(pre_A[i] , suff_A[i]) - A[i];

            ans += trap;

        }

        return ans;
    }
}