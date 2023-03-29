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

        getPath(root,p,al1);
        getPath(root,q,al2);

        int i=0;
        for(;i<al1.size() && i<al2.size();i++){
            if(al1.get(i)!=al2.get(i)){
                break;
            }
        }
        return al1.get(i-1);
    }
    public boolean getPath(TreeNode root,TreeNode p,ArrayList<TreeNode> al){
        if(root==null){
            return false;
        }
        al.add(root);
        if(root.val==p.val){
            return true;
        }
        boolean leftp=getPath(root.left,p,al);
        boolean rightp=getPath(root.right,p,al);
        if(leftp || rightp){
            return true;
        }
        al.remove(al.size()-1);
        return false;
    }
}