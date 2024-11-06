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
    List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode node, int level){
        if(node == null && node == null){
            return;
        }

        if(result.size() > level){
            result.set(level, Math.max(node.val, result.get(level)));
        }
        else{
            result.add(node.val);
        }

        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}