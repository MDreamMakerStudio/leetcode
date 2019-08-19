

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


public class Q110_IsSameTree {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        List<TreeNodePair> q = new LinkedList<TreeNodePair>();

        ((LinkedList<TreeNodePair>) q).offer(new TreeNodePair(root, 0));

        while ( q != null && q.size() > 0) {
            TreeNode treeNode = ((LinkedList<TreeNodePair>) q).element().getNode();
            Integer value = ((LinkedList<TreeNodePair>) q).element().getLevel();
            if (value == res.size()) {
                ArrayList<Integer> cureentLvelNodeValue = new ArrayList<Integer>();
                cureentLvelNodeValue.add(treeNode.val);
                res.add(cureentLvelNodeValue);
            } else {
                List<Integer> levelNodes = res.get(value);
                levelNodes.add(treeNode.val);
            }

            ((LinkedList<TreeNodePair>) q).poll();

            if (treeNode.left != null) {
                ((LinkedList<TreeNodePair>) q).offer(new TreeNodePair(treeNode.left, value + 1));
            }
            if (treeNode.right != null) {
                ((LinkedList<TreeNodePair>) q).offer(new TreeNodePair(treeNode.right, value + 1));
            }


        }
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class TreeNodePair {
        int level;
        TreeNode node;

        public TreeNodePair(TreeNode node, int level) {
            this.level = level;
            this.node = node;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }
    }

    public static void main(String[] args) {
//  [3,9,20,null,null,15,7]
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Q110_IsSameTree levelOrder = new Q110_IsSameTree();
        levelOrder.levelOrder(treeNode);
    }
}
