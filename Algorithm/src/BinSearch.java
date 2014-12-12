import java.util.Arrays;


public class BinSearch {

	public static void Test() {
		int[] A = new int[]{2,2,2,3,4,5,5,5,5,6,6,6,7,8,8,8,8,9};
		int[] B = GetRange(A,6);
		if(B != null){
			for(int i = 0; i < B.length; i++){
				System.out.print(B[i]);
				if(i != B.length - 1){
					System.out.println(" ");
				}
			}
		}else{
			System.out.println("Can't get the value");
		}
	}

	

	public static int[] SearchRange(int[] a, int target) {
        int[] leftRightIdx = new int[2];
		int left = 0;
		int right = a.length - 1;
        int mid = 0;
		while(true){
			mid = (left + right) / 2;
			if(a[mid] < target){
				left = mid;
			}else if(a[mid] > target){
				right = mid;
			}else{
				int m = mid;
				int l = 0;
				while(m != left){
					l = (m + left) / 2;
					if(a[l] != target){
						left = l;
					}else{
						m = l;
					}	
				}
				int r = 0;
				m = mid;
				while(m != right){
					l = (m + right + 1) / 2;
					if(a[l] != target){
						right = l;
					}else{
						m = l;
					}	
				}
				leftRightIdx[0] = left;
				leftRightIdx[1] = right;
		        return leftRightIdx;
			}
			if(mid == left || mid == right) break;
		}
		return null;
    }
	
	public static int SearchLeft(int[] a, int start, int end, int tar){
		// pre process
		if(start > end) return -1;
		if(a[start] == tar) return start;
		else if(a[start] > tar) return -1;
		if(a[end] < tar) return -1;
		
		// binary search
		int mid = (start + end) / 2;
		int temp = 0;
		if(a[mid] == tar){
			temp = SearchLeft(a, start, mid - 1, tar);
			if(temp < mid && temp != -1)
				return temp;
			else
				return mid;
		}else if(a[mid] < tar){
			return SearchLeft(a, mid + 1, end, tar);
		}else
			return SearchLeft(a, start, mid - 1, tar);
	}
	
	public static int SearchRight(int[] a, int start, int end, int tar){
		// pre process
		if(start > end) return -1;
		if(a[end] == tar) return end;
		else if(a[end] < tar) return -1;
		if(a[start] > tar) return -1;
		
		// binary search
		int mid = (start + end) / 2;
		int temp = 0;
		if(a[mid] == tar){
			temp = SearchRight(a, mid + 1, end, tar);
			if(temp > mid && temp != -1)
				return temp;
			else
				return mid;
		}else if(a[mid] < tar){
			return SearchRight(a, mid + 1, end, tar);
		}else
			return SearchRight(a, start, mid - 1, tar);
	}
	
	public static int[] GetRange(int[] a, int tar){
		int l = SearchLeft(a, 0, a.length - 1, tar);
		int r = SearchRight(a, 0, a.length - 1, tar);
		
		if(l < r) return new int[]{l,r};
		else if(l == r) return new int[]{l};
		else return null;
	}
	public static int[] GetRange(int[] a, int start, int end, int tar){
		int l = SearchLeft(a, start, end, tar);
		int r = SearchRight(a, start, end, tar);
		
		if(l < r) return new int[]{l,r};
		else if(l == r && l != -1) return new int[]{l};
		else return null;
	}
}
