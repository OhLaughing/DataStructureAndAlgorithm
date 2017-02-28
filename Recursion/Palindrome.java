package DataStructureAndAlgorithm.Recursion;

/**
 * Created by 10183960 on 2017/2/28.
 */
public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        else return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
    }

    /**
     * isPalindrome方法每次都要重新创建新的字符串，因此不够高效，isPalindrome1避免了这个问题
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s) {
        return palindromeHelper(s, 0, s.length() - 1);
    }

    private static boolean palindromeHelper(String s, int left, int right) {
        if (right <= left)
            return true;
        return s.charAt(left) == s.charAt(right) && palindromeHelper(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome1("noon"));
        System.out.println(isPalindrome1("noom"));
        System.out.println(isPalindrome1("ab"));
        System.out.println(isPalindrome1("aba"));
    }
}
