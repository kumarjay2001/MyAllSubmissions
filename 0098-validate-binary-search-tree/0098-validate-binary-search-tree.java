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
        
        return checkme(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean checkme(TreeNode root,long min,long max){
        if(root==null)return true;
        if(root.val<=min){
            return false;
        } 
        if( root.val>=max){
            return false;
        }
        return (checkme(root.left,min,root.val) && checkme(root.right,root.val,max));
    }
}