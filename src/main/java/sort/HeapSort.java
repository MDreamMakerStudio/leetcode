package sort;

import java.util.Arrays;

/**
 * 1.父结点索引：(i-1)/2（这里计算机中的除以2，省略掉小数）
 *
 * 2.左孩子索引：2*i+1
 *
 * 3.右孩子索引：2*i+2
 *
 * 堆排序（优化后的选择排序）的时间复杂度O(N*logN),额外空间复杂度O(1)，是一个不稳定性的排序
 * 堆排序将要排序的对象看做一颗完全二叉树，数据结构可以用数组来实现
 *
 * https://blog.csdn.net/u010452388/article/details/81283998
 * */
public class HeapSort {

    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;

        buildMaxHeap(arr, len);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, i, 0);
            buildMaxHeap(arr, i);
        }

        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
//        System.out.println("i: " + i + " largest: " + largest + " left: " +left + " right: " + right);
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        HeapSort heapSort = new HeapSort();

        int[] arr = {5, 2, 7, 3, 6, 1, 4};
        heapSort.buildMaxHeap(arr, 7);

//        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(heapSort.sort(arr)));
    }
}
