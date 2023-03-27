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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> al=new ArrayList<>();
        traverse(root,al);
        return al;
    }
    public void traverse(TreeNode root,ArrayList<Integer> al){
         if(root==null){
            return ;
        }
        al.add(root.val);
        traverse(root.left,al);
        traverse(root.right,al);
    }
}