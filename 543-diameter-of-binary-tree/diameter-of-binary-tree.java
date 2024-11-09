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
    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDia;
    }

    public int dfs(TreeNode node){
        if(node == null) return -1;
        if(node.left == null && node.right == null) return 0;

        int lDia = dfs(node.left) +1;
        int rDia = dfs(node.right) +1;

        int currDia = lDia + rDia;
        maxDia = Math.max(currDia, maxDia);
        return Math.max(lDia, rDia);
    }
}