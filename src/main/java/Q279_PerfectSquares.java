import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class Q279_PerfectSquares {

    public int numSquares(int n) {
        Queue<Pair> queue = new LinkedList<Pair>();
        ((LinkedList<Pair>) queue).addLast(new Pair(n, 0));
        boolean[] visited = new boolean[n+1];
        visited[n] = true;
        while (!queue.isEmpty()) {
            int num = ((LinkedList<Pair>) queue).getFirst().num;
            int step = ((LinkedList<Pair>) queue).getFirst().pathNum;
            Pair poll = queue.poll();

            for (int i = 1; ; i++) {
                int a = num - i * i;
                if(a < 0) {
                    break;
                }
                if(a == 0) {
                    return step +1;
                }
                if(!visited[a]) {
                    ((LinkedList<Pair>) queue).addLast(new Pair(a, step + 1));
                    visited[a] = true;
                }

            }
        }
        return Integer.MAX_VALUE;
    }

    class Pair {
        int num;
        int pathNum;

        public Pair(int num, int pathNum) {
            this.num = num;
            this.pathNum = pathNum;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getPathNum() {
            return pathNum;
        }

        public void setPathNum(int pathNum) {
            this.pathNum = pathNum;
        }
    }

    public static void main(String[] args) {
        Q279_PerfectSquares q279_perfectSquares = new Q279_PerfectSquares();
        q279_perfectSquares.numSquares(5);
    }
}
