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
    TreeSet<Integer> s=new TreeSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        inorder(root);
        if(s.size()==1){
            return -1;
        }
        s.pollFirst();
        return s.pollFirst();
       
    }
    public void inorder(TreeNode root){
        if(root==null)return ;
        s.add(root.val);
        inorder(root.left);
        inorder(root.right);
    }
    
}