package UVa.poj;

import java.util.Arrays;

public class Coin {

    int n = 4, W = 5;
    int[] w = {2, 1, 3, 2};
    int[] v = {3, 2, 4, 2};

    public static void main(String[] args) {

    }

    /**
     * 背包问题
     * 有n个重量和价值分别为w，v的物品。重这些物品中挑出总重量不超过W的物品，求所有挑选方案中价值总和最大值
     */
    public static void bag() {
        Coin coin = new Coin();
        System.out.println(coin.rec(0, coin.W));
    }

    public static void anotherBag() {
        Coin coin = new Coin();
        int[][] res = new int[coin.n + 1][coin.W + 1];
       for (int i = coin.n - 1; i >=0; i--) {
           for (int j = 0; j <= i; j++) {
               if (j < coin.w[i]) {
                   res[i][j] = res[i + 1][j];
               } else {
                   res[i][j] = Math.max(res[i][j], res[i + 1][j - coin.w[i]] + coin.v[i]);
               }
           }
       }
    }

    public String replaceSpace(String iniString, int length) {
        // write code here
        String s  = "";
        for (int i = 0; i < length; i++) {
            if (iniString.charAt(i) == ' ') {
                s += "%20";
            } else {
                s += iniString.charAt(i);
            }
        }
        return s;
    }

    public int rec(int i, int j) {
        int res;
        if (i == n) res = 0;
        else if (j < w[i]) res = rec(i + 1, j);
        else {
            res = Math.max(rec(i + 1, j), rec(i + 1, j - w[i]) + v[i]);
        }
        return res;
    }

    /**
     * 硬币问题
     * 给一组硬币 凑够某个数  使用最少的硬币
     */
    public static void coin() {
        int[] V = {1, 5, 10, 50, 100, 500};

        int[] C  = {1, 2, 1, 2, 0, 1};
        int A = 620;

        int ans = 0;
        for (int i = 5; i >= 0; i--) {
            int t = Math.min(A / V[i], C[i]);
            A -= t * V[i];
            ans += t;
        }

        System.out.println(ans);
    }


    /**
     * 区间调度问题
     */
    public static void intervalScheduling () {
        int n = 5;
        int[] s = {1, 2, 4, 6, 8};
        int[] t = {3, 5, 7, 9, 10};

        pair[] pairs = new pair[5];

        for (int i = 0; i < n; i++) {
            pairs[i] = new pair(s[i], t[i]);
        }

        //按结束时间排序
        Arrays.sort(pairs);

        int ans = 0;
        int T = 0; //T表示最后工作结束的时间
        for (int i = 0; i < n; i++) {
            if (T < pairs[i].first) {
                T = pairs[i].second;
                ans++;
            }
        }

        System.out.println(ans);
    }



}


class pair implements Comparable<pair>{
    int first;
    int second;

    public pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(pair o) {
        if (this.second < o.second) return -1;
        else return 1;
    }
}
