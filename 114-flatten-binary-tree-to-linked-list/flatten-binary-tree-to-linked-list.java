class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        helper(root);
    }

    private void helper(TreeNode node) {
        if (node == null) return;

        helper(node.right);
        helper(node.left);
        
        node.right = prev; // previous node becomes the right child
        node.left = null;  // left child should be null in flattened list
        
        prev = node;
    }
}