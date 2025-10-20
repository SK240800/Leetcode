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
    List<Integer> nodeValues = new ArrayList<>();

    void dfs(TreeNode node){
        if(node==null){
            return;
        }

        nodeValues.add(node.val);
        dfs(node.left);
        dfs(node.right);

    }
    public int getMinimumDifference(TreeNode root) {

        dfs(root);

        Collections.sort(nodeValues);
        int m = Integer.MAX_VALUE;

        for(int i = 1; i<nodeValues.size(); i++){
            m = Math.min(m,nodeValues.get(i)-nodeValues.get(i-1));
        }

        return m;
        
    }
}