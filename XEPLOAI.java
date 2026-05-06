package File;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

class SV implements Comparable<SV>{
    private String maSv , hoTen ;
    private double diemLt , diemTh , diemThi;

    public SV(int maSv, String hoTen, double diemLt, double diemTh, double diemThi) {
        this.maSv = "SV" + String.format("%02d",maSv);
        this.hoTen = hoTen;
        this.diemLt = diemLt;
        this.diemTh = diemTh;
        this.diemThi = diemThi;
    }
    public void chuanhoahoTen(){
        String [] arr = hoTen.trim().split("\\s+");
        String res = " ";
        for (String x : arr ){
            res += Character.toUpperCase(x.charAt(0));
            for (int j = 1 ; j < x.length() ; j++){
                res += Character.toLowerCase(x.charAt(j));
            }
            res += " ";
        }
       this.hoTen = res.trim();
    }
    public double getDTK(){
        return (this.diemLt*0.25 + this.diemTh*0.35 + this.diemThi*0.4 )  ;
    }
    public String xepLoai() {
        if ( getDTK() >= 8 ) {
            return "GIOI";
        } else if (getDTK() >= 6.5 ) {
            return "KHA";
        } else if (getDTK() >=5) {
            return "TRUNG BINH";
        } else {
            return "KEM";
        }
    }
    public int compareTo(SV o){
        if (getDTK() < o.getDTK()) return 1;
        return -1;

    }
    @Override
    public String toString(){
        return maSv + " " + this.hoTen + " " + String.format("%.2f" , getDTK()) + " " + xepLoai();
    }
    public String getName(){
        return this.hoTen;
    }
}

public class XEPLOAI {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        //Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);
        int n = sc.nextInt();
        ArrayList<SV> arr = new ArrayList<>();
        for (int i = 1 ; i<= n ; i++){
            sc.nextLine();
            SV a = new SV(i , sc.nextLine().trim() , sc.nextDouble() , sc.nextDouble() , sc.nextDouble());
            a.chuanhoahoTen();
            arr.add(a);
        }
        Collections.sort(arr);
        for (SV x : arr){
            System.out.println(x);
        }

    }
}
