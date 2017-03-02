package DataStructureAndAlgorithm.Recursion;

/**
 * Created by 10183960 on 2017/3/2.
 */
public class HanoiTower {
    
    public static void move(int n, char fromTower, char toTower, char auxTower) {
        if (n == 1)
            System.out.println("move disk:" + n + " fromTower: " + fromTower + " to " + toTower);
        else {
            move(n - 1, fromTower, auxTower, toTower);
            System.out.println("move disk:" + n + " fromTower: " + fromTower + " to " + toTower);
            move(n - 1, auxTower, toTower, fromTower);
        }
    }

    public static void main(String[] args) {
        move(5, 'A', 'B', 'C');
    }
}
