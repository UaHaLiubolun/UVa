package UVa.leetCode;



public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] numbers = new int[]{-2,-1};
        System.out.println(maxSubArray(numbers));
    }

}
