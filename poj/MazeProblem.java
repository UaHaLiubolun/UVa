package UVa.poj;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{

    static void printIntArray(int[][] array) {
        int max = array[4][4];
        String[] strings = new String[max + 1];
        for (int i = 4; i >= 0; i--) {
            for (int j = 4; j >= 0; j--) {
                if (array[i][j] == max) {
                    strings[max] = "(" + i + ", " + j + ")";
                    max--;
                }
            }
        }

        for (String string:
             strings) {
            System.out.println(string);
        }

    }

    public static void main(String[] args) {

        int[][] maze = new int[5][5];
        int[][] d = new int[5][5];
        Scanner in = new Scanner(System.in);
        //输入
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d[i][j] = Integer.MAX_VALUE;
                maze[i][j] = in.nextInt();
            }
        }

        //四个方向移动的向量
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> que = new LinkedList<>();
        //起点加入队列并把这地点距离设置为0
        Pair pair = new Pair(0, 0);
        que.add(pair);
        d[0][0] = 0;

        while (!que.isEmpty()) {
            Pair p = que.poll();
            //如果已经到达终点则将结束
            if (p.first == 4 && p.second == 4) break;

            for (int i = 0; i < 4; i++) {
                int nx = p.first + dx[i], ny = p.second + dy[i];
                //判断是否可以移动以及是否已经访问过
                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && maze[nx][ny] != 1 && d[nx][ny] == Integer.MAX_VALUE) {
                    //可以移动的话，则加入队列，并且到该位置的距离确定为到p的距离加1
                    pair = new Pair(nx, ny);
                    que.add(pair);
                    d[nx][ny] = d[p.first][p.second] + 1;
                }
            }
        }

        Main.printIntArray(d);
    }



}


public class MazeProblem {

}

class Pair{
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
