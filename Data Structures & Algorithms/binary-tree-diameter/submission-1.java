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
        int res[]=new int[1];
        height(root,res);
        return res[0];       
    }

    public int height(TreeNode root,int[] res){
        if(root==null){
            return 0;
        }
        int leftH = height(root.left,res);
        int rightH = height(root.right,res);
        res[0] = Math.max(res[0], (leftH+rightH));
        return 1 + (Math.max(leftH,rightH));
    }
}

//PostOrder
//n //h
