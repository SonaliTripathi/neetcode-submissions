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
    
    public int diameterOfBinaryTree(TreeNode root) {
       int res[]= new int[1];
       height(root,res);
       return res[0];
        
    }

    public int height(TreeNode root, int res[]){
        if(root==null){
            return 0;
        }
        int leftHeight= height(root.left,res);
        int rightHeight = height(root.right,res);
        int diameter = leftHeight+rightHeight;
        res[0] = Math.max(res[0],diameter);

        return 1+ Math.max(leftHeight,rightHeight);


    }
   
}
