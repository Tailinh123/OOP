package File;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
class XAUHOTEN {
    private String hoTen;

    public XAUHOTEN(String hoTen) {
        this.hoTen = hoTen;
    }

    public void chuanhoaHoten() {
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

    @Override
    public String toString() {
        return hoTen;
    }
}

public class CHUANHOAHOTENTRONGFILE {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));

        while (true) {
            String s = sc.nextLine();
            if (s.equals("END")) break;

            XAUHOTEN a = new XAUHOTEN(s);
            a.chuanhoaHoten();
            System.out.println(a);
        }
    }
}
