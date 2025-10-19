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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();

        ArrayDeque<TreeNode> q= new ArrayDeque<>();
        q.add(root);
        List<Integer> r = new ArrayList<>();

        while(q.size() >0){
            int level_size = q.size();
            for( int i=0; i<level_size; i++){
                TreeNode node = q.poll();
                if(i == level_size - 1)r.add(node.val);
                if(node.left!=null)q.add(node.left);                   
                if(node.right!=null)q.add(node.right);
            }
        }
        return r;
    }
}