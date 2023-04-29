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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> al=new ArrayList<>();
        
        if(root==null)return al;
        Stack<Integer> s=new Stack<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean flag=false;
        q.add(null);
        while(!q.isEmpty()){
            int n=q.size();
            ArrayList<Integer> child=new ArrayList<>();
            while(n-->0){
                TreeNode curr=q.remove();
                if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                   
                }else{
                   if(flag==true){
                       s.push(curr.val);
                   }else{
                      child.add(curr.val);
                   }
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }  
                }
                
               
            }
             if(flag==true){
                    while(!s.isEmpty()){
                      child.add(s.pop());
                    }
                    flag= false;
                }else{
                    flag=true;
                }
            al.add(child);
        }
        return al;
    }
}