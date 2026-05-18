package File;
import java.util.Scanner;

class POI {
    private double x, y;

    public POI(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(POI other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
    class Triangle {
        private POI a, b, c;

        public Triangle(POI a, POI b, POI c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public boolean isValid() {
            double ab = a.distance(b);
            double bc = b.distance(c);
            double ca = c.distance(a);

            return ab + bc > ca && ab + ca > bc && bc + ca > ab;
//            if (ab + bc <= ca) return false;
//            if (ab + ca <= bc) return false;
//            if (bc + ca <= ab) return false;
//
//            return true;
        }

        public double chuVi() {
            return a.distance(b) + b.distance(c) + c.distance(a);
        }
    }


public class CHUVITAMGIAC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Test = sc.nextInt();
        while (Test-- > 0) {
            POI p1 = new POI(sc.nextDouble(), sc.nextDouble());
            POI p2 = new POI(sc.nextDouble(), sc.nextDouble());
            POI p3 = new POI(sc.nextDouble(), sc.nextDouble());

            Triangle t = new Triangle(p1, p2, p3);

            if (!t.isValid()) {
                System.out.println("INVALID");
            } else {
                System.out.printf("%.3f\n", t.chuVi());
            }
        }
    }
}
