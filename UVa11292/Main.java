package UVa.UVa11292;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int NumberOfHeads, NumberOfKnights;
    public static int[] Heads;
    public static int[] Knights;
    public static int Current, Answer;


    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner Input = new Scanner(System.in);

        while (Input.hasNext()) {
            NumberOfHeads = Input.nextInt();    NumberOfKnights = Input.nextInt();

            if (NumberOfHeads == 0 && NumberOfKnights == 0) break;

            Heads = new int[NumberOfHeads];
            Knights = new int[NumberOfKnights];

            for (int i = 0; i < NumberOfHeads; i++)    Heads[i] = Input.nextInt();
            for (int i = 0; i < NumberOfKnights; i++)   Knights[i] = Input.nextInt();

            if (NumberOfHeads > NumberOfKnights) {
                System.out.println("Loowater is doomed!");
                continue;
            }

            //排序
            Arrays.sort(Heads);  Arrays.sort(Knights);

            Current = 0;
            Answer = 0;
            boolean Output = true;

            for (int i = 0; i < NumberOfHeads; i++) {
                //如果剩余头数小于剩余猎人
                if (NumberOfHeads - i > NumberOfKnights - Current) {
                    Answer = -1;
                    Output = false;
                    break;
                }

                for (int j = Current; j < NumberOfKnights; j++) {
                    //排除不适合的
                    if (Knights[j] < Heads[i]) {
                        Current++;
                        continue;
                    }
                    Answer += Knights[j];
                    Current++;
                    Output = true;
                    break;
                }

            }

            if (Answer == -1 && Output == false)    System.out.println("Loowater is doomed!");
            else    System.out.println(Answer);
        }
    }
}
