package DataStructureAndAlgorithm.Recursion;

/**
 * Created by 10183960 on 2017/2/28.
 */
public class Palindrome {
    
    public static boolean isPalindrome(String s) {
        if(s.length()<=1)
            return true;
        else return s.charAt(0)==s.charAt(s.length()-1) && isPalindrome(s.substring(1,s.length()-1));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("noon"));
        System.out.println(isPalindrome("noom"));
        System.out.println(isPalindrome("ab"));
        System.out.println(isPalindrome("aba"));
    }
}
