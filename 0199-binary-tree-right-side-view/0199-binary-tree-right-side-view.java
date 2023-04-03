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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> al=new ArrayList<>();
        righti(al,root,1);
        return al;
    }
    public int maxlevel=0;
    public void righti(ArrayList<Integer> al,TreeNode root,int level){
        if(root==null)return;
        if(maxlevel<level){
            al.add(root.val);
            maxlevel=level;
        }
       
        righti(al,root.right,level+1);
         righti(al,root.left,level+1);
    }
}