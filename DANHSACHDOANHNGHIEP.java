package File;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class DOANHNGHIEP implements Comparable<DOANHNGHIEP>{
    private String maDn , tenDn ;
    private long soSv;

    public DOANHNGHIEP(String maDn, String tenDn, long soSv) {
        this.maDn = maDn;
        this.tenDn = tenDn;
        this.soSv = soSv;
    }
    public int compareTo(DOANHNGHIEP o){
        return maDn.compareTo(o.maDn);
    }

    @Override
    public String toString(){
        return maDn + " " + tenDn + " " + soSv ;
    }
}



public class DANHSACHDOANHNGHIEP {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("DN.in"));
        ArrayList<DOANHNGHIEP> arr = new ArrayList<>();
        int n = sc.nextInt();

        for (int i = 1 ; i<= n ; i++){
            sc.nextLine();
            DOANHNGHIEP a = new DOANHNGHIEP(sc.nextLine(), sc.nextLine(),sc.nextLong());

            arr.add(a);
        }
        Collections.sort(arr);
        for (DOANHNGHIEP x :arr){
            System.out.println(x);
        }

    }
}