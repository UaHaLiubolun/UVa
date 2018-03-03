import java.util.ArrayList;
import java.util.Scanner;

public class  main {
    private static ArrayList <Integer> tmpArr = new ArrayList<Integer>();
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sample Input:");
        int n = sc.nextInt(); // 预算
        int k = sc.nextInt(); // 想点菜的个数
        int m = sc.nextInt(); // 菜的个数
        int [] com = new int[m];
        for(int i = 0; i < m; i++) {
            com[i] = sc.nextInt();
        }
        System.out.println("");
        System.out.println("Sample Output:");

        if(k > com.length || com.length <= 0){
            System.out.println("0");
        } else {
            combine(0, k, com, n);
            System.out.println(count);
        }

    }
    /*
     * 递归求m个数组中选n个有多少种组合方式，
     * 选出总价格不超过预订价格的组合方式，然后count++。
     */
    public static void combine(int index, int k, int[] arr, int n) {

        if(k == 1) {
            for (int i = index; i < arr.length; i++) {
                int sum = 0;
                tmpArr.add(arr[i]);
                for(int j = 0; j < tmpArr.size(); j++) {
                    sum += tmpArr.get(j);
                }
                if(sum <= n) {
                    count++;
                }
                tmpArr.remove((Object)arr[i]);
            }
        } else if(k > 1) {
            for (int i = index; i <= arr.length - k; i++) {
                tmpArr.add(arr[i]);
                combine(i + 1, k - 1, arr, n);
                tmpArr.remove((Object)arr[i]);
            }
        } else {
            return ;
        }
    }
}
