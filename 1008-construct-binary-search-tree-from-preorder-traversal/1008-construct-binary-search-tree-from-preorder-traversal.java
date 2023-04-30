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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;
      for(int i:preorder){
          root=ins(root,i);
      }  
        return root;
    }
    public TreeNode ins(TreeNode root,int val){
        if(root==null){
            root=new TreeNode(val);
            // return root;
        }
        else if(root.val<val){
            root.right=ins(root.right,val);
        }else{
            root.left=ins(root.left,val);
        }
        return root;
    }
}