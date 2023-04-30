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
    public List<Integer> inorderTraversal(TreeNode root) {
       ArrayList<Integer> al=new ArrayList<>();
        // if(root==null)return al;
        TreeNode curr=root;
        Stack<TreeNode> s=new Stack<>();
        while(true){
            while(curr!=null){
                s.push(curr);
                curr=curr.left;
                
            }
            if(s.isEmpty()){
               break; 
            }
            curr=s.pop();
            al.add(curr.val);
            curr=curr.right;
        }
        return al;
    }
}