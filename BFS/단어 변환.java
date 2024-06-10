import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(words));
        if(!wordList.contains(target)){
            return 0;
        }
        
        Queue<String> qS = new LinkedList<>();
        Queue<Integer> qC = new LinkedList<>();
        boolean visit[] = new boolean[words.length];
        
        qS.add(begin);
        qC.add(0);
        
        while(!qS.isEmpty()){
            String checkS = qS.poll();
            int checkC = qC.poll();
            
            if(checkS.equals(target)){
                answer = checkC;
                break;
            }
            
            for(int j = 0; j < words.length; j++){
                if(!visit[j] && checkChange(checkS, words[j])){
                    visit[j] = true;
                    qS.add(words[j]);
                    qC.add(checkC + 1);
                }
            }
        }
        return answer;
    }
    
    public boolean checkChange(String bf, String af){
        char bfArr[] = bf.toCharArray();
        char afArr[] = af.toCharArray();
        int count = 0;
        
        for(int i = 0; i < bf.length(); i++){
            if(bfArr[i] != afArr[i]){
                count++;
            }    
        }
        
        return count == 1;
    }
}
