/*
 对比ArrayList和LinkedList的性能
*/
public class CompareArrayListAndLinkedList {
  public stativ void main(String[] args) {
        //测试ArrayList
        List<Integer> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        System.out.println("ArrayList: " + String.valueOf(System.currentTimeMillis() - startTime));

        List<Integer> list1 = new LinkedList<>();
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            list1.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            list1.get(i);
        }
        System.out.println("LinkdedList: " + String.valueOf(System.currentTimeMillis() - startTime1));

        List<Integer> list2 = new ArrayList<>();
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            list2.add(0,i);
        }

        System.out.println("ArrayList: " + String.valueOf(System.currentTimeMillis() - startTime2));

        List<Integer> list3 = new LinkedList<>();
        long startTime3 = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            list3.add(0, i);
        }

        System.out.println("LinkdedList: " + String.valueOf(System.currentTimeMillis() - startTime3));
    }
}
