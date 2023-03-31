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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> al=new ArrayList<>();
        inorder(root,al);
        
        int low=0,high=al.size()-1;
        
        while(low<high){
            if(al.get(low)+al.get(high)==k){
                return true;
            }else if(al.get(low)+al.get(high)>k){
                high--;
            }else{
                low++;
            }
        }
        return false;
        
    }
    public void inorder(TreeNode root,ArrayList<Integer>al){
        if(root==null)return;
        inorder(root.left,al);
        al.add(root.val);
        inorder(root.right,al);
        
    }
}