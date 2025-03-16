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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return sum;
    }

    public void dfs(TreeNode node, TreeNode parent, TreeNode gParent){
        if(node == null){
            return;
        }

        if(gParent != null && gParent.val%2 == 0){
            sum += node.val;
        }

        dfs(node.left, node, parent);
        dfs(node.right, node, parent);
        return;
    }
}