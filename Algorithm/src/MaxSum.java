/*
 * 输入：数组，可以有整数或者负数
 * 输出：最大连续和，以及最小索引和最大索引中的值。若最大和是负的，则输出0,arr[0]，arr[length-1]
 */

public class MaxSum implements Testable{
	private int[] FindMaxSum(int[] intArr, int num) {
		int sum = 0;
		int max = 0;
		int minValIdx = 0;
		int maxValIdx = num - 1;
		for(int i = 0; i < num; i++){
			// sum == 0 代表着新的开始
			if(sum == 0){	
				minValIdx = i;
				maxValIdx = i;
			}
			sum += intArr[i];
			if(sum > max) {
				max = sum;
				maxValIdx = i;
			}
			// sum < 0 则舍弃之前的sum，从头开始
			else if(sum < 0)
				sum = 0;
		}
		if(max <= 0) {
			max = 0;
			minValIdx = 0;
			maxValIdx = num - 1;
		}
		return new int[]{intArr[minValIdx], intArr[maxValIdx], max};
	}
	
	public void Test(){
		int[] intArr = {-1,1,2,-1,3,-2,4};
		int num = intArr.length;
		int[] output = FindMaxSum(intArr, num);
		for(int i = 0; i < output.length; i++){
			System.out.print(output[i]);
			if(i != output.length - 1)
				System.out.print(" ");
		}
	}
}
