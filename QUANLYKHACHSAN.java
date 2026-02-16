package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class KHACHSAN {
    private String kiHieu, loaiPhong;
    private double dongiaNgay;
    private double phiPhucVu;

    public KHACHSAN(String kiHieu, String loaiPhong, double dongiaNgay, double phiPhucVu) {
        this.kiHieu = kiHieu;
        this.loaiPhong = loaiPhong;
        this.dongiaNgay = dongiaNgay;
        this.phiPhucVu = phiPhucVu;
    }

    public String getKiHieu() {
        return kiHieu;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public double getDongiaNgay() {
        return dongiaNgay;
    }

    public double getPhiPhucVu() {
        return phiPhucVu;
    }
}
class LUUTRU implements Comparable<LUUTRU>{
    private String maKh , hoTen , maPhong , ngayDen , ngayDi;
    private KHACHSAN khachsan;

    public LUUTRU(int maKh,KHACHSAN khachsan, String hoTen, String maPhong, String ngayDen, String ngayDi) {
        this.maKh = "KH" + String.format("%02d",maKh);
        this.khachsan = khachsan;
        this.hoTen = hoTen;
        this.maPhong = maPhong;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
    }

    public long getngayLuuTru(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate a = LocalDate.parse(ngayDen , formatter);
        LocalDate b = LocalDate.parse(ngayDi, formatter);
        long days = ChronoUnit.DAYS.between(a , b ) ;
        return days;
    }
    public double tienPhaiTra(){
        double a = this.getngayLuuTru();
        if(a == 0) a = 1;
        double temp = a * this.khachsan.getDongiaNgay();
        if(a > 30) return temp * 0.94 * (1 + this.khachsan.getPhiPhucVu());
        else if(a >= 20) return temp * 0.96 * (1 + this.khachsan.getPhiPhucVu());
        else if(a >= 10) return temp * 0.98 * (1 + this.khachsan.getPhiPhucVu());
        return temp * (1 + this.khachsan.getPhiPhucVu());
    }
    @Override
    public String toString(){
        return maKh + " " + this.hoTen + " " + this.maPhong + " " + this.getngayLuuTru() + " " + String.format("%.2f", this.tienPhaiTra());
    }
    public int compareTo(LUUTRU o){
        if(this.getngayLuuTru() > o.getngayLuuTru()) return -1;
        return 1;
    }
}
public class QUANLYKHACHSAN {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        //Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);
        Map<String , KHACHSAN> map = new HashMap<>();
        int n = sc.nextInt(); sc.nextLine();
        for (int i = 1 ; i<= n ; i++){
            String[] a = sc.nextLine().split("\\s+");
            KHACHSAN b = new KHACHSAN(a[0], a[1], Double.parseDouble(a[2]), Double.parseDouble(a[3]));
            map.put(b.getKiHieu() , b);
        }
        ArrayList<LUUTRU> arr = new ArrayList<>();
        int m = sc.nextInt(); sc.nextLine();
        for (int i = 1 ; i<= m ; i++){
            String hoTen = sc.nextLine().trim();
            String maPhong = sc.nextLine().trim();
            String ngayDen = sc.nextLine().trim();
            String ngayDi = sc.nextLine().trim();
            String ma = "" +maPhong.charAt(2);

            LUUTRU a = new LUUTRU(i , map.get(ma), hoTen, maPhong, ngayDen , ngayDi);
            arr.add(a);
        }
        Collections.sort(arr);
        for (LUUTRU x : arr){
            System.out.println(x);
        }
    }
}
