
public class Main {

	public static void main(String[] args) {
		SArray myArr = new SArray();
		SArray myArr2 = new SArray(myArr);
		SArray myArr3 = new SArray(myArr);
		
		Sort bubbleSort = new BubbleSort(myArr);
		Sort sort2 = new QuickSort(myArr2);
		Sort sort3 = new ShellSort(myArr3);
		
		long bubbleTime = bubbleSort.PrintRunTime();
		long time2 = sort2.PrintRunTime();
		long time3 = sort3.PrintRunTime();
		
		System.out.println(String.format("%s is %.2f times faster than %s",sort2.getClass(), ((double)bubbleTime/time2), bubbleSort.getClass()));
		System.out.println(String.format("%s is %.2f times faster than %s",sort3.getClass(), ((double)bubbleTime/time3), bubbleSort.getClass()));
	}

}
