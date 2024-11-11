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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root, 0);
        return isBalanced;
    }

    public int dfs(TreeNode node, int level){
        if(node == null){
            return level -1;
        }
        if(node.left == null && node.right == null){
            return level;
        }

        int left = dfs(node.left, level + 1);
        int right = dfs(node.right, level + 1);

        if(Math.abs(left - right) > 1){
            isBalanced = false;
        }

        return Math.max(left, right);
    }
}