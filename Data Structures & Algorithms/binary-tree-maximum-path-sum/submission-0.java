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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
        
    }
    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        res = Math.max(res,node.val + left + right);
        int max = node.val + Math.max(left,right);
        return Math.max(max,0);
    }
}
