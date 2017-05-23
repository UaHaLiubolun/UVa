package UVa.leetCode;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        int size = nums.length / 2;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + nums[2 * i];
        }
        return sum;
    }
}
