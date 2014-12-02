
public class ShellSort extends InsertionSort {
	// constructor
	public ShellSort() {
		super();
	}
	public ShellSort(int num, int maxValue) {
		super(num, maxValue);
	}
	public ShellSort(SArray sArr){
		super(sArr);
	}
	
	void SortStart() {
		int[] array = super.sArr.getArray();
		int num = array.length;
		int temp = 0;
		int j = 0;
		
		for(int d = num / 2; d > 0; d /= 2){
			for(int i = d; i < num; i++){
				temp = array[i];
				for(j = i; j >= d; j -= d){
					if(temp > array[j - d]){
						array[j] = array[j - d];
					}else{
						break;
					}
				}
				array[j] = temp;
			}
		}
	}

}
