package UVa.UVa11210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private final static String[] mahjong = {
            "1T", "2T", "3T", "4T", "5T", "6T", "7T", "8T", "9T",
            "1S", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S",
            "1W", "2W", "3W", "4W", "5W", "6W", "7W", "8W", "9W",
            "DONG", "NAN", "XI", "BEI", "ZHONG", "FA", "BAI" };
    private static int[] c = new int[34];

    //预处理
    private static int convert(String mj) {
        for (int i = 0; i < 34; i++) {
            if(mj.equals(mahjong[i])) return i;
        }
        return -1;
    }

    private static boolean check() {
        for (int i = 0; i < 34; i++) {
            if (c[i] >= 2) {
                c[i] -= 2;    //抽出将牌
                if (search(0)) return true;
                c[i] += 2;
            }

        }
        return false;
    }

    private static boolean search(int dep) {
        for (int i = 0; i < 34; i++) if (c[i] >= 3){
               if (dep == 3) return true;
               c[i] -= 3;
               if (search(dep+1)) return true;
               c[i] += 3;
        }

        for (int i = 0;i < 24; i++) if (i % 9 <= 6 && c[i] >= 1 && c[i+1] >= 1 && c[i+2] >= 1) {
            if (dep == 3) return true;
            c[i]--; c[i+1]--; c[i+2]--;
            if (search(dep+1)) return true;
            c[i]++; c[i+1]++; c[i+2]++;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String tmp;
        ArrayList<int[]> list = new ArrayList<int[]>();

        read_data:
        while (input.hasNext()) {
            int[] temp = new int[13];
            for (int i = 0; i < 13; i++) {
                tmp = input.next();
                if(tmp.equals("0")) {
                    break read_data;
                } else {
                    temp[i] = convert(tmp);
                }
            }
            list.add(temp);
        }

        for (int k = 0; k < list.size(); k++) {
            boolean ok = false;
            int[] temp = new int[13];
            temp = list.get(k);
            ArrayList<String> answer = new ArrayList<String>();
            answer.clear();
            for (int i = 0; i < 34; i++) {
                Arrays.fill(c, 0);
                for (int j = 0; j < 13; j++) c[temp[j]]++;
                if (c[i] > 4) continue ;  //如果已经四张了就不可能听这张牌了
                c[i]++; //摸牌
                if (check()) {
                    ok = true;
                    answer.add(mahjong[i]);
                }
            }
            int m = k+1;
            if (!ok) {
                System.out.println("Case "+ m +": Not ready");
            } else {
                System.out.print("Case "+ m +":");
                for (String tmp_one: answer) {
                    System.out.print(" "+tmp_one);
                }
                System.out.print("\n");
            }
        }
    }
}
