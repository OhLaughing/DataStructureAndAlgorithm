package DataStructureAndAlgorithm.Recursion;

/**
 * Created by 10183960 on 2017/3/1.
 */
public class BinarySearch {
    /**
     * 二分查找算法，
     *
     * @param list list必须是已经排好序的数组
     * @param key  要查找的值
     * @return
     */
    public static int binarySearch(int[] list, int key) {
        return binarySearch(list, key, 0, list.length - 1);
    }

    public static int binarySearch(int[] list, int key, int left, int right) {
        if (left > right)
            return -1;
        int middle = (left + right) / 2;
        if (list[middle] > key)
            return binarySearch(list, key, left, middle - 1);
        else if (list[middle] == key)
            return middle;
        else
            return binarySearch(list, key, middle + 1, right);
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        System.out.println(binarySearch(list, 6));
    }
}
