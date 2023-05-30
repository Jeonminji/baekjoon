class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int arr[] = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                arr[i] += i;
            }
        }
        
        for (int i = 1; i < arr.length; i++) {
            answer += arr[i];
        }
        
        return answer;
    }
}