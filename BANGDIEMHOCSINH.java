import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;
class BANGDIEM1 implements Comparable<BANGDIEM1>{
    private String maHs , hoTen;
    private double toan , tiengViet , ngoaiNgu , vatLy , hoaHoc , sinhHoc , lichSu , diaLy , gdcd , cN;

    public BANGDIEM1(int maHs ,String hoTen, double toan, double tiengViet, double ngoaiNgu, double vatLy, double hoaHoc, double sinhHoc, double lichSu, double diaLy, double gdcd, double cN) {
        this.hoTen = hoTen;
        this.maHs = "HS" + String.format("%02d" , maHs);
        this.toan = toan;
        this.tiengViet = tiengViet;
        this.ngoaiNgu = ngoaiNgu;
        this.vatLy = vatLy;
        this.hoaHoc = hoaHoc;
        this.sinhHoc = sinhHoc;
        this.lichSu = lichSu;
        this.diaLy = diaLy;
        this.gdcd = gdcd;
        this.cN = cN;
    }

    public double getDiemTb(){
        return ((2 * toan + 2 * tiengViet + ngoaiNgu + vatLy + hoaHoc + sinhHoc + lichSu + diaLy + gdcd + cN) / 12.0) ;
    }


    public String xepLoai(){
        if (getDiemTb() >= 9 )
            return "XUAT SAC";
        else if (getDiemTb() >= 8) {
            return  "GIOI";
        } else if (getDiemTb() >= 7) {
            return "KHA";

        } else if (getDiemTb() >=5) {
            return "TB";
        } else return "YEU";
    }

    public int compareTo(BANGDIEM1 o){
        if (getDiemTb() == o.getDiemTb() ) return maHs.compareTo(o.maHs);
        else if (this.getDiemTb() > o.getDiemTb() )  return -1;
        else return 1;
        }

        @Override
    public String toString(){
        return maHs + " " + this.hoTen + " " + String.format("%.1f", Math.round(this.getDiemTb() * 10.0) / 10.0) + " " + xepLoai();
    }
}

public class BANGDIEMHOCSINH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);
        ArrayList<BANGDIEM1> arr = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 1 ; i <= n ; i ++){
            sc.nextLine();
            BANGDIEM1 a = new BANGDIEM1(i , sc.nextLine().trim() , sc.nextDouble() ,sc.nextDouble(), sc.nextDouble() , sc.nextDouble(), sc.nextDouble() , sc.nextDouble() , sc.nextDouble() , sc.nextDouble() , sc.nextDouble() , sc.nextDouble());
            arr.add(a);
        }
        Collections.sort(arr);
        for (BANGDIEM1 x : arr){
            System.out.println(x);
        }
    }
}
