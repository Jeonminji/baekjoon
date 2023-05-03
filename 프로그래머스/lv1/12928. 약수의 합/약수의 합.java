class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
       while(i!=n + 1){
            if(n % i == 0) {
                answer = answer + i;
            }  
         i += 1;
       }
     
        return answer;
   
    }
}