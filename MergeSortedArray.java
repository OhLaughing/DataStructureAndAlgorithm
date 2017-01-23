/*数组arr1和数组arr2都是已经排序的数组，该方法返回将数组arr1和arr2合并后的数组
*/
public class MergeSortedArray {
    public static int[] mergeSortArray(int[] arr1, int[] arr2) {
        int[] mergeArray = new int[arr1.length + arr2.length];
        int i = 0;         //index in arr1
        int j = 0;         //index in arr2
        int k = 0;         //index in mergeArray
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                mergeArray[k++] = arr1[i++];
            else
                mergeArray[k++] = arr2[j++];
        }
        while (i < arr1.length)
            mergeArray[k++] = arr1[i++];
        while (j < arr2.length)
            mergeArray[k++] = arr2[j++];
        return mergeArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 10, 14, 102};
        int[] merge = mergeSortArray(arr1, arr2);
        for (int i = 0; i < merge.length; i++) {
            System.out.print(merge[i] + " ");
        }
    }
}
