import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BANGDIEM implements Comparable<BANGDIEM>{
    private String maSV, hoTen, lop;
    private double diem1, diem2, diem3;

    public BANGDIEM(String maSV, String hoTen, String lop, double diem1, double diem2, double diem3) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    public int compareTo(BANGDIEM other) {
        return maSV.compareTo(other.maSV);
    }
    @Override
    public String toString(){
        return this.maSV + " " + this.hoTen + " " + this.lop + " " + String.format("%.1f", this.diem1) + " " + String.format("%.1f",this.diem2) + " " + String.format("%.1f",this.diem3);
    }
}

public class BANGDIEMTHANHPHAN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        sc.useLocale(Locale.UK);
        int n = sc.nextInt();

        ArrayList<BANGDIEM> arr = new ArrayList<>();
        for ( int i = 1 ; i <=n ; i++){
            sc.nextLine();
            BANGDIEM a = new BANGDIEM(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
            arr.add(a);
        }
        int stt = 1;

        Collections.sort(arr);
        for (BANGDIEM x : arr){
            System.out.println(stt + " " + x);
            stt++;
        }

    }
}
