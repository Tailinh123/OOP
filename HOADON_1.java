package File;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class QUANAO1{
    private String maloai , tenSp ;
    private long giaLoai1 , gialoai2;

    public QUANAO1(String maloai, String tenSp, long giaLoai1, long gialoai2) {
        this.maloai = maloai;
        this.tenSp = tenSp;
        this.giaLoai1 = giaLoai1;
        this.gialoai2 = gialoai2;
    }

    public String getMaloai() {
        return maloai;
    }

    public String getTenSp() {
        return tenSp;
    }

    public long getGiaLoai1() {
        return giaLoai1;
    }

    public long getGialoai2() {
        return gialoai2;
    }
}

class HOADON2{
    private QUANAO1 QUANAO1;
    private String maHd ;
    private long soLuong;

    public HOADON2(int i ,String maHd, QUANAO1 QUANAO1, long soLuong) {
        this.maHd = maHd + "-" + String.format("%03d",i) ;
        this.QUANAO1 = QUANAO1;
        this.soLuong = soLuong;
    }

    public long getGiaBan(){
        int x = maHd.charAt(2) -'0';
        if (x == 1 ) return QUANAO1.getGiaLoai1();
        else return QUANAO1.getGialoai2();
    }

    public long getGiamGia(){
        long x = this.getGiaBan() * this.soLuong;
        if (this.soLuong >= 150 ) return x/2;
        else if (this.soLuong >= 100 ) return x *3/10;
        else if (soLuong >= 50) return x * 15 /100;
        else return 0;
    }

    public long getTienTra(){
        return (this.getGiaBan() * this.soLuong) - this.getGiamGia();
    }


    @Override
    public String toString(){
        return this.maHd + " " + this.QUANAO1.getTenSp() + " " + this.getGiamGia() + " " + this.getTienTra();
    }


}

public class HOADON_1 {
    public static void main(String[] args) throws IOException {
        Scanner sc1 = new Scanner(new File("DATA1.in"));
        Scanner sc2 = new Scanner(new File("DATA2.in"));
        int n = sc1.nextInt();
        sc1.nextLine();
        Map< String, QUANAO1 > map = new HashMap();
        for (int i = 1 ; i <= n ; i++){
            QUANAO1 a = new QUANAO1(sc1.nextLine() , sc1.nextLine() , sc1.nextLong(), sc1.nextLong());
            sc1.nextLine();
            map.put(a.getMaloai() , a);
        }
        ArrayList<HOADON2> arr = new ArrayList<>();
        int m = sc2.nextInt();
        for (int i = 1 ; i <= m ; i++){
            String maHd = sc2.next();
            String maLoai = maHd.substring(0,2);
            long soLuong = sc2.nextLong();
            HOADON2 a = new HOADON2(i , maHd , map.get(maLoai) , soLuong);
            arr.add(a);
            }
        for (HOADON2 x : arr){
            System.out.println(x);
        }



    }
}
