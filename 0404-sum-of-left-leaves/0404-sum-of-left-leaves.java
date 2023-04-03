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
     public int sum=0,maxlevel=0;
    public int sumOfLeftLeaves(TreeNode root) {
       
        sums(root);
        return sum;
    }
   
    public void sums(TreeNode root){
        if(root==null)return;
        if(root.left!=null){
            if(root.left.left==null && root.left.right==null){
                sum+=root.left.val;
            }else{
                sums(root.left);
            }
        }
            sums(root.right);
        
    }
}