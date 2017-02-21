package DataStructureAndAlgorithm.PermutationAndCombination;

/**
 * Created by gustaov on 2017/2/21.
 */
public class Util {
    public static long getFactorial(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }

    public static int numOfCombination(int n, int m) {
        double result =1;
        int tmp = m;
        for (int i = 0; i < tmp; i++) {
            result = result*n;
            result = result/m;
            n--;m--;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println((int)numOfCombination(14,7));
    }
}