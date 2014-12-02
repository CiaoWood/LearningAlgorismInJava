
public class Main {

	public static void main(String[] args) {
		SArray myArr = new SArray(1000,1000);
		SArray myArr2 = new SArray(myArr);
		
		Sort bubbleSort = new BubbleSort(myArr);
		Sort sort2 = new ShellSort(myArr2);

		long bubbleTime = bubbleSort.PrintRunTime();
		long time2 = sort2.PrintRunTime();
		
		System.out.println(sort2.getClass() + " is " + ((double)bubbleTime/time2) + " times faster than " + bubbleSort.getClass());
	}

}
