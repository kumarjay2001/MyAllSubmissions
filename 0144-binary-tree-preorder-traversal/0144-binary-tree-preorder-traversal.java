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
    class Info{
        TreeNode root;
        int lvl;
        Info(TreeNode root,int lvl){
            this.root=root;
            this.lvl=lvl;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> pr=new ArrayList<>();
        ArrayList<Integer> in=new ArrayList<>();
        ArrayList<Integer> po=new ArrayList<>();
        if(root==null)return pr;
        Stack<Info> s=new Stack<>();
        s.push(new Info(root,1));
        while(!s.isEmpty()){
            Info i=s.pop();
            if(i.lvl==1){
                pr.add(i.root.val);
                i.lvl++;
                s.push(i);
                if(i.root.left!=null){
                    s.push(new Info(i.root.left,1));
                }
            }else if(i.lvl==2){
                in.add(i.root.val);
                i.lvl++;
                s.push(i);
                if(i.root.right!=null){
                    s.push(new Info(i.root.right,1));
                }
            }else{
                po.add(i.root.val);

            }
        }
        return pr;
    }
}