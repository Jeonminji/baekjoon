class Solution {
    public int[] solution(long n) {
        String a = "" + n;      // 내부적으로 StringBuffer 생김
        int[] answer = new int[a.length()];
        
        int i = 0;
        
        while (n > 0) {
            answer[i] = (int)(n % 10);
            n /= 10;
            i++;
        }
        
        
        return answer;
    }
}