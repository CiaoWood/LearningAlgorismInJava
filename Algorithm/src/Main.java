
public class Main {

	public static void main(String[] args) {
		SArray myArr = new SArray(1000,1000);
		SArray myArr2 = new SArray(myArr);
		
		Sort bubbleSort = new BubbleSort(myArr);
		Sort insertionSort = new InsertionSort(myArr2);

		long bubbleTime = bubbleSort.PrintRunTime();
		long insertionTime = insertionSort.PrintRunTime();
		
		System.out.println(insertionSort.getClass() + " is " + ((double)bubbleTime/insertionTime) + " times faster than " + bubbleSort.getClass());
	}

}
