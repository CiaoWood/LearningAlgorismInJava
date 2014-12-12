import java.util.ArrayList;

//
// given a sorted array arr and a number sumToFind, find the two numbers in array that can added up to sumToFind. There can be duplicated value in the array.
// E.g. arr = {1,2,2,3,4,5,7,8,13,23} , sumToFind = 5 Output: {0,4},{1,3},{2,3}
//
public class FindSum implements Testable {

	private class SumPair{
		public SumPair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int a;
		public int b;
	}
	
	@Override
	public void Test() {
		int[] arr = {1,2,2,3,4,5,7,8,13,23};
		int sumToFind = 23;
		ArrayList<SumPair> results= FindSumPack(arr, sumToFind);
		if(results != null && results.size() > 0){
			for(SumPair sp : results){
				System.out.println("index of " + sp.a + " value is " + arr[sp.a] + ", index of " + sp.b + " value is " + arr[sp.b] + " add up to " + sumToFind);
			}
		}else{
			System.out.println("Can't find any combination that can added up to " + sumToFind);
		}
		
	}

	// we assume that the arr is sorted
	private ArrayList<SumPair> FindSumPack(int[] arr, int sumToFind) {
		if(arr[0] >= sumToFind) return null;
		
		int b = 0;
		int[] temp = null;
		ArrayList<SumPair> results = new ArrayList<SumPair>();
		for(int i = 0; arr[i] < sumToFind; i++){
			b = sumToFind - arr[i];
			temp = BinSearch.GetRange(arr, i + 1, arr.length - 1, b);
			if(temp != null){
				for(int j : temp){
					results.add(new SumPair(i,j));
				}
			}
		}
		return results;
	}

}
