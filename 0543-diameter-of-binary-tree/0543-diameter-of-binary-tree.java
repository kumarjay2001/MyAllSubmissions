
class Solution {
        
//         It's a first bruth approach having O(N^2) comp.....
        /*
    public int diameterOfBinaryTree(TreeNode root) {    
        if(root==null)return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        int ldi=diameterOfBinaryTree(root.left);
        int rdi=diameterOfBinaryTree(root.right);
        int orgiheight=lh+rh;
        return Math.max(Math.max(ldi,rdi),orgiheight);
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        return (Math.max(height(root.left),height(root.right))+1);
    }
    */ 
    class Info{
        int diam;
        int ht;
        public Info(int diam,int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
   public int diameterOfBinaryTree(TreeNode root) {
       return diamm(root).diam-1;
   }
    public Info diamm(TreeNode root){
        if(root==null){
            return new Info(0,0);
        }
        Info leftInfo=diamm(root.left);
        Info rightInfo=diamm(root.right);
        int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
        int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(diam,ht);
    }    
    
}