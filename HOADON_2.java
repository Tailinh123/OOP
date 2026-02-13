import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class KHACHHANG2 {
    private final String maKh;
    private final String tenKh;
    private final String gioiTinh;
    private final String ngaySinh;
    private final String diaChi;

    public KHACHHANG2(int maKh, String tenKh, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKh = "KH" + String.format("%03d",maKh);
        this.tenKh = tenKh;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getMaKh() {
        return maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }
}
class MATHANG2{
    private final String maMh;
    private final String tenMh;
    private final String donviTinh ;
    private final long giaMua;
    private final long giaBan;

    public MATHANG2(int maMh, String tenMh, String donviTinh, long giaMua, long giaBan) {
        this.maMh = "MH" + String.format("%03d" , maMh);
        this.tenMh = tenMh;
        this.donviTinh = donviTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getMaMh() {
        return maMh;
    }

    public String getTenMh() {
        return tenMh;
    }

    public String getDonviTinh() {
        return donviTinh;
    }

    public long getGiaMua() {
        return giaMua;
    }

    public long getGiaBan() {
        return giaBan;
    }
}

class HOADONSO2{
    private final String maHd ;
    private final KHACHHANG2 khachhang2;
    private final MATHANG2 mathang2;
    private final long soLuong;

    public HOADONSO2(int maHd, KHACHHANG2 khachhang2,MATHANG2 mathang2, long soLuong) {
        this.maHd = "HD"+ String.format("%03d",maHd);
        this.khachhang2 = khachhang2;
        this.mathang2 = mathang2;
        this.soLuong = soLuong;
    }

    public long getThanhTien(){
        return this.soLuong * this.mathang2.getGiaBan();
    }

    @Override
    public String toString(){
        return this.maHd + " " + this.khachhang2.getTenKh() + " " + this.khachhang2.getDiaChi() + " " + this.mathang2.getTenMh() +" "+this.mathang2.getDonviTinh()+" "+this.mathang2.getGiaMua()+" " + this.mathang2.getGiaBan() + " " + this.soLuong + " " + this.getThanhTien();
     }
}


public class HOADON_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("KH.in"));
        Scanner sc2 = new Scanner(new File("MH.in"));
        Scanner sc3 = new Scanner(new File("HD.in"));

        Map<String , KHACHHANG2> map = new HashMap<>();
        int n = sc1.nextInt();
        sc1.nextLine();
        for (int i = 1 ; i <= n ; i++){
            KHACHHANG2 a = new KHACHHANG2(i , sc1.nextLine().trim() , sc1.nextLine().trim() , sc1.nextLine().trim() , sc1.nextLine());
            map.put(a.getMaKh() , a);
        }

        Map<String , MATHANG2> mp = new HashMap<>();
        int m = sc2.nextInt();
        sc2.nextLine();
        for (int i = 1 ; i <= m ;i++){
            MATHANG2 a = new MATHANG2(i , sc2.nextLine().trim() , sc2.nextLine().trim() , sc2.nextLong() , sc2.nextLong());
            sc2.nextLine();
            mp.put(a.getMaMh() , a);
        }
        ArrayList<HOADONSO2> arr = new ArrayList<>();
        int k = sc3.nextInt();
        for (int i = 1 ; i<=k ; i++){
            String maKh = sc3.next();
            String maMh = sc3.next();
            long soLuong = sc3.nextLong();
            HOADONSO2 a = new HOADONSO2(i , map.get(maKh) , mp.get(maMh) , soLuong);
            arr.add(a);
        }

        for (HOADONSO2 x : arr){
            System.out.println(x);
        }
    }
}
