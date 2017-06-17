package UVa.poj;


/**
 * POJ 3069
 * Saruman's Army
 */
public class SarumanArmy {

    public static void main(String[] args) {
        int N = 6;
        int R = 10;
        int[] X = {1, 7, 15, 20, 30, 50};

        int i = 0;
        int ans = 0;

        while (i < N) {
            //s是没有被覆盖的最左的点的位置
            int s = X[i++];
            //一直向右前进直到距s的距离大于R的点
            while (i < N && X[i] <= s + R) i++;
            //p是加上标记点的位置
            int p = X[i - 1];
            //一直向右前进直到距p的距离大于R的点
            while (i < N && X[i] <= p + R) i++;
            ans++;
        }

        System.out.println(ans);


    }

}
