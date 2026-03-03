package File;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class DANHSACHSINHVIEN implements Comparable<DANHSACHSINHVIEN>{
    private String maSv , hoTen , sdt , email;

    public DANHSACHSINHVIEN(String maSv, String hoTen, String sdt, String email) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.email = email;
    }
    public String chuanHoa() {
        String[] a = this.hoTen.trim().split("\\s+");
        String res = a[a.length - 1];
        for(int i = 0; i < a.length - 1; i++){
            res += a[i];
        }
        return res;
    }
    public int compareTo(DANHSACHSINHVIEN other){
        if (this.chuanHoa().equals(other.chuanHoa())){
            return this.maSv.compareTo(other.maSv);
        }
        return this.chuanHoa().compareTo(other.chuanHoa());
    }
    @Override
    public String toString(){
        return maSv + " " + hoTen + " " + sdt + " " + email ;
    }
}

public class SAPXEPDANHSACHSINHVIEN {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<DANHSACHSINHVIEN> arr = new ArrayList<>();
        for (int i = 1 ; i <= n ; i ++){
            DANHSACHSINHVIEN a = new DANHSACHSINHVIEN(sc.nextLine() , sc.nextLine(), sc.nextLine() , sc.nextLine());
            arr.add(a);
        }
        Collections.sort(arr);
        for (DANHSACHSINHVIEN x : arr){
            System.out.println(x.chuanHoa());
        }

    }
}
