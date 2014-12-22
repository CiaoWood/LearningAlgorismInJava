/*
 * 输入：{1,2,3}
 * 输出：[1,2],[2,3],[1,3]
 */
public class SizeKSubset implements Testable{

	public void Test(){
		int[] arr = {1,2,3,4,5};
		boolean[] used = new boolean[arr.length];
		int K = 3;
		PrintAllSizeKSubset(arr, used, 0, 0, K);
	}

	/**
	 * the header function
	 * @param arr the input array
	 * @param used the array to record whether the slot is taken
	 * @param start recursion start place
	 * @param totalUsed total true count in used array
	 * @param k the input k
	 */
	private void PrintAllSizeKSubset(int[] arr, boolean[] used, int start, int totalUsed,
			int k) {
		
		// 先检查是否满足打印的条件
		if(totalUsed == k){
			for(int i = 0; i < arr.length; i++){
				if(used[i]) System.out.print(arr[i] + " ");
			}
			System.out.println();
			return; // 别忘了！
		}
		
		// 再检查是否超过上限
		if(start >= arr.length) return;
		
		// condition1, the slot is taken
		used[start] = true;
		PrintAllSizeKSubset(arr,used,start+1,totalUsed+1,k);
		
		// condition2, the slot is not taken
		used[start] = false;
		PrintAllSizeKSubset(arr,used,start+1,totalUsed,k);
		
	}
}
