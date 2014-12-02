
public class MergeSort extends Sort{
	// constructor
	public MergeSort() {
		super();
	}
	public MergeSort(int num, int maxValue) {
		super(num, maxValue);
	}
	public MergeSort(SArray sArr){
		super(sArr);
	}
	
	@Override
	void SortStart() {
		int[] array = super.sArr.getArray();
		int num = array.length;
		
		MergeSortStart(array, 0, num - 1);
	}
	
	private void MergeSortStart(int[] array, int i, int j) {
		assert(i <= j);
		if(i == j){
			return;
		}else if(i == j - 1){
			if(array[i] > array[j]){
				super.Swap(array, i, j);
			}
			return;
		}
		
		int mid = (i + j) / 2;
		MergeSortStart(array, i, mid);
		MergeSortStart(array, mid, j);
		
		Merge(array, i, mid, j);
	}
	
	private void Merge(int[] array, int start, int mid, int end) {
		assert(end > mid && mid > start);
		int minIdx = mid + 1;
		for(int i = start; i <= mid && minIdx <= end; i++){
			if( array[i] > array[minIdx]){
				super.Swap(array, i, minIdx);
			}else{
				minIdx++;
			}
		}
	}

}
