/**
 *给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
//计数排序
public class Q75_sortColors {

    public void sortColors(int[] nums) {
//        solution1(nums);
        int zeroIndex =0;
        int oneIndex = nums.length/2;
        int twoIndex = nums.length -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(i == zeroIndex) {

                }
                zeroIndex++;
                continue;
            }
            if(nums[i] == 1) {



            }
            if(nums[i] == 2) {

            }
        }
    }


    //O(n) O(K)
    private void solution1(int[] nums) {
        int[] count={0,0,0};
        for (int i = 0; i < nums.length; i++) {
            int a = count[nums[i]] +1;
            count[nums[i]] = a;
        }
        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index] = 0;
            index++;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index] = 1;
            index++;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index] = 2;
            index++;
        }
    }

    public static void main(String[] args) {
        Q75_sortColors sortColors = new Q75_sortColors();
        int[] nums = {0,0,2,1};
        sortColors.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);

        }
    }
}
