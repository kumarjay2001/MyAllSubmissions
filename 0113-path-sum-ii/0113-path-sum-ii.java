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
    List<List<Integer>> al=new ArrayList<>();
    List<Integer> subal=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        checks(root,targetSum);
        return al;
        
    }
    public void checks(TreeNode root,int targetSum){
        if(root==null){
            return;
        }
        subal.add(root.val);
        if(root.val==targetSum && root.left==null && root.right==null){
            al.add(new ArrayList<Integer>(subal));
            // return;
        }else{
             checks(root.left,targetSum-root.val);
             checks(root.right,targetSum-root.val);
        }
            subal.remove(subal.size()-1); 

       
    }
}