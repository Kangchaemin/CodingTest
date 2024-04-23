import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String newNumbers[] = Arrays.stream(numbers)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);
        
        Arrays.sort(newNumbers, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        if(newNumbers[0].equals("0")){
            return "0";
        }
        
        return String.join("", newNumbers);
    }
}
