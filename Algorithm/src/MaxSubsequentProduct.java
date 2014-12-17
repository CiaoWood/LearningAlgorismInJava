/*
 * 输入：数组
 * 输出：最大连续乘积
 * 原理：动态规划算法。逐index计算最大正乘积和最大负乘积，再利用上一个index的这两个值
 */
public class MaxSubsequentProduct implements Testable{

	@Override
	public void Test() {
		double[] arr = {-2.0, -1.5, -3.0};
		System.out.println("The max subsequent product is " + GetMaxSubsequentProduct(arr));
	}
	
	//private double maxNeg = 0;
	
	public static double GetMaxSubsequentProduct(double[] arr){
		double curPos = 1;
		double curNeg = 1;
		double maxPos = 0;
		double tempNeg = 0;
		for(int i = 0; i < arr.length; i++){
			//判断当前元素的正负，并更新curPos和curNeg
			if(arr[i] > 0){
				curPos *= arr[i];
				if(curNeg != 1) curNeg *= arr[i];
			}else if(arr[i] < 0){
				tempNeg = curNeg;
				curNeg = curPos * arr[i];
				curPos = tempNeg * arr[i];
			}else{
				curPos = 1;
				curNeg = 1;
			}
			if(curPos > maxPos) maxPos = curPos;
			//若curPos小于1，则重置curPos
			if(curPos < 1) curPos = 1;
		}
		return maxPos;
	}
	
	
}
