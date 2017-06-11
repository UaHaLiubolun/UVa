package UVa.poj;


import java.util.Scanner;

public class LakeCounting {

    int N, M;
    char filed[][];

    public static void main(String[] args) {
        LakeCounting lakeCounting = new LakeCounting();
        Scanner in = new Scanner(System.in);
        lakeCounting.N = in.nextInt();
        lakeCounting.M = in.nextInt();
        lakeCounting.filed = new char[lakeCounting.N][lakeCounting.M];
        for (int i = 0; i < lakeCounting.N; i++) {
            String line = in.next();
            for (int j = 0; j < lakeCounting.M; j++) {
                lakeCounting.filed[i][j] = line.charAt(j);
            }
        }
        lakeCounting.solve();
    }

    void dfs(int x, int y) {
        filed[x][y] = '.';
        //循环遍历移动的八个方向
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx;
                int ny = y + dy;
                //判断nx ny是否在园子内，以及是否有积水
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && filed[nx][ny] == 'W') dfs(nx, ny);
            }
        }
    }

    void solve() {
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (filed[i][j] == 'W') {
                    dfs(i, j);
                    res++;
                }
            }
        }
        System.out.println(res);
    }


}
