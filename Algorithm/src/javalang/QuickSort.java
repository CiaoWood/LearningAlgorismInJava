package javalang;

public class QuickSort extends Sort {
    // constructor
    public QuickSort() {
        super();
    }

    public QuickSort(int num, int maxValue) {
        super(num, maxValue);
    }

    public QuickSort(SArray sArr) {
        super(sArr);
    }

    void SortStart() {
        int[] arr = super.sArr.getArray();
        int num = arr.length;
        Quick(arr, 0, num - 1);

    }

    private void Quick(int[] arr, int start, int end) {
        assert (start <= end);
        if (start == end) {
            return;
        } else if (start == end - 1) {
            if (arr[start] > arr[end]) {
                super.Swap(arr, start, end);
            }
            return;
        }

        int pivot = QuickDivideByLast(arr, start, end);
        if (pivot - 1 > start)
            Quick(arr, start, pivot - 1);
        if (pivot + 1 < end)
            Quick(arr, pivot + 1, end);
        return;
    }

    /**
     * Choose the last element as the pivot, then arrange smaller value to its left, larger value to its right
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int QuickDivideByLast(int[] arr, int start, int end) {
        assert (start <= end);
        int pivotPointer = end;
        int comparePointer = start;
        int incre = 1; //控制加或减，若是正，代表pivot在compare右边
        while (pivotPointer != comparePointer) {
            if (arr[pivotPointer] < arr[comparePointer] && incre == 1) {
                super.Swap(arr, pivotPointer, comparePointer);
                incre = -1;
                pivotPointer = comparePointer + (comparePointer = pivotPointer + incre) * 0;
            } else if (arr[pivotPointer] > arr[comparePointer] && incre == -1) {
                super.Swap(arr, pivotPointer, comparePointer);
                incre = 1;
                pivotPointer = comparePointer + (comparePointer = pivotPointer + incre) * 0;
            } else {
                comparePointer += incre;
            }
        }
        return pivotPointer;
    }

}
