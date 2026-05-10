import java.io.File;
import java.io.IOException;
import java.util.*;

class KH {
    private String maKh, tenKh, gioiTinh, ngaySinh, diaChi;

    public KH(int maKh, String tenKh, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKh = "KH" + String.format("%03d", maKh);
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

class MH {
    private String maMh, matHang, donviTinh;
    private long giaMua, giaBan;

    public MH(int maMh, String matHang, String donviTinh, long giaMua, long giaBan) {
        this.matHang = matHang;
        this.maMh = "MH" + String.format("%03d", maMh);
        this.donviTinh = donviTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getMaMh() {
        return maMh;
    }

    public String getMatHang() {
        return matHang;
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

class HD {
    private String maHD;
    private KH kh;
    private MH mh;
    private long soluong;

    public HD(int maHD, KH kh, MH mh, long soluong) {
        this.kh = kh;
        this.maHD = "HD" + String.format("%03d", maHD);
        this.mh = mh;
        this.soluong = soluong;
    }

    public long getThanhTien() {
        return this.soluong * this.mh.getGiaBan();
    }

    public String toString() {
        return this.maHD + " " + this.kh.getTenKh() + " " + this.kh.getDiaChi() + " " + this.mh.getMatHang() + " "
                + this.mh.getDonviTinh() + " " + this.mh.getGiaMua() + " " + this.mh.getGiaBan() + " " + this.soluong
                + " " + this.getThanhTien();
    }

}

public class BAITOANBANHANG {
    public static void main(String[] args) throws IOException {

        Scanner sc1 = new Scanner(new File("KH.in"));
        Scanner sc2 = new Scanner(new File("MH.in"));
        Scanner sc3 = new Scanner(new File("HD.in"));
        Map<String, KH> map = new HashMap<>();
        int n = sc1.nextInt();
        sc1.nextLine();
        for (int i = 1; i <= n; i++) {
            KH a = new KH(i, sc1.nextLine(), sc1.nextLine(), sc1.nextLine(), sc1.nextLine());
            map.put(a.getMaKh(), a);
        }
        Map<String, MH> mp = new HashMap<>();
        int m = sc2.nextInt();
        for (int i = 1; i <= m; i++) {
            sc2.nextLine();
            MH b = new MH(i, sc2.nextLine(), sc2.nextLine(), sc2.nextLong(), sc2.nextLong());
            mp.put(b.getMaMh(), b);
        }

        ArrayList<HD> arr = new ArrayList<>();
        int z = sc3.nextInt();
        for (int i = 1; i <= z; i++) {
            String maKH = sc3.next();
            String maMH = sc3.next();
            long soluong = sc3.nextLong();
            HD a = new HD(i, map.get(maKH), mp.get(maMH), soluong);
            arr.add(a);
        }
        for (HD x : arr) {
            System.out.println(x);
        }

    }

}
