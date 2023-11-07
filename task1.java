public class Main {
    public static void main(String[] args) {
        System.out.println("task 1.1");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println("\ntask 1.2");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println("\ntask 1.3");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println("\ntask 1.4");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        System.out.println("\ntask 1.5");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println("\ntask 1.6");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println("\ntask 1.7");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println("\ntask 1.8");
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println(gcd(249, 28));

        System.out.println("\ntask 1.9");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println("\ntask 1.10");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));

    }
    public static double convert(int x) {
        return x * 3.785;
        }


    public static double fitCalc(double x, double y) {
        return x * y;
    }


    public static int containers(int x, int y, int z) {
        return x * 20 + y * 50 + z * 100;
    }


    public static String triangleType(double x, double y, double z) {
        if (x + y <= z || x + z <= y || y + z <= x) {
            return "not a triangle";
        } else {
            if (x == y && y == z) {
                return "isosceles";
            } else if (x == y || x == z || y == z) {
                return "equilateral";
            } else {
                return "different-sided";
            }
        }
    }


    public static double ternaryEvaluation(double x, double y) {
        return (x >= y ? x : y);
    }


    public static int howManyItems(double x, double y, double z) {
        return (int) ((x / 2) / (y * z));
    }


    public static int factorial(int x) {
        if (x <= 1) {
            return x;
        } else {
            return factorial(x - 1) * x;
        }
    }


    public static int gcd(int x, int y) {
        while (x != 0 && y != 0) {
            if (x >= y) {
                x -= y;
            } else {
                y -= x;
            }
        }
        return (x >= y ? x : y);
    }


    public static float ticketSaler(float x, float y) {
        return x * y * 0.72f;
    }


    public static int tables(int x, int y) {
        if (y * 2 >= x) {
            return 0;
        } else {
            return (int) (Math.ceil((x - y * 2) * 0.5f));
        }
    }
}
