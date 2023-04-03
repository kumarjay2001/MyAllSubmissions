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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return banao(preorder,inorder,0,inorder.length-1);
    }
    public int preindex=0;
    public TreeNode banao(int []preorder,int []inorder,int is,int ie){
        if(is>ie)return null;
        TreeNode root=new TreeNode(preorder[preindex++]);
        int mini=is;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                mini=i;break;
            }
        }
        root.left=banao(preorder,inorder,is,mini-1);
        root.right=banao(preorder,inorder,mini+1,ie);
        return root;
    }
}