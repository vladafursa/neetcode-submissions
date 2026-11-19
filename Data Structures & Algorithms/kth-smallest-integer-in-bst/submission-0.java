class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] state = {0, 0};
        dfs(root, k, state);
        return state[1];
    }

    private void dfs(TreeNode root, int k, int[] state) {
        if (root == null) return;
        dfs(root.left, k, state);
        state[0]++;
        if (state[0] == k) {
            state[1] = root.val;
            return;
        }
        dfs(root.right, k, state);
    }
}