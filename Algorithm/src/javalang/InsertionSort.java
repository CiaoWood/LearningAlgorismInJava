package javalang;

public class InsertionSort extends Sort {

    // constructor
    public InsertionSort() {
        super();
    }

    public InsertionSort(int num, int maxValue) {
        super(num, maxValue);
    }

    public InsertionSort(SArray sArr) {
        super(sArr);
    }

    void SortStart() {
        int[] array = super.sArr.getArray();
        int num = array.length;

        InsertionSortStart(array, 0, num - 1);
    }

    // the recur function of insertion sort
    protected void InsertionSortStart(int[] arr, int i, int j) {
        if (i >= j)
            return;
        // we sort i~j-1 part
        InsertionSortStart(arr, i, j - 1);

        // we assue i~j-1 is sorted, so we just insert arr[j] to i ~ j-1
        BiInsert(arr, i, j - 1);

    }

    /**
     * @param arr to be inserted
     * @param i is the up limit of range
     * @param j is the down limit of range, j+1 is the one to be inserted
     */
	/*
	private void Insert(int[] arr, int i, int j) {
		assert (i <= j);
		for(int ii = j; ii >= i; ii--){
			if(arr[ii] > arr[ii+1])
				super.Swap(arr, ii, ii+1);
			else
				return;
		}
	}
	*/

    /**
     * @param arr to be inserted
     * @param i   is the up limit of range
     * @param j   is the down limit of range, j+1 is the one to be inserted
     */
    private void BiInsert(int[] arr, int i, int j) {
        assert (i <= j);
        int insBefore = FindInsIdx(arr, i, j, arr[j + 1]);
        InsertAndShift(arr, insBefore, j + 1);
    }

    private int FindInsIdx(int[] arr, int i, int j, int insValue) {
        assert (i <= j);
        if (i == j) {
            return arr[i] <= insValue ? i + 1 : i;
        } else if (i == j - 1) {
            if (insValue < arr[i]) {
                return i;
            } else if (insValue < arr[j]) {
                return j;
            } else
                return j + 1;

        }
        int mid = (i + j) / 2;
        if (arr[mid] < insValue) {
            return FindInsIdx(arr, mid, j, insValue);
        } else if (arr[mid] > insValue) {
            return FindInsIdx(arr, i, mid, insValue);
        } else {
            return mid + 1;
        }
    }

    private void InsertAndShift(int[] arr, int insBefore, int toBeInsIdx) {
        // if to be inserted is the same as insert index, we do nothing
        if (insBefore == toBeInsIdx) {
            return;
        }

        int insValue = arr[toBeInsIdx];
        for (int i = toBeInsIdx; i > insBefore; i--) {
            arr[i] = arr[i - 1];
        }
        arr[insBefore] = insValue;
    }
}
