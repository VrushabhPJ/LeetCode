/*  Merge Intervals
Problem Description

You have a set of non-overlapping intervals. You are given a new interval [start, end],
 insert this new interval into the set of intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

0 <= |intervals| <= 10^5

Input Format:
First argument is the vector of intervals
second argument is the new interval to be merged

Output Format:
Return the vector of intervals after merging

Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .

Output 1:

[ [1, 5], [6, 9] ]

Explanation 1:

(2,5) does not completely merge the given intervals

*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


public class Merge_Intervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n= intervals.size();

        ArrayList<Interval> ans= new ArrayList<>();

        for(int i= 0; i< n; i++)
        {
            if(intervals.get(i).end < newInterval.start ){
                ans.add(intervals.get(i));
            }
            else if(intervals.get(i).start > newInterval.end ){
                ans.add(newInterval);
                int j= i;
                while(j < n){
                    ans.add(intervals.get(j));
                    j++;
                }
                return ans;
            }
            else{
                newInterval.start= Math.min(intervals.get(i).start , newInterval.start);
                newInterval.end= Math.max(intervals.get(i).end , newInterval.end);
            }
        }

        ans.add(newInterval);
        return ans;
    }
}
