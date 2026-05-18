
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class HINHTHUC implements Comparable<HINHTHUC> {
    private String maMon, tenMon, hinhThucLT, hinhThucTH;
    private int soTc;

    public HINHTHUC(String maMon, String tenMon, int soTc, String hinhThucLT, String hinhThucTH) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hinhThucLT = hinhThucLT;
        this.hinhThucTH = hinhThucTH;
        this.soTc = soTc;
    }
     public String getHinhThucTH(){
        return this.hinhThucTH;
   }
    public int compareTo(HINHTHUC other) {
        return this.maMon.compareTo(other.maMon);
    }

    @Override
    public String toString() {
        return this.maMon + " " + this.tenMon + " " + this.soTc + " " + this.hinhThucLT + " " + hinhThucTH;
    }
}

public class DANGKIHINHTHUCGIANGDAY {
    public static void main(String[] args) throws IOException {
        File file = new File("MONHOC.in");
        Scanner sc = new Scanner(file);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<HINHTHUC> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String maMon = sc.nextLine();
            String tenMon = sc.nextLine();
            int soTc = sc.nextInt();
            sc.nextLine();
            String hinhThucLT = sc.nextLine();
            String hinhThucTH = sc.nextLine();
            HINHTHUC a = new HINHTHUC(maMon, tenMon, soTc, hinhThucLT, hinhThucTH);
            if(a.getHinhThucTH().contains("Truc tuyen") || a.getHinhThucTH().contains(".ptit.edu.vn")){
                arr.add(a);
            }

        }
        Collections.sort(arr);
        for (HINHTHUC x : arr) {
            System.out.println(x);
        }

    }
}
