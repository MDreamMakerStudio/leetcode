
/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q283_moveZeroes {
    public void moveZeroes(int[] nums) {
//        solution1(nums);
//        solution2(nums);
        if (nums.length == 1) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if(i == j) {
                    j++;
                    continue;
                }
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }

    private void solution2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Q283_moveZeroes q = new Q283_moveZeroes();
        int[] ints = {0, 1, 0, 3, 12};
        q.moveZeroes(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }

    }

    private void solution1(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {

                res[index] = nums[i];
                index++;
            }
        }

        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
        for (int i = res.length - 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
