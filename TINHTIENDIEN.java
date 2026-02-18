package File;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

class TIENDIEN implements Comparable<TIENDIEN>{
    private String maKh, hoTen, loaiHo;
    private int chisoDau, chisoCuoi;

    public TIENDIEN(int maKh, String hoTen, String loaiHo,int chisoDau, int chisoCuoi) {
        this.maKh = "KH" + String.format("%02d", maKh);
        this.hoTen = hoTen;
        this.loaiHo = loaiHo;
        this.chisoDau = chisoDau;
        this.chisoCuoi = chisoCuoi;
    }

    public void chuanhoahoTen() {
        String[] arr = hoTen.trim().split("\\s+");
        String name = "";
        for (String x : arr) {
            name += Character.toUpperCase(x.charAt(0));
            for (int j = 1; j < x.length(); j++) {
                name += Character.toLowerCase(x.charAt(j));
            }
            name += " ";
        }
        this.hoTen = name.trim();
    }

    public int getSoDien() {
        return this.chisoCuoi - this.chisoDau;
    }

    public int getDinhMuc() {
        if (loaiHo.equals("A")) return 100;
        if (loaiHo.equals("B")) return 500;
        return 200;
    }

    public int tientrongDinhMuc(){
        return Math.min(getSoDien() , getDinhMuc() ) * 450;
    }

    public int tienngoaiDinhMuc(){
        if(this.getSoDien() > getDinhMuc())
            return (getSoDien() - getDinhMuc()) * 1000;
        return 0;
    }

    public int sotienPhaiNop(){
        return (int)Math.round( this.tientrongDinhMuc() + (this.tienngoaiDinhMuc() * 1.05)) ;
    }

    public int compareTo(TIENDIEN o){
        if (this.sotienPhaiNop() < o.sotienPhaiNop() ) return 1;
        return -1;
    }

    @Override
    public String toString(){
        return this.maKh + " " + this.hoTen + " " + this.tientrongDinhMuc() + " " + this.tienngoaiDinhMuc() + " " + this.tienngoaiDinhMuc() /20 + " " + this.sotienPhaiNop();
    }
}


public class TINHTIENDIEN {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        //sc.useLocale(Locale.UK);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<TIENDIEN> arr = new ArrayList<>();
        for (int i = 1 ; i <= n ; i++){

            String hoTen = sc.nextLine().trim();
            String loaiHo = sc.next().trim();
            int chisoDau =sc.nextInt();
            int chisoCuoi = sc.nextInt();
            sc.nextLine();

            TIENDIEN a = new TIENDIEN( i , hoTen , loaiHo , chisoDau , chisoCuoi);
            a.chuanhoahoTen();
            arr.add(a);
        }
        Collections.sort(arr);
        for (TIENDIEN x : arr){
            System.out.println(x);
        }

    }
}
