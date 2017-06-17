package UVa.poj;

import java.util.Arrays;

/**
 * POJ 3253
 * Fence Repair
 */
public class FenceRepair {

    public static void main(String[] args) {
        int N = 3;
        int[] L = {8, 5, 8};

//        Arrays.sort(L);
        int ans = 0;
        //直到计算到模板为1块时为止
        while (N > 1) {
            //求出最短半mii1和次短板mii2
            int mii1 = 0, mii2 = 1;
            if (L[mii1] > L[mii2]) {
                int tmp = mii1;
                mii1 = mii2;
                mii2 = tmp;
            }

            //找到最短和次短的木板
            for (int i = 2; i < N; i++) {
                if (L[i] < L[mii1]) {
                    mii2 = mii1;
                    mii1 = i;
                } else if (L[i] < L[mii2]) {
                    mii2 = i;
                }
            }

            // 将两块模板拼合
            int t = L[mii1] + L[mii2];
            ans += t;

            if (mii1 == N - 1) {
                int tmp = mii1;
                mii1 = mii2;
                mii2 = tmp;
            }
            L[mii1] = t;
            L[mii2] = L[N - 1];
            N--;
        }
        System.out.println(ans);
    }
}
