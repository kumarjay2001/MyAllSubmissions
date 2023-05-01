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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> al=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        TreeNode curr=root;
        TreeNode temp=null;
        while(curr!=null || !s.isEmpty()){
            if(curr!=null){
                s.push(curr);
                curr=curr.left;
            }else{
                temp=s.peek().right;
                if(temp==null){
                    temp=s.pop();
                    al.add(temp.val);
                    while(!s.isEmpty() && temp==s.peek().right){
                        temp=s.pop();
                        al.add(temp.val);
                    }
                }else{
                    curr=temp;
                }
                
            }
        }
        return al;
    }
}