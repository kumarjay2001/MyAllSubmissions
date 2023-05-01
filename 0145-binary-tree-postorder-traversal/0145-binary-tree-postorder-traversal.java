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
//         ArrayList<Integer> al=new ArrayList<>();
//         Stack<TreeNode> s=new Stack<>();
//         TreeNode curr=root;
//         TreeNode temp=null;
//         while(curr!=null || !s.isEmpty()){
//             if(curr!=null){
//                 s.push(curr);
//                 curr=curr.left;
//             }else{
//                 temp=s.peek().right;
//                 if(temp==null){
//                     temp=s.pop();
//                     al.add(temp.val);
//                     while(!s.isEmpty() && temp==s.peek().right){
//                         temp=s.pop();
//                         al.add(temp.val);
//                     }
//                 }else{
//                     curr=temp;
//                 }
                
//             }
//         }
//         return al;
        
        ArrayList<Integer> al=new ArrayList<>();
        if(root==null)return al;
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        s1.push(root);
        
        while(!s1.isEmpty()){
            root=s1.pop();
            s2.push(root);
            if(root.left!=null)s1.push(root.left);
            if(root.right!=null)s1.push(root.right);
        }
        while(!s2.isEmpty()){
            al.add(s2.pop().val);
        }
        return al;
    }
}