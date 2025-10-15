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

    public int hf(TreeNode root){
        if (root == null) return 0;
        int ld = 0, rd =0;
        ld += hf(root.left);
        rd += hf(root.right);
        return Math.max(ld,rd)+1;
    }
    public int maxDepth(TreeNode root) {

        return hf(root);
        
    }
}