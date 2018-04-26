package javalang;

public class ShellSort extends Sort {
    // constructor
    public ShellSort() {
        super();
    }

    public ShellSort(int num, int maxValue) {
        super(num, maxValue);
    }

    public ShellSort(SArray sArr) {
        super(sArr);
    }

    void SortStart() {
        int[] array = super.sArr.getArray();
        int num = array.length;

        for (int d = num / 2; d > 0; d /= 2) {
            for (int i = d; i < num; i++) {
                //temp = array[i];
                for (int j = i; j >= d; j -= d) {
                    if (array[j] < array[j - d]) {
                        super.Swap(array, j, j - d);
                    } else {
                        break;
                    }
                }
                //array[j] = temp;
            }
        }
    }

}
