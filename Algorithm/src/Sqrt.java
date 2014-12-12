
public class Sqrt {
	public static double precision = 0.000001;// we dont get the actual sqrt value, we get the one that between this precision.
	
	// constructor
	public Sqrt(){
	}
	
	// the main sqrt function using binary search
	public static double Cal(double input){
		if(input < 0) return -1;
		if(input == 0 || input == 1) return input;
		
		// the sqrt value shall be between 0 ~ input. we use 二分法 to search for the value;
		double min = 0;
		double max = input;
		if(input < 1) max = 1;
		
		double mid = 0;
		
		while(max - min > precision){
			mid = (min + max) / 2;
			if(mid * mid == input) return mid;
			else if(mid * mid < input) min = mid;
			else max = mid;
		}
		
		return (min + max) / 2;
	}
}
