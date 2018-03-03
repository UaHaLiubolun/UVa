package UVa.leetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static int k = 2;

    public static int count = 0;

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getResult(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }


    /**
     *
     *
     *
     * @param result 结果
     * @param current 当前数组数据
     * @param candidates
     * @param target
     * @param start
     */
    private static void getResult(List<List<Integer>> result, ArrayList<Integer> current, int[] candidates, int target,
                                  int start) {
        if(target<0)    return;
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if (target > 0 && current.size() == k) {
            count++;
        }
        for(int i = start; i<candidates.length && target >= candidates[i]; i++){
            current.add(candidates[i]);
            getResult(result, current, candidates, target-candidates[i], i + 1);
            current.remove(current.size() - 1);
            while(i < candidates.length - 1 && candidates[i] == candidates[i+1]) i++;    // 去重复（注意上面有i+1,这里要length-1，边界问题）
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 5, 12};
        System.out.println(combinationSum(nums, 10));
        System.out.println(count);
    }
}
