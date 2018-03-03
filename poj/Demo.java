package UVa.poj;

import java.util.Scanner;

public class Demo{

    static int prices[];
    static int count = 0;
    static int n;


    public static void main(String[] args) {


        int k, m;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        m = scanner.nextInt();

        prices = new int[m];

        for (int i = 0; i < m; i++) {
            prices[i] = scanner.nextInt();
        }

        for (int i = m ; i >= k; i--) {
            f(i,m);
        }


    }


    public static void f(int n,int r){
        if(r == 1){
            prices[r-1] = n;
            int j = 0;
            while(prices[j]!= 0){
                j++;
            }
            int temp = 0;
            for(int i = j-1; i >= 0; i --){
                temp += prices[i];
            }
            if (temp < n) {
                count++;
            }
        }
        else{
            prices[r-1] = n;
            for(int j = n-1; j >= r-1; j --){
                f(j,r-1);
            }
        }
    }


}
