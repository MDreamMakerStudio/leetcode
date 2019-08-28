/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q200_NumIslands {
    int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int m, n;
    boolean visited[][];


    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean searchWord(char[][] board, String word, int index, int x, int y) {

        if (index == word.length() - 1) {
            System.out.println("board1[x][y]: x" +x +"y " + y + "board " + board[x][y]);
            return board[x][y] == word.charAt(index);
        }


        if (board[x][y] == word.charAt(index)) {
            System.out.println("board2[x][y]: x" +x +"y " + y + "board " + board[x][y]);
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newx = x + d[i][0];
                int newy = x + d[i][1];
                System.out.println("newx: " + newx + "newy " + newy);
                System.out.println(inArea(newx, newy));
                System.out.println(!visited[newx][newy]);
                if (inArea(newx, newy) && !visited[newx][newy]
                        && searchWord(board, word, index + 1, newx, newy)) {
                    return true;
                }

            }
            visited[x][y] = false;
        }

        return false;
    }

    private boolean inArea(int newx, int newy) {
        System.out.println(m);
        System.out.println(n);
        System.out.println(newx);
        System.out.println(newy);
        return newx < m && newx >= 0 && newy < n && newy >= 0;
    }
/**
 *
 * [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
 * "ABCCED"
 * */
    public static void main(String[] args) {
        Q200_NumIslands q79_exist = new Q200_NumIslands();
        char[][] board= {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','F'}};
        String word = "ABCCED";
        System.out.println(q79_exist.exist(board, word));
    }

}
