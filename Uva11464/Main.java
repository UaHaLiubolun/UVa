package UVa.Uva11464;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int num;

    //查询变化个数
    public static int check(int[] before, int[] after) {
        int number = 0;
        for (int i = 0; i < before.length; i++) {
            if (before[i] == after[i]) number++;
        }
        return number;
    }

    //计算下一行数据
    public static int[] select(int[] up) {
        int[]  down = new int[up.length];
        for (int i = 0; i < up.length; i++){
            if (i == 0 || i == up.length - 1) {
                down[i] = up[i+1] % 2;
            } else {
                down[i] = (up[i+1] + up[i-1]) % 2;
            }
        }
        return down;
    }

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        num = input.nextInt();
        int[][] dataDetail;

        ArrayList<int[][]> data = new ArrayList<int[][]>(num);

        for (int i = 0; i < num; i++) {

            int tmp_num = input.nextInt();
            dataDetail = new int[tmp_num][tmp_num];

            for (int j = 0; j < tmp_num; j++) {
                for (int k = 0; k < tmp_num; k++) {
                    dataDetail[j][k] = input.nextInt();
                }
            }
            data.add(dataDetail);

            for (int m = 0; m < tmp_num; m++) {
                int[] tmp_data = dataDetail[m];
                int[] tmp_data_next = select(tmp_data);
                
            }

        }


    }
}
