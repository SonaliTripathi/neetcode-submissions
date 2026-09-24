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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        for(int i=1;i<list.size();i++){
            if(!(list.get(i)>list.get(i-1))){
                return false;
            }
            
        }
        return true;
    }
    public List<Integer> dfs(TreeNode node, List<Integer> list){
        if(node==null){
            return list;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);

        return list;
    }
}

//Inorder Traversal
