/*
 对比ArrayList和LinkedList的性能
*/
public class CompareArrayListAndLinkedList {

  public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        System.out.println("LinkedList: " + String.valueOf(System.currentTimeMillis() - startTime));

        List<Integer> list1 = new LinkedList<>();
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            list1.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            list1.get(i);
        }
        System.out.println("LinkdedList: " + String.valueOf(System.currentTimeMillis() - startTime1));
    }
}
