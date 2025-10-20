class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currLevel = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;
        while(!q.isEmpty()){
            
            int size = q.size(); // number of nodes at this level
            currLevel = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();

                 // Insert based on direction
                if(leftToRight){
                    currLevel.add(curr.val);
                }else{
                    currLevel.add(0, curr.val); // adds at front
                }

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            ans.add(currLevel);
            leftToRight = !leftToRight; // flip direction
        }
        return ans;
    }
}