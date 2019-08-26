/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q257_BinaryTreePaths {

    List<String> ret = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) {
            return ret;
        }
        if(root.left == null && root.right == null) {
            //加入当前节点在
            ret.add(String.valueOf(root.val));
            return ret;
        }
        return binaryTreePath(root, "");

    }

    private List<String> binaryTreePath(TreeNode root, String path) {

        if(root.left == null && root.right == null) {
            //加入当前节点在
            ret.add(path + "->" + root.val);
            return ret;
        }
        String newPath;
        if("".equals(path)) {
            newPath = String.valueOf(root.val);
        } else {
            newPath = path + "->" + root.val;
        }


        if(root.left != null) {
            binaryTreePath(root.left, newPath);
        }

        if(root.right != null) {
            binaryTreePath(root.right, newPath);
        }

        return ret;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
