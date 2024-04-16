import java.util.*;

class Solution {
    
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visit = new boolean[7];
    
    public int solution(String numbers) {
        dfs(numbers, "", 0);    
        
        int count = 0;
        for(Integer num : set){
            if(isPrime(num)){
                count++;
            }
        }
        return count;
    }
    
    public void dfs(String numbers, String s, int depth){
        if(depth > numbers.length()){
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth+1);
                visit[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
