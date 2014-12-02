
public class Main {

	public static void main(String[] args) {
		SArray myArr = new SArray(1000,1000);
		SArray myArr2 = new SArray(myArr);
		SArray myArr3 = new SArray(myArr);
		
		Sort bubbleSort = new BubbleSort(myArr);
		Sort sort2 = new MergeSort(myArr2);
		Sort sort3 = new ShellSort(myArr3);
		
		long bubbleTime = bubbleSort.PrintRunTime();
		long time2 = sort2.PrintRunTime();
		long time3 = sort3.PrintRunTime();
		
		System.out.println(sort2.getClass() + " is " + ((double)bubbleTime/time2) + " times faster than " + bubbleSort.getClass());
		System.out.println(sort3.getClass() + " is " + ((double)bubbleTime/time3) + " times faster than " + bubbleSort.getClass());
	}

}
