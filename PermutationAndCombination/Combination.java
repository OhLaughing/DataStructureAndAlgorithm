package DataStructureAndAlgorithm.PermutationAndCombination;

import java.util.Arrays;

/**
 * Created by gustaov on 2017/2/21.
 */
public class Combination {
    public static int[][] getMFromN(int n, int m) {
        int numOfCombination = Util.numOfCombination(n, m);
        int[][] result = new int[numOfCombination][n];
        int[] first = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < m)
                first[i] = 1;
            else
                first[i] = 0;
        }
        result[0] = first;
        int pos = 0;  //each time find 10, pos is the position of 1
        int numOf1 = 0;  //recode the number of 1
        for (int i = 1; i < numOfCombination; i++) {

            int[] cur = Arrays.copyOf(result[i - 1], n);

            for (int j = 0; j < n - 1; j++) {
                if (cur[j] == 1 && cur[j + 1] == 0) {
                    cur[j] = 0;
                    cur[j + 1] = 1;
                    pos = j;         // recode the position of 1
                    break;
                }
            }
            // already find 10 and modity it to 01
            // next task is to rearrange left part of pos, make sure 1 to the left and 0 to the right
            numOf1 = 0;

            for (int j = 0; j < pos; j++)
            {
                if (cur[j] == 1)
                    numOf1++;
            }
            for (int j = 0; j < pos; j++) {
                if (j < numOf1)
                    cur[j] = 1;
                else cur[j] = 0;
            }

            result[i] = cur;

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = getMFromN(6, 3);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
