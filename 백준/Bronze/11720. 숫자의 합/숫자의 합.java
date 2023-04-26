import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        String s = sc.next();
        char arr[] = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
        	sum += arr[i] - '0';
        }
        
        System.out.println(sum);
        sc.close();
    }
}