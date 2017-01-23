public class MergeSortedArray {
    public static int[] mergeSortArray(int[] arr1, int[] arr2) {
        int[] mergeArray = new int[arr1.length + arr2.length];
        int i;         //arr1
        int j;         //arr2
        int k = 0;     //mergeArray
        for (i = 0, j = 0; i < arr1.length && j < arr2.length; ) {
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
