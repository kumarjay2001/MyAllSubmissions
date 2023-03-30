/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val ||root.val==q.val ){
            return root;
        }
        TreeNode lefti=lowestCommonAncestor(root.left,p,q);
        TreeNode righti=lowestCommonAncestor(root.right,p,q);
        
        if(lefti==null){
            return righti;
        }
        if(righti==null){
            return lefti;
        }
        return root;
    }
}