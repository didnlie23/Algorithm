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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root != null) dfs(root, list);
        return list;
    }

    public static void dfs(TreeNode node, List<Integer> list) {
        if (node.left != null) dfs(node.left, list);
        list.add(node.val);
        if (node.right != null) dfs(node.right, list);
    }
}
