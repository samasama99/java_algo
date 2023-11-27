public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = invertTree(root.left);;
            root.left = invertTree(root.right);
            root.right = tmp;
        }
        return root;
    }

    // There is a TreeNode class available.
    static public class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;
    }
}
