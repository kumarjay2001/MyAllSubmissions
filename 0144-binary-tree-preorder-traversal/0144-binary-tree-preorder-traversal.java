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
        pres(root,al);
        return al;
    }
    public void pres(TreeNode root,ArrayList<Integer> al){
        if(root==null)return ;
        al.add(root.val);
        pres(root.left,al);
        pres(root.right,al);
    }
}