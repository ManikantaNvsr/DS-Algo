import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String[] arr = {"kolkata", "delhi", "pune", "mumbai"};
        for (String each : arr) {
            boolean flag = false;
            Set temp = new HashSet();
            for (String character : each.split("")) {
                if (temp.contains(character)) {
                    flag = true;
                    break;
                } else {
                    temp.add(character);
                }
            }
            if (!flag) {
                System.out.println(each);
            }
        }
    }
}
