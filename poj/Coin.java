package UVa.poj;

import java.util.Arrays;

public class Coin {

    public static void main(String[] args) {
        Coin.intervalScheduling();
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
