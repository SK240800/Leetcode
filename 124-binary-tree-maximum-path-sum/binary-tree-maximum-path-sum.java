/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainfromsubtree(root);
        return maxSum;
        
    }

    private int gainfromsubtree(TreeNode root){
        if(root == null) return 0;

        int gainfromleft = Math.max(gainfromsubtree(root.left),0);
        int gainfromright = Math.max(gainfromsubtree(root.right),0);

        maxSum = Math.max(maxSum,gainfromleft+gainfromright+root.val);

        return Math.max(gainfromleft+ root.val, gainfromright+root.val);

    }
}