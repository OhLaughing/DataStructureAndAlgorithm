public class MergeSort {
    public static void mergeSort(int[] array) {
        if(array.length < 2)
            return;
        int[] firstHarf = new int[array.length / 2];
        int[] secondHarf = new int[array.length - array.length / 2];

        System.arraycopy(array, 0, firstHarf, 0, array.length / 2);
        System.arraycopy(array, array.length / 2, secondHarf, 0, array.length - array.length / 2);
        mergeSort(firstHarf);
        mergeSort(secondHarf);
        int[] tmp = MergeSortedArray.mergeSortArray(firstHarf, secondHarf);
        System.arraycopy(tmp, 0, array, 0, array.length);
    }

    public static void main(String[] args) {
        int[] array = {34,56,2,5,8,24,435,23,22,86};
        mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
