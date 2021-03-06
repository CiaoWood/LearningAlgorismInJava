package javalang;

/*
 * 输入：小数
 * 输出：分数
 * 原理：把小数乘以10的某次方使之成为整形数，然后再找到该数字和底数的最大公约数。例如：0.4 = 4 / 10 ， 4 和 10 的最大公约数是 2,故结果是2/5
 */
public class ConvertRational implements Testable {

    @Override
    public void test() {
        System.out.println(GetRational(0.125));
        System.out.println(GetRational(-0.125));
        System.out.println(GetRational(22.125));
        System.out.println(GetRational(-22.125));
        System.out.println(GetRational(0));
        System.out.println(GetRational(1));
    }

    // the header function
    private String GetRational(double v) {

        if (v == 0) return v + " = 0/1";

        // first, we need to find the multiplier to make v to be an integer
        int poly = 1;
        while (v * poly - (int) (v * poly) != 0)
            poly *= 10;

        // now, we get the upper and lower value;
        int upper = (int) (v * poly);
        int lower = poly;

        // then, we get the gcd of upper and lower
        int gcd = 0;
        if (upper > lower) gcd = GCD(lower, upper);
        else if (upper < lower) gcd = GCD(upper, lower);
        else return v + " = 1/1";

        // now, use gcd to optimize upper and lower
        upper /= gcd;
        lower /= gcd;

        // if lower < 0, we need to move negative value to front
        if (lower < 0)
            return v + " = -" + upper + "/" + (0 - lower);
        else
            return v + " = " + upper + "/" + lower;

    }

    // we assue large is larger than small
    private int GCD(int small, int large) {

        assert (small <= large);

        int remainder = large % small;

        if (remainder == 0)
            return small;
        else
            return GCD(remainder, small);
    }

}
