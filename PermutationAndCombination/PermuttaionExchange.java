package DataStructureAndAlgorithm.PermutationAndCombination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustaov on 2017/2/26.
 */
public class PermuttaionExchange {
    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        help(nums, 0);
        return result;
    }

    private void help(int[] nums, int i) {
        if (i == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                tmp.add(nums[j]);
            }
            result.add(tmp);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                help(nums, i + 1);
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        PermuttaionExchange solution = new PermuttaionExchange();
        System.out.println(solution.permute(a));
    }
}
