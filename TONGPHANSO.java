package File;
import java.util.Scanner;

class phanso {
        private long tuSo, mauSo;

        public phanso(long tuSo , long mauSo){
            this.tuSo = tuSo;
            this.mauSo = mauSo;
        }
    phanso cong(phanso b) {
        long tuMoi = this.tuSo * b.mauSo + this.mauSo * b.tuSo;
        long mauMoi = this.mauSo * b.mauSo;

        long g = gcd(tuMoi, mauMoi);
        return new phanso(tuMoi / g, mauMoi / g);
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }
}

    public class TONGPHANSO{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        phanso a = new phanso(sc.nextInt(), sc.nextInt());
        phanso b = new phanso(sc.nextInt(), sc.nextInt());

        System.out.println(a.cong(b));


    }
}
