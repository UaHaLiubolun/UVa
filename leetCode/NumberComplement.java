package UVa.leetCode;

/**
 * Created by jhonlambo on 2017/5/23.
 */
public class NumberComplement {

    public int findComplement(int num) {
        String bytes = Integer.toBinaryString(num);

        int[] binary = new int[bytes.length()];
        int sum = 0;
        boolean isStart = false;
        for (int i = 0; i < bytes.length(); i++) {
            if (bytes.charAt(i) == '1') {
                binary[i] = 0;
            } else {
                binary[i] = 1;
            }
            if (binary[i] == 1) isStart = true;
            if (isStart && binary[i] == 1) {
                sum = sum + (int)Math.pow(2, binary.length - i - 1);
            }
        }
        System.out.print(sum);
        return sum;
    }


}
