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
    boolean isValid = true;
    public boolean isSymmetric(TreeNode root) {
        dfs(root.left, root.right);
        return isValid;
    }

    public void dfs(TreeNode l, TreeNode r){
        if(l == null && r == null){
            return;
        }

        if(l == null || r == null){
            isValid = false;
            return;
        }

        if(l.val != r.val){
            isValid = false;
        }

        dfs(l.left, r.right);
        dfs(l.right, r.left);
    }
}