package javalang;

public class BubbleSort extends Sort {

    // constructor
    public BubbleSort() {
        super();
    }

    public BubbleSort(int num, int maxValue) {
        super(num, maxValue);
    }

    public BubbleSort(SArray sArr) {
        super(sArr);
    }

    void SortStart() {
        int[] array = sArr.getArray();
        int num = array.length;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                if (array[j] > array[j + 1])
                    super.Swap(array, j, j + 1);
            }
        }

    }

}
