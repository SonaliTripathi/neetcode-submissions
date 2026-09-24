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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(key<root.val){
            root.left = deleteNode(root.left,key);
        }
        else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }
        else{
            //No left child - return right child as it is
            if(root.left==null){
                return root.right;
            }
            //No right child - return left child as it is
            if(root.right==null){
                return root.left;
            }
            //2 child - replace key with min of right sub tree, as 
            //in inorder traversal min of right sub tree comes next of key
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right,successor.val);
        }
        return root;
        
    }
    public TreeNode findMin(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}
//both time and space-
//balanced tree = logn
//skewed tree = n

