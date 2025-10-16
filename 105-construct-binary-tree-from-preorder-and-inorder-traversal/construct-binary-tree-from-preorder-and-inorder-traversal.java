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
    public TreeNode hf(int[] pro, int[] ino, int prS, int prE, int inS, int inE){
        if(inS>inE || prS>prE)return null;

        TreeNode root = new TreeNode(pro[prS]);

        int rootIndexInInorder = -1;

        for (int i = inS; i <= inE; i++){
            if(ino[i] == pro[prS]){
                rootIndexInInorder = i;
            }
        }
        int lprS= prS+1;
        int rinS= rootIndexInInorder +1;
        int linE= rootIndexInInorder -1;
        int linS= inS;
        int lprE= lprS +(linE-linS);
        int rprE= prE;
        int rprS= lprE + 1;
        int rinE= inE;
        root.left = hf(pro,ino,lprS,lprE,linS,linE);
        root.right = hf(pro,ino,rprS,rprE,rinS,rinE);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root= hf(preorder,inorder,0,n-1,0,n-1);
        return root;
    }
}