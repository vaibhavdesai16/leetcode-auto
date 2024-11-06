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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode r = root;
        dfs(r, target);
        if(root.left == null && root.right == null && root.val == target){
            return null;
        }
        return root;
    }

    public boolean dfs(TreeNode node, int target){
        if(node == null){
           return false;
        }
        else if(node.left == null && node.right == null){
            return true;
        }

        boolean hasLeafToLeft = dfs(node.left, target);
        boolean hasLeafToRight = dfs(node.right, target);

        if(hasLeafToLeft && node.left.val == target){
            node.left = null;
        }
        if(hasLeafToRight && node.right.val == target){
            node.right = null;
        }

        if(node.left == null && node.right == null){
            return true;
        }else{
            return false;
        }
    }
}