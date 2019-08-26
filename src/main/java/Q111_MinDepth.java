import java.util.List;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Definition for a binary tree nod
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Q111_MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }


        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0 ) {
            left = right;
        }

        if(right == 0 ) {
            right = left;
        }

        return (left >= right ? right : left)  + 1;
    }

    public static void main(String[] args) {
        Q111_MinDepth q111_minDepth = new Q111_MinDepth();

        TreeNode treeNode = new TreeNode(1, new TreeNode(2), null);


        int minDepth = q111_minDepth.minDepth(treeNode);
        System.out.println(minDepth);
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
}
