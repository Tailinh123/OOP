import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class KHTF implements Comparable<KHTF>{
    private String maKh , tenKh , gioiTinh , ngaySinh , diaChi;

    public KHTF(int maKh, String tenKh, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKh = "KH" + String.format("%03d",maKh);
        this.tenKh = tenKh;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public void chuanhoTen(){
        String[] arr = tenKh.trim().split("\\s+");
        String res ="";
        for (String x : arr){
            res += Character.toUpperCase(x.charAt(0));
            for (int j = 1 ; j < x.length() ; j ++){
                res += Character.toLowerCase(x.charAt(j));
            }
            res += " ";
        }
        this.tenKh = res.trim();
    }

    public void chuanngaySinh(){
        StringBuilder sb = new StringBuilder(this.ngaySinh);
        if (sb.charAt(2) != '/') sb.insert(0 , "0");
        if (sb.charAt(5) != '/') sb.insert(3 ,"0");

        this.ngaySinh = sb.toString();
    }

    public long getngay(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate a = LocalDate.parse(ngaySinh , formatter);
        LocalDate b = LocalDate.now();

        return ChronoUnit.DAYS.between(a , b);
    }

    public int compareTo(KHTF o){
        if (getngay() > o.getngay()) return -1;
        else return 1;
    }

    @Override
    public String toString(){
        return this.maKh + " " +  this.tenKh+" " + this.gioiTinh + " " + this.diaChi +  " " + this.ngaySinh;
    }
}

public class J7025 {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        ArrayList<KHTF> arr = new ArrayList<>();
        int n = sc.nextInt();sc.nextLine();
        for (int i = 1 ; i<= n ; i++){
            KHTF a = new KHTF(i , sc.nextLine().trim() , sc.nextLine() , sc.nextLine() , sc.nextLine());
            a.chuanhoTen();
            a.chuanngaySinh();
            arr.add(a);
        }
        Collections.sort(arr);
        for (KHTF x : arr){
            System.out.println(x);
        }
    }
}
