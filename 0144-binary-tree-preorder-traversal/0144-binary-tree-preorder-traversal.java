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
        Stack<TreeNode> s=new Stack<>();
        TreeNode curr=root;
      while(true){
          while(curr!=null){
            al.add(curr.val);
            
            s.push(curr);
            curr=curr.left;
        }
          if(s.isEmpty()){
              break;
          }
          curr=s.pop();
          curr=curr.right;
      }
        return al;
        
    }
}