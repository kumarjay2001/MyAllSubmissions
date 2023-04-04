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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> al=new ArrayList<>();
        if(root==null)return al;
       
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> subal=new ArrayList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr=q.remove();
            if(curr==null){
                al.add(subal);
                subal=new ArrayList<>();
                if(q.isEmpty()){
                break;
               }
                q.add(null);
                
            }else{
               subal.add(curr.val);
               if(curr.left!=null){
                q.add(curr.left);
               }  
               if(curr.right!=null){
                q.add(curr.right);
               }
            }
            
           
        }
        Collections.reverse(al);
        return al;
    }
}