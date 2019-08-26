/**
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q101_IsSymmetricTree {
    boolean flag = true;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode leftTreeNode = new TreeNode(root.val);
        leftTreeNode.left = root.left;
        TreeNode rightTreeNode = new TreeNode(root.val);
        rightTreeNode.right = root.right;
        inverseRightTree(rightTreeNode);

        return isSameTree(leftTreeNode, rightTreeNode);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null && q != null) {
            flag = false;
            return false;
        }

        if (p != null && q == null) {
            flag = false;
            return false;
        }

        if(p.val != q.val) {
            flag = false;
            return false;
        }
        if(flag) {
            isSameTree(p.left, q.left);
            isSameTree(p.right, q.right);
        }

        return flag;
    }

    private void inverseRightTree(TreeNode root) {
        if(root == null) {
            return;
        }
        inverseRightTree(root.left);
        inverseRightTree(root.right);
        swap(root);
    }

    private void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
