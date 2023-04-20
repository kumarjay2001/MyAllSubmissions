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
    public class Pair{
        int is;
        TreeNode root;
        public Pair(int is,TreeNode root){
            this.root=root;
            this.is=is;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
                int start = 0, end = 0;
int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            int offsetMin = q.peek().is;
            int n=q.size();
              for (int i = 0; i < n; i++) {
                int curInd = q.peek().is - offsetMin;
                TreeNode child = q.remove().root;
                if (i == 0) {
                    start = curInd;
                }
                if (i == n - 1) {
                    end = curInd;
                }
                if (child.left != null) {
                    q.add(new Pair( 2 * curInd + 1,child.left));
                }
                if (child.right != null) {
                    q.add(new Pair(2 * curInd + 2,child.right));
                }
            }
               ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}