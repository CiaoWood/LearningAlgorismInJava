
public abstract class Sort{
	
	public SArray sArr;
	
	// constructor
	public Sort(int num, int maxValue) {
		sArr = new SArray(num, maxValue);
	}
	public Sort(SArray sArr) {
		this.sArr = sArr;
	}
	public Sort() {
		sArr = new SArray();
	}
	
	// the main function that needs to be inherited
	abstract void SortStart();
	
	// the print function that can print run time
	public long GetRunTime(){
		//sArr.PrintArray();
		long startTime = System.nanoTime();
		SortStart();
		long endTime = System.nanoTime();
		//sArr.PrintArray();
		System.out.println("The " + this.getClass() + " takes " + (endTime - startTime)/1000000.0 + " ms");
		return (endTime - startTime);
	}
	public long PrintRunTime(int times){
		assert(times > 0);
		long interval = 0;
		while(times-- > 0){
			long startTime = System.nanoTime();
			SortStart();
			long endTime = System.nanoTime();
			sArr.ReGenArr();
			interval += (endTime - startTime);
		}
		
		System.out.println("The " + this.getClass() + " takes " + (interval)/1000000.0 + " ms");
		return interval;
	}
	
	// Swap num using just one line
	public static void Swap(int[] arr, int i, int j){
		arr[i] = arr[j] + (arr[j] = arr[i]) * 0;
	}

}
