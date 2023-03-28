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
        if(root==null)return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        int ldi=diameterOfBinaryTree(root.left);
        int rdi=diameterOfBinaryTree(root.right);
        int orgiheight=lh+rh;
        return Math.max(Math.max(ldi,rdi),orgiheight);
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        return (Math.max(height(root.left),height(root.right))+1);
    }
}