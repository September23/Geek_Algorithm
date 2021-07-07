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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    // 中序  9 | 3 | 15 20 7
    //           i
    //      左   根    右
    
    
    // 后序  9 | 15 7 20 | 3
    //       左     右     根
    
    private TreeNode build(int inorder_left, int inorder_right, int postorder_left, int postorder_right) {
        // 递归终止条件
        if (postorder_left > postorder_right) return null;
        
        // 处理当前层逻辑
        
        TreeNode root = new TreeNode(postorder[postorder_right]);
        // 找到根节点在中序遍历中的位置 然后划分左右子树
        int index = inorder_left;
        // index 表示中序遍历中根节点的位置索引
        while (inorder[index] != postorder[postorder_right]) index++;
        
        int leftSize = index - inorder_left;
        int rightSize = inorder_right - index;
        // 处理递归
        root.left = build(inorder_left, index - 1, postorder_left, postorder_left + leftSize - 1);
        root.right = build(index + 1, inorder_right, postorder_left + leftSize, postorder_right - 1);
        return root;
    }
    
    private int[] inorder;
    private int[] postorder;
}