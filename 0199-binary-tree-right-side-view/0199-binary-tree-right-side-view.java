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
        pri(root,al,1);
        return al;
    }
    public int maxlevel=0;
    public void pri(TreeNode root,ArrayList<Integer> al,int level){
        if(root==null){
            return;
        }
        if(maxlevel<level){
            al.add(root.val);
            maxlevel=level;
        }
        pri(root.right,al,level+1);
        pri(root.left,al,level+1);
    }
}