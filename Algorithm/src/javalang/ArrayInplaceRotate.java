package javalang;/*
 * 输入：数组，pivot索引 Original: [1, 2, 3, 4, 5, 6, 7, 8, 9] pivot=3
 * 输出：rotate后的数组 After rotated: [5, 6, 7, 8, 9, 1, 2, 3, 4]
 * 原理： reverse3次
 */

import java.util.Arrays;

/**
 * @author wuchao
 */
public class ArrayInplaceRotate implements Testable {

    @Override
    public void test() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int pivot = 3;
        System.out.println("Original: " + Arrays.toString(array));
        Rotate(array, pivot);
        System.out.println("After rotated: " + Arrays.toString(array));
    }

    // the header function
    private void Rotate(int[] array, int k) {
        assert (k < array.length);
        if (k == array.length - 1) return;
        // first, we rotate 0 - k
        Reverse(array, 0, k);
        // then, we rotate k + 1 ~ length - 1
        Reverse(array, k + 1, array.length - 1);
        // finally, we rotate the whole array
        Reverse(array, 0, array.length - 1);
    }

    private void Reverse(int[] array, int start, int end) {
        assert (start <= end);
        assert (end < array.length);

        // reverse from outside to inside
        for (int i = start; i <= (start + end) / 2; i++) {
            Sort.Swap(array, i, start + end - i);
        }
    }
}
