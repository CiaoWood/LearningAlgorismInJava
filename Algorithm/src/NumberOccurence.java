
// find the number occurence in a sorted list
public class NumberOccurence implements Testable{

	// header function using recursive way
	public int GetOccurence(int find, int[] arr, int start, int end){
		if(start > end) return 0;
		
		if(arr[start] > find) return 0; // the smallest one is larger than find
		if(arr[end] < find) return 0; // the largest one is smaller than find
		if(arr[start] == find && arr[end] == find) return end - start + 1;
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == find) return 1 + GetOccurence(find, arr, start, mid - 1) + GetOccurence(find, arr, mid + 1, end);
		else if (arr[mid] < find) return GetOccurence(find, arr, mid + 1, end);
		else return GetOccurence(find, arr, start, mid - 1);
	}

	@Override
	public void Test() {
		int[] arr = {1,2,3,4,5,6,6,6,6,6,7,7,8,8,8,9,10};
		int find = 7;
		int occurence = GetOccurence(find, arr, 0, arr.length - 1);
		System.out.println(occurence + " numbers are found in the array");
	}
}
