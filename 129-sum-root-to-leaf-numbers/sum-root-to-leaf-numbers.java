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
    private int ts=0;
    public void preorder(TreeNode r , int cn){
        if(r!=null){
            cn = cn * 10 + r.val;
            if(r.left == null && r.right == null){
                ts+=cn;
            }
            preorder(r.left,cn);
            preorder(r.right,cn);
        }
    }
    public int sumNumbers(TreeNode root) {
        preorder(root,0);
        return ts;
    }
}