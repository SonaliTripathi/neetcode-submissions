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

public class Codec {

    int idx;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfsSerialize(root, list);
        return String.join(",",list);
        
    }

    public void dfsSerialize(TreeNode root, List<String> list){
        if(root==null){
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        dfsSerialize(root.left,list);
        dfsSerialize(root.right,list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        idx=0;
        return dfsDeserialize(vals);
        
    }

    public TreeNode dfsDeserialize(String[] vals){
        if(vals[idx].equals("N")){
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[idx]));
        idx++;
        node.left = dfsDeserialize(vals);
        node.right = dfsDeserialize(vals);
        return node;
    }
}

//Preorder
//n //n
