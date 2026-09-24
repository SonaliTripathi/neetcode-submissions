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
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res=0;
        height(root);
        return res;       
    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        res = Math.max(res, (leftH+rightH));
        return 1 + (Math.max(leftH,rightH));
    }
}

//PostOrder
//n //h
