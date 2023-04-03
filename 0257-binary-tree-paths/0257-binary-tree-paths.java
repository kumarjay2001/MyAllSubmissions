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
    ArrayList<String> al=new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
      String ans="";
      bins(root,ans);
        return al;
    }
    public void bins(TreeNode root,String ans){
        if(root==null){
            return;
        }
        ans+=root.val;
        if(root.left==null && root.right==null){
            al.add(ans);
            return;
        }
        ans+="->";
        bins(root.left,ans);
        bins(root.right,ans);
    }
}