import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String tmp[] = s.split(" ");
        
        int arr[] = new int[tmp.length];
        
        for (int i = 0; i < tmp.length; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }
        
        answer += Arrays.stream(arr).min().getAsInt();
        answer += " ";
        answer += Arrays.stream(arr).max().getAsInt();
        
        return answer;
    }
}