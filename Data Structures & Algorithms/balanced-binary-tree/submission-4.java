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
    public boolean isBalanced(TreeNode root) {
        if(balanced(root) == -1) return false;
        else return true;        
    }

    public int balanced(TreeNode root){
        if(root==null) return 0;

        int leftH = balanced(root.left);
        if(leftH == -1) return -1;

        int rightH = balanced(root.right);
        if(rightH == -1) return -1;

        if(Math.abs(leftH-rightH)>1) return -1;

        return 1 + Math.max(leftH,rightH);
    }
}
//n- no of nodes
//h - height of tree
