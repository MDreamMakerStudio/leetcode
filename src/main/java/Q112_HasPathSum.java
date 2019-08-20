/**
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
public class Q112_HasPathSum {
    int count = 0;
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        countNodes(root.left);
        countNodes(root.right);
        return ++count;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Q112_HasPathSum q222_countTreeNodes = new Q112_HasPathSum();
//        TreeNode treeNode = new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null));
        TreeNode treeNode = new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, new TreeNode(6, null,null), null));
        int i = q222_countTreeNodes.countNodes(treeNode);
        System.out.println(i);
    }
}
