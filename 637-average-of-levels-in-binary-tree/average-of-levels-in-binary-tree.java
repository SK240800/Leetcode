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
    public List<Double> averageOfLevels(TreeNode root) {

        if(root == null) return new ArrayList<>();

        ArrayDeque<TreeNode> q= new ArrayDeque<>();
        q.add(root);
        List<Double> r = new ArrayList<>();

        while(q.size()>0){
            int s = q.size();
            double sum =0;
            for(int i = 0; i<s; i++){
                TreeNode p = q.poll();
                sum+=p.val;
                if(p.left!=null)q.add(p.left);
                if(p.right!=null)q.add(p.right);

            }
            r.add(sum/s);
        }
        return r;
        
    }
}