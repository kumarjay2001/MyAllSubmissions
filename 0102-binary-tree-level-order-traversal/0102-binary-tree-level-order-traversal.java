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
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> al=new ArrayList<>();
        if(root==null){
            return al;
        }
       Queue<TreeNode> q=new LinkedList<>();
        q.add(root);q.add(null);
        while(!q.isEmpty()){
            ArrayList<Integer> child=new ArrayList<>();
            int n=q.size();
            while(n-->0){
                TreeNode curr=q.remove();
                if(curr==null){
                    if(q.isEmpty())break;
                    else{
                        // al.add(child);
                        q.add(null);
                    }
                }else{
                    child.add(curr.val);
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }
            }
            al.add(child);
        }
        return al;
    }
    
}