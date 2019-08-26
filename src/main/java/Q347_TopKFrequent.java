import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class Q347_TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0) {
            return res;
        }

        Map<Integer, Integer> topKFrequentMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if(topKFrequentMap.containsKey(nums[i])) {
                Integer freq = topKFrequentMap.get(nums[i]);
                topKFrequentMap.put(nums[i], freq + 1);
            } else {
                topKFrequentMap.put(nums[i], 1);
            }
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>(topKFrequentMap.size(), (a, b) -> b.freq - a.freq );
        topKFrequentMap.forEach((key,v) -> priorityQueue.offer(new Pair(key, v)));
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll().num);
        }
        return res;
    }

    class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }
    }
    public static void main(String[] args) {
        Q347_TopKFrequent q347_topKFrequent = new Q347_TopKFrequent();
        int[] nums = {1,1,1,2,2,3};
        q347_topKFrequent.topKFrequent(nums, 2);
    }
}
