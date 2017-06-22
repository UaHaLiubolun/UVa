package UVa.poj;

/**
 * 动态规划相关问题
 */
public class DP {
    public static void main(String[] args) {
        DP.bagOne();
    }

    /**
     * 背包问题
     * 有n种重量和价值分别为w，v的物品，从这些物品中挑选总重量不超过W的物品，求出挑选物品价值总和最大值。不能重复挑选
     * dp[i + 1][j]  = dp[i][j] //不能装进新的物品时
     * dp[i + 1][j]  = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]) //可以装进新物品
     */
    public static void bagOne() {
        int n = 3, W = 7;
        int[] w = {3, 4, 2};
        int[] v = {4, 5, 3};
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i + 1][j]  = dp[i][j];
                } else {
                    dp[i + 1][j]  = Math.max(dp[i][j], dp[i][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }

    /**
     * 最大公共子序列问题
     * nums[i + 1][j + 1] = max(nums[i + 1][j], nus[i][j + 1])
     * or nums[i + 1][j + 1] = nums[i][j] + 1
     */
    public static void maxSubArray() {
        String a = "abcd";
        String b = "becd";
        int[][] nums = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    nums[i + 1][j + 1] = nums[i][j] + 1;
                } else {
                    nums[i + 1][j + 1] = Math.max(nums[i + 1][j], nums[i][j + 1]);
                }
            }
        }
        System.out.println(nums[a.length()][b.length()]);
    }

    /**
     * 完全背包问题
     * 有n种重量和价值分别为w，v的物品，从这些物品中挑选总重量不超过W的物品，求出挑选物品价值总和最大值。可重复挑选
     * 和bagOne只有一个地方的差别
     * dp[i + 1][j]  = Math.max(dp[i][j], dp[i + 1   /bagOne这儿是i not (i + 1)/    ][j - w[i]] + v[i])
     */
    public static void bagTwo() {
        int n = 3, W = 7;
        int[] w = {3, 4, 2};
        int[] v = {4, 5, 3};
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i + 1][j]  = dp[i][j];
                } else {
                    dp[i + 1][j]  = Math.max(dp[i][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }
}
