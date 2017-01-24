package UVa.UVa11300;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int NumberOfPerson;
    private static int[] Wealth;
    private static int[] C;
    private static int Value = 0;

    public static void main(String args[]) {

        Scanner Input = new Scanner(System.in);

        while (Input.hasNext()) {

            NumberOfPerson = Input.nextInt();
            if (NumberOfPerson == 0 )   break;
            Wealth = new int[NumberOfPerson];
            C = new int[NumberOfPerson - 1];

            int tmp = 0;
            int M = 0;
            int X = 0;

            for (int i = 0; i < NumberOfPerson; i++) {
                Wealth[i] = Input.nextInt();
                M += Wealth[i];
            }

            if (M % NumberOfPerson == 0){
                M = M/NumberOfPerson;
            } else {
                System.out.println("Data Error");
                break;
            }

            for (int i = 0; i < C.length; i++) {
                tmp += Wealth[i] - M;
                C[i] = tmp;
            }

            Arrays.sort(C);
            int Middle = (int)C.length / 2;
            if (C.length % 2 == 0) {
                X = (int)(C[Middle] + C[Middle - 1]) / 2;
            } else {
                X = C[Middle];
            }

            Value += Math.abs(X);
            for (int i = 0; i < C.length; i++) {
                Value += Math.abs(X - C[i]);
            }
            System.out.println(Value);
        }
    }
}
