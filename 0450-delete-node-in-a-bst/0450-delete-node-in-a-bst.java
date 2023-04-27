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
        if(root==null)return null;
        if(root.val>key){
            root.left= deleteNode(root.left,key);
        }else if(root.val<key){
            root.right= deleteNode(root.right,key);    
        }
        else{
     
//         Case1.. leaf  node
        if(root.left==null && root.right==null){
            return null;
        }
//         Case 2: Having 1 children...
        if(root.left==null){
            return root.right;
        }else if(root.right==null){
            return root.left;
        }
//         Case3. having 2 children..
        int is=insuc(root.right);
        root.val=is;
        root.right=deleteNode(root.right,is);
        
        }
        return root;
    }
    public int insuc(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root.val;
    }
}