package UVa.leetCode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int contain = 0;
        int l = 0;
        int r = height.length - 1;
        while (l != r) {
            contain = Math.max(contain, (r- l) * Math.min(height[l], height[r]));
            if (height[l] > height[r]) {
                r -= 1;
            } else {
                l += 1;
            }
        }
        return contain;
    }

}
