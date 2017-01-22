
public class BubbleSort {
	public static void bubbleSort(int[] list) {
		boolean needNextPass = true;
		
		for(int k=1;k<list.length && needNextPass;k++) {
			needNextPass = false;
			for(int i=0;i<list.length-k;i++ ) {
				if(list[i]>list[i+1]) {
					int temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
					needNextPass = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] list = {3,45,6,7,2,34,5,7,8,97,55,7,8,99,56,54,45668,224};
		bubbleSort(list);
		for(int i=0;i<list.length;i++)
		System.out.print(list[i] + " ");
	}
}
