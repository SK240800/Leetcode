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

    private int hf(TreeNode root, int sum){

        if(root == null) return 0;
        if(root!= null){
            sum+=1;
        }
        int lc = hf(root.left,0);
        int rc = hf(root.right,0);

        sum+=lc+rc;

        return sum;

    }
    public int countNodes(TreeNode root) {

        if(root == null) return 0;
        int c = hf(root,0);

        return c;
        
    }
}