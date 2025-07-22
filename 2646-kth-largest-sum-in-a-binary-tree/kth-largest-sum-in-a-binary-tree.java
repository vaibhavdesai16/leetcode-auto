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

    HashMap<Integer, Long> map = new HashMap<>();

    public long kthLargestLevelSum(TreeNode root, int k) {

        dfs(root, 0);

        List<Long> valuesList = new ArrayList<>(map.values());
        Collections.sort(valuesList, Collections.reverseOrder());

        if(valuesList.size() < k){
            return -1;
        }
        else{
            return valuesList.get(k-1);
        }

    }

    public void dfs(TreeNode node, int level){

        if(node == null){
            return;
        }

        if(map.containsKey(level)){
            map.put(level, map.get(level) + node.val);
        }
        else{
            map.put(level, (long) node.val);
        }

        dfs(node.left, level + 1);
        dfs(node.right, level + 1);

        return;
    }
}