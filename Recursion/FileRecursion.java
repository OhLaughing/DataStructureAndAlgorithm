package DataStructureAndAlgorithm.Recursion;

import java.io.File;

/**
 * Created by 10183960 on 2017/3/1.
 */
public class FileRecursion {
    public static long getSize(File file) {
        long size =0;
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                size+=getSize(files[i]);
            }
        }else {
            size +=file.length();
        }
        return size;
    }

    public static void main(String[] args) {
        File file = new File("d://12");
        System.out.println(getSize(file));
    }
}
