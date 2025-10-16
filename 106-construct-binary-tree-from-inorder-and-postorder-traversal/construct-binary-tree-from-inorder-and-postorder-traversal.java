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
    public TreeNode hf(int[] ino, int[] pos,int inS,int inE,int poS,int poE){
        if(inS>inE || poS>poE) return null;

        TreeNode root = new TreeNode(pos[poE]);

        int index = -1;
        for(int i = inS; i<=inE; i++){
            if(ino[i]==pos[poE]){
                index = i;
                break;
            }
        }


        int leftTreeSize = index - inS;
        int rightTreeSize = inE - index;

        int linS=inS;
        int linE=index-1;
        int rinS=index+1;
        int rinE=inE;

        int lposS=poS;
        int lposE=poS + leftTreeSize - 1;
        int rposS=poS + leftTreeSize;
        int rposE=poE-1;

        root.left = hf(ino,pos,linS,linE,lposS,lposE);
        root.right= hf(ino,pos,rinS,rinE,rposS,rposE);

        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int n = inorder.length;

        TreeNode root = hf(inorder, postorder,0,n-1,0,n-1);

        return root;
        
    }
}