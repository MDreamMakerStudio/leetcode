/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;


public class Q77_Combine {
    List<List<Integer>> res = new ArrayList<>();
    private static boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
//        return 垃圾实现(nums);
        if(nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            used[i] = false;
        }
        generatePermutation(nums, 0, new ArrayList<>());
        return res;

    }

    private void generatePermutation(int[] nums, int index, List<Integer> p) {
        if (nums.length == index) {
            ArrayList<Integer> newP = new ArrayList<>();
            newP.addAll(p);
            res.add(newP);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                if()
                used[i] = false;
                p.remove(p.size() - 1);
            }
        }
        return;

    }

    public static void main(String[] args) {
        Q77_Combine q46_permute = new Q77_Combine();
        System.out.println(q46_permute.permute(new int[]{1, 1,2}));
    }

    private List<List<Integer>> 垃圾实现(int[] nums) {
        ArrayList<Integer> nums1 = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            nums1.add(nums[i]);
        }

        findPermute(nums1, new ArrayList<>());
        return res;
    }

    private void findPermute(List<Integer> nums, List<Integer> any) {
        if (nums.size() == 0) {
            res.add(any);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            ArrayList<Integer> newAny = new ArrayList<>();
            newAny.addAll(any);

            Integer target = nums.get(i);
            newAny.add(target);

            ArrayList<Integer> newNumbs = new ArrayList<>();
            newNumbs.addAll(nums);
            newNumbs.remove(target);

            findPermute(newNumbs, newAny);
        }
        return;
    }

}
