import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        
        String bans[][] = Arrays.stream(banned_id)
                            .map(banned -> banned.replace("*", "."))
                            .map(banned -> Arrays.stream(user_id)
                                            .filter(id -> id.matches(banned))
                                            .toArray(String[]::new))
                            .toArray(String[][]::new);
        HashSet<HashSet<String>> banComb = new HashSet<>();
        dfs(0, bans, new HashSet<String>(), banComb);
        return banComb.size();
    }
    
    public void dfs(int index, String[][]bans, HashSet<String> banSet, HashSet<HashSet<String>>banComb){
        if(index == bans.length){
            banComb.add(new HashSet<>(banSet));
            return;
        }
        
        for(String id : bans[index]){
            if(!banSet.contains(id)){
                banSet.add(id);
                dfs(index+1, bans, banSet, banComb);
                banSet.remove(id);
            }
        }
    }
}
