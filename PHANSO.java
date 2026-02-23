package File;

import java.util.Scanner;

class PHANSO {
    private long tuSo, mauSo;

    public PHANSO() {

    }

    public PHANSO(long tuSo, long mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;

    }

    public void input(Scanner scanner) {
        this.tuSo = scanner.nextLong();
        this.mauSo = scanner.nextLong();
    }

    public long gcd(long a, long b) {
        while (b != 0) {

            long temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }

    public void rutgon() {
        long g = gcd(this.tuSo, this.mauSo);
        this.tuSo /= g;
        this.mauSo /= g;
    }

    @Override
    public String toString() {
        rutgon();
        return this.tuSo + "/" + this.mauSo;
    }
}
