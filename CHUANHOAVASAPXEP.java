package File;


import java.io.*;
import java.util.ArrayList;
import java.util.*;
class CHSX implements Comparable<CHSX> {
    private String hoTen;

    public CHSX( String hoTen){
        this.hoTen = hoTen;
    }
    public void chuanhoaTen(){
        String [] arr = hoTen.trim().split("\\s+");
        String res = "" ;
        for (String x : arr){
            res += Character.toUpperCase(x.charAt(0));
            for (int j = 1 ; j < x.length() ; j++ ){
                res += Character.toLowerCase(x.charAt(j));
            }
            res += " ";
        }
        hoTen = res.trim();
    }
    public String getHoTen() {
        String[] a = this.hoTen.trim().split("\\s+");
        String res = a[a.length - 1];
        for (int i = 0; i < a.length - 1; i++) {
            res += a[i];
        }
        return res;
    } // Mai Anh Duc -> Duc Mai Anh
    public int compareTo(CHSX o){
        return this.getHoTen().compareTo(o.getHoTen());
    }
    public String toString(){
        return this.hoTen;
    }
}

public class CHUANHOAVASAPXEP {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        List <CHSX> arr = new ArrayList<>();
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            CHSX a = new CHSX(s);
            a.chuanhoaTen();
            arr.add(a);
        }
        Collections.sort(arr);
        arr.forEach(u -> {
            System.out.println(u);
        });
    }
}
