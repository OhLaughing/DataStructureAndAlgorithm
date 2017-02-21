package DataStructureAndAlgorithm.PermutationAndCombination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustaov on 2017/2/21.
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteDFS(nums, 0, visited, out, result);
        return result;
    }

    void permuteDFS(int[] nums, int level, boolean[] visited, List<Integer> out, List<List<Integer>> result) {
        if (level == nums.length) {
            List<Integer> temp = new ArrayList<Integer>(out);
            result.add(temp);
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == false) {
                    visited[i] = true;
                    out.add(nums[i]);
                    permuteDFS(nums, level + 1, visited, out, result);
                    out.remove(level);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[]a = {1,2,3};
        Permutation permutation = new Permutation();
        System.out.println(permutation.permute(a));
        List<Integer> temp = new ArrayList<Integer>();
    }
}
