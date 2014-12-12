import java.util.Scanner;


public class MaxSum {
	private int[] FindMaxSum(int[] intArr, int num) {
		int sum = 0;
		int max = 0;
		int minVal = intArr[0];
		int maxVal = intArr[num -1];
		Boolean isConseq = true;
		for(int i = 0; i < num; i++){
			sum += intArr[i];
			if(sum > max) {
				max = sum;
				if(!isConseq)
					minVal = intArr[i];
				maxVal = intArr[i];
			}
			else if(sum < 0){
				sum = 0;
				isConseq = false;
			}
		}
		if(sum < 0) {
			sum = 0;
			minVal = intArr[0];
			maxVal = intArr[num - 1];
		}
		return new int[]{sum, minVal, maxVal};
	}
	
	public void Test(){
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[] intArr = new int[num];
		if(input.hasNext()){
			for(int i = 0; i < num; i++){
				intArr[i] = Integer.parseInt(input.next());
			}
		}
		input.close();
		
		int[] output = FindMaxSum(intArr, num);
		for(int i = 0; i < output.length; i++){
			System.out.print(output[i]);
			if(i != output.length - 1)
				System.out.print(" ");
		}
	}
}
