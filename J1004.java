package File;

import java.util.Scanner;

public class J1004 {
    public static boolean check(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
            for (int i = 1 ; i <= test ; i++){
                int n = sc.nextInt();
                if (check( n ))
                System.out.println("YES");
                else System.out.println("NO");
            }
        }

    }

