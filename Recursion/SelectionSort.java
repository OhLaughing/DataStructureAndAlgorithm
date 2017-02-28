package DataStructureAndAlgorithm.Recursion;

/**
 * Created by 10183960 on 2017/2/28.
 */
public class SelectionSort {
    public static void sort(double[] list) {
        sort(list, 0, list.length - 1);
    }

    private static void sort(double[] list, int left, int right) {
        if (left < right) {
            double min = list[left];
            int indexMin = left;
            for (int i = left; i <= right; i++) {
                if (list[i] < min) {
                    min = list[i];
                    indexMin = i;
                }
            }
            list[indexMin] = list[left];
            list[left] = min;

            sort(list, left + 1, right);
        }
    }

    public static void main(String[] args) {
        double[] a = {5,4,3,2,1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
