package UVa.leetCode;


/**
 * Created by jhonlambo on 2017/5/23.
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') a++;
            else if (i != 0 && s.charAt(i) == 'L' && s.charAt(i - 1) == 'L'  ) {
                l++;
            }
            else if(s.charAt(i) == 'L') {
                if (l > 2) {
                    return false;
                }
                l = 1;
            }
        }
        if (a > 1 || l > 2) return false;
        else  return true;
    }
}
