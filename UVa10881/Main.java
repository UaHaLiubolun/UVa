package UVa.UVa10881;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int Num;

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        Num = input.nextInt();
        int index = 1;
        while (Num > 0) {
            Num--;
            int l = input.nextInt();
            int t = input.nextInt();
            int n = input.nextInt();

            Ant[] before = new Ant[n];
            Ant[] after = new Ant[n];
            int[] order = new int[n];

            for (int i = 0; i < n; i++) {
                Ant temp = new Ant(i, input.nextInt(), input.next());
                before[i] = temp;
                after[i] = new Ant(i, temp.pos + t*temp.dir, temp.status);
            }

            Arrays.sort(before);
            for (int i = 0; i < n; i++) {
                order[before[i].index] = i;
            }

            Arrays.sort(after);
            for (int i = 0; i < n - 1; i++) {
                if (after[i].pos == after[i+1].pos) {
                    after[i].status = after[i+1].status = "Turning";
                }
            }

            System.out.printf("Case #%d:\n", index);
            index++;
            for (int i = 0; i < n; i++) {
                Ant ant = after[order[i]];
                if (ant.pos > l || ant.pos < 0) {
                    System.out.println("Fell off\n");
                } else {
                    System.out.printf("%d %s\n", ant.pos, ant.status);
                }
            }
            System.out.println();

        }
    }
}

class Ant implements Comparable<Ant> {

    int index;
    int dir;
    int pos;
    String status;

    Ant(int index, int pos, String dir) {
        this.index = index;
        this.dir = dir.equals("L")? -1 : 1;
        this.pos = pos;
        this.status = dir;
    }

    @Override
    public int compareTo(Ant o) {
        if (this.pos > o.pos) {
            return 1;
        } else if (this.pos < o.pos) {
            return -1;
        }
        return 0;
    }
}

