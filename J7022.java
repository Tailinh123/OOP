package File;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J7022 {
    static boolean check(String s){
        if(s.isEmpty() || s.length() >= 11) return false;
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        ArrayList <String> arr = new ArrayList<>();
        while(sc.hasNextLine()){
            String[] a = sc.nextLine().split("\\s+");
            for(String x : a){
                if(check(x) == false){
                    arr.add(x);
                }
            }
        }
        Collections.sort(arr);
        arr.forEach(u -> {
            System.out.print(u + " ");
        });
    }
}
