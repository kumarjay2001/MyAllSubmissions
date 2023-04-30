/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> al1=new ArrayList<>();
        ArrayList<TreeNode> al2=new ArrayList<>();
        getpath(al1,root,p);
        getpath(al2,root,q);
        int i=0;
        for(;i<al1.size() && i< al2.size();i++){
            if(al1.get(i).val!=al2.get(i).val){
                break;
            }
        }
        return al1.get(i-1);
        
    }
    public boolean getpath(ArrayList<TreeNode> al,TreeNode root,TreeNode p){
        if(root==null)return false;
        al.add(root);
        if(root.val==p.val){
            return true;
        }
        boolean l=getpath(al,root.left,p);
        boolean r=getpath(al,root.right,p);
        if(l|| r){
            return true;
        }
        al.remove(al.size()-1);
        return false;
    }
}