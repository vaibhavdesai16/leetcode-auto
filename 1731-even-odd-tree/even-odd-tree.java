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
    List<Integer> list = new ArrayList<>();
    boolean isValid = true;
    public boolean isEvenOddTree(TreeNode root) {
        if(root != null && root.val % 2  == 0) return false; 
        traverse(0, root);
        return this.isValid;
    }

    public void traverse(int level, TreeNode node){
        if(node == null){
            return;
        }

        if(list.size() > level){
            if(level % 2 == 1){
                // level is odd
                if(list.get(level) <= node.val || node.val %2 != 0){
                    this.isValid = false;
                }
            }
            else{
                //if level is even
                if(list.get(level) >= node.val || node.val %2 == 0){
                    this.isValid = false;
                }
            }
            //overritte by current node
            list.set(level, node.val);
        }
        else{
            if(level % 2 == 0 && node.val %2 == 0){
                //even level
                this.isValid = false;
            }
            else if(level % 2 == 1 && node.val % 2 == 1){
                //odd level
                this.isValid = false;
            }
            list.add(node.val);
        }

        if(isValid){
            traverse(level+1, node.left);
            traverse(level+1, node.right);
        }
    }
}