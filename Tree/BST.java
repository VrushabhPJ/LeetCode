/* Valid Binary Search Tree

You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
// left subtree root max value <= root value < right subtree root min value
//left tree from min_value -> root.val , right tree from root.val +1 -> max-value
public class Solution {
    public int isValidBST(TreeNode A) {
        return valid(A, Long.MIN_VALUE, Long.MAX_VALUE) == true ?1:0;
    }

    public boolean valid(TreeNode A, long l, long r) {
        if(A == null) return true;

        if(A.val < l || A.val >= r) return false;

        boolean isLeft= valid(A.left, l, A.val);
        boolean isRight= valid(A.right , A.val +1, r);

        return (isLeft && isRight);
    }
}
