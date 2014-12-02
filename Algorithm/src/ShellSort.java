
public class ShellSort extends InsertionSort {

	void SortStart() {
		int[] array = super.sArr.getArray();
		int num = array.length;
		
		for(int i = num)
		super.InsertionSortStart(array, 0, num - 1);
	}

}
