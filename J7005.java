package File;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.TreeMap;

public class J7005 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("DATA.IN");
        DataInputStream dis = new DataInputStream(fis);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= 100000; i++) {
            int x = dis.readInt();
            if(!map.containsKey(x)){
                map.put(x, 1);
            }else{
                map.put(x, map.get(x) + 1);
            }
        }
        map.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
    }
}
