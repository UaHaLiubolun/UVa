package UVa.leetCode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int size = 0;
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                map.put(s.charAt(i), 1);
            } else {
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        boolean temp = false;
        for (Integer num:
             map.values()) {
            if (num % 2 == 0) {
                size += num;
            } else {
                temp = true;
                size =  size + num - 1;
            }
        }


        return temp ? size + 1 : size;
    }
}
