package UVa.leetCode;


import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {


    public List<String> generateParenthesis(int n) {
        return null;
    }




    public static void test(int n, int x, int y, String s, List list) {

        if (y == n) {
            list.add(s);
        }

        if (x < n) {
            test(n, x + 1, y, s + "(", list);
        }

        if (y < x) {
            test(n, x, y + 1, s + ")", list);
        }
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        test(3, 0, 0, "", list);
    }
}
