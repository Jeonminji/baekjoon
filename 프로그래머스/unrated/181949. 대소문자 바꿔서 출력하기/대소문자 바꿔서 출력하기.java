import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        System.out.print(s.S(a));
    }
    
    public String S(String a) {
        String result = "";
        
        for (char c : a.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result += Character.toUpperCase(c);
            } else {
                result += Character.toLowerCase(c);
            }
        }
        
        return result;
    }
}