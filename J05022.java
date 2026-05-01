package File;
import java.util.*;
class SinhVien1{
    private String maSV, ten, lop, email;

    public SinhVien1(String maSV, String ten, String lop, String email) {
        this.maSV = maSV;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
    }

    public String toString(){
        return this.maSV + " " + this.ten + " " + this.lop + " " + this.email;
    }
    public String getLop(){
        return this.lop;
    }
}
public class J05022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        List <SinhVien1> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            SinhVien1 a = new SinhVien1(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            list.add(a);
        }
        int q = sc.nextInt(); sc.nextLine();
        for(int i = 1; i <= q; i++){
            String test = sc.nextLine().trim();
            System.out.println("DANH SACH SINH VIEN LOP " + test + ":");
            for(SinhVien1 a : list){
                if(a.getLop().equals(test)){
                    System.out.println(a);
                }
            }
        }
    }
}
