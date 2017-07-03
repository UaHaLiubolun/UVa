package UVa.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {

    public static void main(String[] args)throws IOException,NumberFormatException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=br.readLine())!=null){

            int number=Integer.parseInt(line);
            System.out.println(tentoEight(number));
        }
    }

    public static int tentoEight(int input){
        int number = 0;
        int i = 0;
        int x;
        while (input != 0) {
            x = input & 7;
            number += (x * (int)Math.pow(10, i));
            i++;
            input = input >>= 3;
        }
        return number;
    }
}
