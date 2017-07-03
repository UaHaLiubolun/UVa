package UVa.leetCode;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length() != 0) {
            list.add("");
        }
        for (int i = 0; i < digits.length() ; i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            while (list.peek().length() == i) {
                String t = list.remove();
                for (char s:
                        mapping[num].toCharArray()) {
                    list.add(t + s);
                }
            }
        }
        return list;
    }
}
