package javalang;

/*
 * 水仙花
 */
public class Palindrome implements Testable {

    public static boolean IsPalindrome(String a) {
        if (a == null) return false;
        char[] charArr = a.toCharArray();
        for (int i = 0; i <= charArr.length / 2; i++) {
            if (charArr[i] != charArr[charArr.length - 1 - i]) return false;
        }
        return true;
    }

    @Override
    public void test() {
        String a = "abcddcba";
        System.out.println("If '" + a + "' this is a palindrome? " + IsPalindrome(a));
    }
}
