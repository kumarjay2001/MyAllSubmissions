public class Solution {
    private Map<TreeNode, Integer> map;
    private int mod = 1000000007;
    
    public Solution() {
        map = new HashMap<>();
    }
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public int numOfWays(int[] nums) {
        TreeNode root = buildTree(nums);
        return (int) (numOfWays(root) % mod) - 1;
    }
    
    private long numOfWays(TreeNode node) {
        if (node == null)
            return 1;
        int n = numOfNodes(node.left);
        int m = numOfNodes(node.right);
        
        return ((((binomialCoeff(n + m, n) % mod) * numOfWays(node.left)) % mod) * numOfWays(node.right)) % mod;
    }

	// calulate the number of descendants of this node including the node itself
    private int numOfNodes(TreeNode node) {
		// dp to decrease the runtime
        if (map.containsKey(node))
            return map.get(node);
        if (node == null) 
            return 0;
        
        int num = 1 + numOfNodes(node.left) + numOfNodes(node.right);
        map.put(node, num);
        return num;
    }
    
	// method to calculate the value of nCk
    private int binomialCoeff(int n, int k) {
        int[] c = new int[k + 1];
        c[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, k); j > 0; j--) 
                c[j] = (c[j] + c[j - 1]) % mod;
        }
        return c[k] % mod;
    }

  
    private TreeNode buildTree(int[] nums) {
        TreeNode tree = null;
        for (int num : nums)
            tree = insert(tree, num);
        return tree;
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);

        return root;
    }

}
