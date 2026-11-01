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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            if(top!=null){
                if(top.left!=null && top.right!=null){
                    TreeNode temp = top.left;
                    top.left=top.right;
                    top.right = temp;
                    queue.offer(top.left);
                    queue.offer(top.right);
                }else if(top.left==null){
                    top.left=top.right;
                    top.right=null;
                    queue.offer(top.left);
                }else if(top.right==null){
                    top.right = top.left;
                    top.left=null;
                    queue.offer(top.right);
                }
            }
        }
        return root;
    }
}
