package File;

import java.util.Scanner;
class HANGHOA {
    private String maHang;
    private int soLuongNhap;

    public HANGHOA(String maHang, int soLuongNhap) {
        this.maHang = maHang;
        this.soLuongNhap = soLuongNhap;
    }

    public long soluongXuatHang() {
        char x = this.maHang.charAt(0);
        if (x == 'A')
            return Math.round(this.soLuongNhap * 0.6);
        else if (x == 'B') {
            return Math.round(this.soLuongNhap * 0.7);
        }
        return 0;
    }

    public long donGia(){
        char x = this.maHang.charAt(4);
        if (x == 'Y')
            return 110000;
        else if (x == 'N') {
            return 135000;
        }
        return 0;
    }

    public long Tien(){
        return this.soluongXuatHang() * this.donGia();
    }

    public long Thue() {
        long tien = Tien();
        char dau = maHang.charAt(0);
        char cuoi = maHang.charAt(maHang.length() - 1);

        if (dau == 'A' && cuoi == 'Y')
            return (tien * 8/100);
        else if (dau == 'A' && cuoi == 'N')
            return (tien* 11/100);
        else if (dau == 'B' && cuoi == 'Y')
            return (tien * 17/100);
        else
            return (tien * 22/100);
    }

    @Override
    public String toString(){
        return this.maHang + " " + this.soLuongNhap + " " + this.soluongXuatHang() + " " + this.donGia() + " " + this.Tien() + " " + this.Thue();
    }


}

public class BANGTHEODOIXUATNHAPHANG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n -- > 0 ){
            HANGHOA a = new HANGHOA(sc.nextLine() , sc.nextInt());
            sc.nextLine();
            System.out.println(a);
        }
    }
}
