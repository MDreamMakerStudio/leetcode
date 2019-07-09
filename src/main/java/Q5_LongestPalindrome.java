import java.util.ArrayList;
import java.util.Collections;

/**
 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。

 示例 1:

 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0
 示例 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q5_LongestPalindrome {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return method1(nums1, nums2);

    }
    private double method2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    private double method1(int[] nums1, int[] nums2) {
        ArrayList<Integer> allNums = new ArrayList<Integer>();
        convertArray2List(nums1, allNums);
        convertArray2List(nums2, allNums);
        Collections.sort(allNums);
        if(allNums.size()%2 == 0) {
            return ((double)allNums.get(allNums.size()/2) + (double)allNums.get(allNums.size()/2 - 1))/2;
        } else {
            return (double)allNums.get(allNums.size()/2);
        }
    }

    private void convertArray2List(int[] nums1, ArrayList<Integer> allNums) {
        for (int i = 0; i < nums1.length; i ++) {
            allNums.add(nums1[i]);
        }
    }

    public static void main(String[] args) {
        Q5_LongestPalindrome test = new Q5_LongestPalindrome();
        int[] num1 = {1,3};
        int[] num2 = {2};
//        int[] num1 = {1,2};
//        int[] num2 = {3,4};
        double median = test.findMedianSortedArrays(num1, num2);
        System.out.println(median);
    }
}
