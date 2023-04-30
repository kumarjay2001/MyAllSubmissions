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
    public class Info{
        int ht;
        int diam;
        Info(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return di(root).diam-1;
    }
    public Info di(TreeNode root){
        if(root==null)return new Info(0,0);
        Info lh=di(root.left);
        Info rh=di(root.right);
        int ht=Math.max(lh.ht,rh.ht)+1;
        int diam=Math.max(lh.diam,Math.max(rh.diam,lh.ht+rh.ht+1));
        return new Info(ht,diam);
        
    }
    
}