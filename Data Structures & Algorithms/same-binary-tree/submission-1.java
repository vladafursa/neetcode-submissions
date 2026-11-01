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
    public boolean isSameTree(TreeNode p, TreeNode q) {
     

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(p);
        q2.offer(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode top1 = q1.poll();
            TreeNode top2 = q2.poll();

            if(top1!=null && top2!=null){
                if(top1.val!=top2.val) return false;
            }else{
                if(top1!=top2) return false;
            }

            if(top1!=null){
                q1.offer(top1.left);
                q1.offer(top1.right);
            }

            if(top2!=null){
                q2.offer(top2.left);
                q2.offer(top2.right);
            }

        }

        return q1.isEmpty() && q2.isEmpty();
    }
}
