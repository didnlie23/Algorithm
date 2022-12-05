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
    static int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return 0;
        count = 0;
        dfs(root);
        return count;
    }
    
    public boolean dfs(TreeNode node){
        if (node.left == null && node.right == null){
            count++;
            return true;            
        }else if (node.left == null){
            if (dfs(node.right) && node.val == node.right.val){
                count++;
                return true;
            }
        }else if (node.right == null){
            if (dfs(node.left) && node.val == node.left.val){
                count++;
                return true;
            }
        }else{
            boolean right = dfs(node.right);
            boolean left = dfs(node.left);
            if (right && left && node.val == node.left.val && node.val == node.right.val){
                count++;
                return true;
            }
        }
        return false;
    }
}