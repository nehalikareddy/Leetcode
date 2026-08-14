class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean check(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        // Current node must be inside its allowed range
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Left subtree: values must be smaller than root
        if (!check(root.left, min, root.val)) {
            return false;
        }

        // Right subtree: values must be greater than root
        if (!check(root.right, root.val, max)) {
            return false;
        }

        return true;
    }
}