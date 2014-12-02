import java.util.Random;


public class SArray {
	private int num = 300;
	private int maxValue = 1000;
	private int[] array;
	private int[] copyArray;

	// getter and setter
	int getNum() {
		return num;
	}
	void setNum(int num) {
		if(num > 0)
			this.num = num;
	}
	int getMaxValue() {
		return maxValue;
	}
	void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	int[] getArray() {
		if(array == null){
			array = GenRandomArr(this.getNum(), this.getMaxValue());
		}
		return array;
	}
	int[] getCopyArray() {
		return copyArray;
	}
	
	/**
	 * @param number of array
	 * @param maxValue of item
	 */
	public SArray(int num, int maxValue) {
		this.num = num;
		this.maxValue = maxValue;
	}
	
	// copy constructor
	public SArray(SArray arr){
		setNum(arr.getNum());
		setMaxValue(arr.getMaxValue());
		array = new int[this.getNum()];
		for(int i = 0; i < this.getNum(); i++){
			this.array[i] = arr.getArray()[i];
		}
	}
	
	// the function to create random int number for array
	public int[] GenRandomArr(int num, int maxValue) {
		int[] ranArr = new int[num];
		Random ran = new Random();
		for(int i = 0; i < num; i++){
			ranArr[i] = ran.nextInt(maxValue);
		}
		return ranArr;
	}
	
	// the function to regen array when we need to sort again
   	public void ReGenArr() {
		Random ran = new Random();
		for(int i = 0; i < num; i++){
			this.getArray()[i] = ran.nextInt(maxValue);
		}
	}
		
	// Print Array
	public void PrintArray(){
		System.out.println("The array is");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	public void PrintArray(int[] array){
		System.out.println("The array is");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
