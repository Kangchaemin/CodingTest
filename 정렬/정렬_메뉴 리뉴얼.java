import java.util.*;

class Solution {
    Map<String, Integer> map;
    ArrayList<String> list = new ArrayList<>();
    int max;
    
    public String[] solution(String[] orders, int[] course) {
        for(int i = 0; i < orders.length; i++){
            char[] orderCh = orders[i].toCharArray();
            Arrays.sort(orderCh);
            orders[i] = String.valueOf(orderCh);
        }
        
        for(int i = 0; i < course.length; i++){
            map = new HashMap<>();
            max = Integer.MIN_VALUE;
            for(int j = 0; j < orders.length; j++){
                if(course[i] <= orders[j].length()){
                    comb(orders[j], new StringBuilder(), 0, 0, course[i]);
                }   
            }
            
            for(String str : map.keySet()) {
                max = Math.max(max, map.get(str));
            }
            
            for(String str : map.keySet()){
                if(max >= 2 && map.get(str) == max){
                    list.add(str);
                }
            }
        }
        Collections.sort(list);
        
        return list.toArray(new String[list.size()]);
    }
    
    public void comb(String str, StringBuilder sb, int start, int depth, int n){
        if(depth == n){
            int count = map.getOrDefault(sb.toString(), 0) + 1;
            //max = Math.max(max, count);
            map.put(sb.toString(), count);
            return;
        }
        
        for(int i = start; i < str.length(); i++){
            sb.append(str.charAt(i));
            comb(str, sb, i+1, depth+1, n);
            sb.deleteCharAt(depth);
        }
    }
}
