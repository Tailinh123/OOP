import java.math.BigInteger;
import java.util.Scanner;

public class CHIAHET {
    public static boolean check(BigInteger a , BigInteger b){
        if(a.mod(b).equals(new BigInteger(("0"))) || b.mod(a).equals(new BigInteger("0"))) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Test = scanner.nextInt();
        while (Test -- >0) {
            BigInteger a = scanner.nextBigInteger();
            BigInteger b = scanner.nextBigInteger();
            if (check( a, b)) {
                System.out.println("YES");
            }else System.out.println("NO");


        }
    }
}
