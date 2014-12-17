
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
	
	void SortStart() {
		int[] array = super.sArr.getArray();
		int num = array.length;
		
		MergeSortStart(array, 0, num - 1);
	}
	/**
	 * The main function to do the merge
	 * @param array
	 * @param start
	 * @param end
	 */
	private void MergeSortStart(int[] array, int start, int end) {
		assert(start <= end);
		if(start == end){
			return;
		}else if(start == end - 1){
			if(array[start] > array[end]){
				super.Swap(array, start, end);
			}
			return;
		}
		
		int mid = (start + end) / 2;
		MergeSortStart(array, start, mid);
		MergeSortStart(array, mid + 1, end);
		
		Merge(array, start, mid, end);
	}
	
	/**
	 * Merge 2 sorted array into one
	 * @param array
	 * @param start
	 * @param mid
	 * @param end
	 */
	private void Merge(int[] array, int start, int mid, int end) {
		assert(end > mid && mid > start);
		//int minIdx = mid + 1;
		int tempIdx = 0;
		int[] tempArr = new int[end-start+1];
		int i = start, j = mid + 1;
		for(; i <= mid && j <= end && tempIdx <= (end - start);){
			if( array[i] < array[j]){
				tempArr[tempIdx++] = array[i++];
			}else if(array[i] > array[j]){
				tempArr[tempIdx++] = array[j++];
			}else{
				tempArr[tempIdx++] = array[i++];
				tempArr[tempIdx++] = array[j++];
			}
		}
		
		// copy the rest sorted arry to temp
		if(i > mid){
			while(j <= end){
				tempArr[tempIdx] = array[j++];
			}
		}else{
			while(i <= mid){
				tempArr[tempIdx] = array[i++];
			}
		}
		
		// copy the sorted temp array back to array
		for(int ii = 0; ii <= end - start; ii++){
			array[start+ii] = tempArr[ii];
		}
	}
}
