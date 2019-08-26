
/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//根左右
public class Q144_PreorderTraversal {
    List<Integer> nodes = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return nodes;
        }
//        solution1(root);
        solution2(root);
        return nodes;
    }

    /**
     * 执行用时 :
     * 4 ms , 在所有 Java 提交中击败了 6.18% 的用户
     * 内存消耗 : 35.6 MB  , 在所有 Java 提交中击败了 40.54% 的用户
     * */
    private void solution2(TreeNode root) {
        Stack<Command> commands = new Stack<Command>();
        commands.push(new Command("go", root));
        while (!commands.empty()) {
            Command currentCommand = commands.pop();
            if ("go".equals(currentCommand.getCommand())) {
                TreeNode right = currentCommand.getNode().right;
                TreeNode left = currentCommand.getNode().left;
                if (right != null) {
                    commands.push(new Command("go", right));
                }
                if (left != null) {
                    commands.push(new Command("go", left));
                }
                commands.push(new Command("print", currentCommand.getNode()));
            } else if ("print".equals(currentCommand.getCommand())) {
                nodes.add(currentCommand.getNode().val);
            }
        }
    }

    private void solution1(TreeNode root) {
        if (root != null) {
            nodes.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public class Command {
        String command;
        TreeNode node;

        public Command(String command, TreeNode node) {
            this.command = command;
            this.node = node;
        }

        public String getCommand() {
            return command;
        }

        public TreeNode getNode() {
            return node;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
