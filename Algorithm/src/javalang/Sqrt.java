package javalang;

/*
 * 输入：double 类型的数字
 * 输出：该数的平方根
 * 原理：找出该数平方根的范围
 */
public class Sqrt implements Testable {
    // previously we used 0.000001, but we found this way can't make the right precision. So we try the invert value
    public static double precision = 1000000.0;// we dont get the actual sqrt value, we get the one that between this precision.

    // constructor
    public Sqrt() {
    }

    // the main sqrt function using binary search
    public static double Cal(double input) {
        if (input < 0) return -1;
        if (input == 0 || input == 1) return input;

        // the sqrt value shall be between 0 ~ input. we use 二分法 to search for the value;
        double min = 0;
        double max = input;
        if (input < 1) {
            min = input;
            max = 1;
        }

        double mid = 0;

        while (max - min > 1 / precision) {
            mid = (min + max) / 2;
            if (mid * mid == input) return mid;
            else if (mid * mid < input) min = mid;
            else max = mid;
        }

        long longResult = (long) ((max + min) / 2 * precision);
        return longResult / precision;
    }

    @Override
    public void test() {
        double input = 9;
        System.out.println(String.format("the sqrt of %s is: %s", input, Sqrt.Cal(input)));
    }
}
