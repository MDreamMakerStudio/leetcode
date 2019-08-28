import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
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
public class Q79_Exist {

    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null) {
            return ret;
        }
//        List<List<Integer>> lists = solution1(root, new ArrayList<Integer>(), sum);

        if(root.left == null && root.right == null) {
            if(sum-root.val == 0) {
                ret.add(path);
            }
            return ret;
        }

        path.add(root.val);

        if(root.left != null) {
            pathSum(root.left, sum-root.val);
        }

        if(root.right != null) {
            pathSum(root.right, sum-root.val);
        }

        return ret;
    }

    private List<List<Integer>> solution1(TreeNode root, List<Integer> path, int expectedSum) {
        if(root.left == null && root.right == null) {
            int actualValue = 0;
            for(Integer nodeValue : path) {
                actualValue = nodeValue + actualValue;
            }
            if((actualValue + root.val) == expectedSum) {
                path.add(root.val);
                ret.add(path);
            }
            return ret;
        }
        path.add(root.val);
        if(root.left != null) {
            solution1(root.left, new ArrayList<>(path), expectedSum);
        }

        if(root.right != null) {
            solution1(root.right, new ArrayList<>(path), expectedSum);
        }

        return ret;
    }

    public static void main(String[] args) {
        Q79_Exist q113_pathSum = new Q79_Exist();
        /*TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8));*/
        TreeNode root = new TreeNode(0,
                new TreeNode(1),
                new TreeNode(1));
//        System.out.println(q113_pathSum.solution1(root,1).toString());
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
