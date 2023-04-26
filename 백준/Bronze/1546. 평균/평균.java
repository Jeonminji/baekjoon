import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        double arr2[] = new double[n];
        
        int max = 0;
        for (int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        	if (max < arr[i]) {
        		max = arr[i];
        	}
        }
        
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
        	arr2[i] = arr[i] / (double)max * 100;
        	sum += arr2[i];
        }
        
        System.out.println((double)sum/n);
        
        sc.close();
    }
}