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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            if (temp.left != null){
                stack.push(temp.left);
                temp.left = null;
                continue;
            }
            if (temp.right != null){
                stack.push(temp.right);
                temp.right = null;
                continue;
            }
            list.add(stack.pop().val);
        }
        return list;
    }
}