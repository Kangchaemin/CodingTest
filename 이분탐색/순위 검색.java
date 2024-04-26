import java.util.*;

class Solution {
    HashMap<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(int i = 0; i < info.length; i++){
            String[] p = info[i].split(" ");
            makeSentence(p, "", 0);
        }
        
        for(List<Integer> list : map.values()){
            Collections.sort(list);
        }
        
        for(int i = 0; i < query.length; i++){
            String qStr = query[i].replace(" and ", "");
            String[] newQ = qStr.split(" ");
            answer[i] = map.containsKey(newQ[0]) ? binarySearch(newQ[0], Integer.parseInt(newQ[1])) : 0;
        }
        
        return answer;
    }
    
    public int binarySearch(String str, int score){
        List<Integer> list = map.get(str);
        
        int start = 0;
        int end = list.size();
        
        while(start < end){
            int mid = (start + end) / 2;
            
            if(list.get(mid) >= score){
                end = mid;
            } else{
                start = mid + 1;
            }
        }
        
        return list.size() - end;
    }
    
    public void makeSentence(String[] q, String str, int index){
        if(index == q.length - 1){
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(Integer.parseInt(q[q.length - 1]));
            return;
        }
        
        makeSentence(q, str + "-", index + 1);
        makeSentence(q, str + q[index], index + 1);
    }
}
