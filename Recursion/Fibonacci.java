package DataStructureAndAlgorithm.Recursion;

/**
 * Created by 10183960 on 2017/2/28.
 */
public class Fibonacci {
    /**
     * 递归实现
     * @param x
     * @return
     */
    public static int myFibonacci(int x) {
        if (x < 1)
            return 0;
        else if (x < 2)
            return 1;
        else return myFibonacci(x - 1) + myFibonacci(x - 2);
    }

    public static int fibonacci(int x) {
        if (x < 1)
            return 0;
        else if (x < 2)
            return 1;
        else {
            int a = 0;
            int b =1;
            int c = a+b;
            for (int i = 2; i < x; i++) {
                a = b;
                b = c;
                c = a+b;
            }
            return c;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(myFibonacci(45));
        System.out.println(System.currentTimeMillis() - start);
        long start1 = System.currentTimeMillis();
        System.out.println(fibonacci(45));
        System.out.println(System.currentTimeMillis() - start1);
    }
}

/**
 * result:
 1134903170
 5735
 1134903170
 0
 */
