package datastructure;

import java.util.Scanner;

public class WaterJugs {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static boolean canMeasureWater(int a, int b, int c) {
        // Check for impossible scenarios
        if (c > a + b) {
            return false;
        }
        if (c % gcd(a, b) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (canMeasureWater(a, b, c)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
