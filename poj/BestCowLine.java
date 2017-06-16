package UVa.poj;

import java.util.Scanner;

/**
 * POJ 3617
 * Best Cow Line
 */
public class BestCowLine {

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int N;
        String S = "";

        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            S += scanner.next();
        }

        String s = "";

        int a = 0;
        int b = N - 1;

        while (a <= b) {
//            if (S.charAt(a) > S.charAt(b)) {
//                s += S.charAt(b);
//                b--;
//            } else if (S.charAt(b) > S.charAt(a)) {
//                s += S.charAt(a);
//                a++;
//            } else if (S.charAt(a) == S.charAt(b)) {
//                String newS = "";
//                for (int i = b; i >= a; i--) {
//                    newS += S.charAt(i);
//                }
//                if (newS.compareTo(S.substring(a, b)) < 0) {
//                    s += S.charAt(b);
//                    b--;
//                } else {
//                    s += S.charAt(a);
//                    a++;
//                }
//            }
            boolean left  = false;

            //
            for (int i = 0; a + i <= b; i++) {
                if (S.charAt(a + i) < S.charAt(b - i)) {
                    left = true;
                    break;
                } else if (S.charAt(a + i) > S.charAt(b - i)) {
                    left = false;
                    break;
                }
            }

            if (left) {
                s += S.charAt(a);
                a++;
            } else {
                s += S.charAt(b);
                b--;
            }
        }

        System.out.print(s);

    }
}
