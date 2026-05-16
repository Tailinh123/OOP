package File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CHUANHOAXAUHOTEN_2 {
    public static String chuanHoa(String s){
        String[] arr = s.trim().split("\\s+");
        String res ="";
        for (String x : arr){
            res += Character.toUpperCase(x.charAt(0));
            for (int j = 1 ;  j <= x.length() ; j ++){
                res += Character.toLowerCase(x.charAt(j));
            }
            res += " ";
        }
        return s.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Integer> arr = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            arr.add(sc.nextInt());
        }
        Collections.sort(arr, new Comparator<Integer>(){
            public int compare(Integer a, Integer o){
                if(a > o) return -1;
                return 1;
            }
        });
        arr.forEach(u -> {
            System.out.println(u);
        });
    }
}
