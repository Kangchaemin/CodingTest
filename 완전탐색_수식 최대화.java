import java.util.*;

class Solution {
    
    String[][] operator = {{"*", "+", "-"}, {"*", "-", "+"},
                           {"+", "*", "-"}, {"+", "-", "*"},
                           {"-", "*", "+"}, {"-", "+", "*"}};
    
    public long solution(String expression) {
        
        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        ArrayList<String> list = new ArrayList<>();
        
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        
        long max = 0;
        for(String op[] : operator){
            long result = calculate(new ArrayList<>(list), op);
            if(max < result){
                max = result;
            }
        }
        
        return max;
    }
    
    public long calculate(ArrayList<String> calList, String op[]){
        
        for(String opS : op){
            for(int i = 0; i < calList.size(); i++){
                if(calList.get(i).equals(opS)){
                    long resultTmp = calculate(calList.remove(i-1), calList.remove(i-1), calList.remove(i-1));
                    calList.add(i-1, String.valueOf(resultTmp));
                    i -= 2;
                }
            }
        }
        
        return Math.abs(Long.parseLong(calList.get(0)));
    }
    
    public long calculate(String a, String c, String b){
        long al = Long.parseLong(a);
        long bl = Long.parseLong(b);
        
        if(c.equals("+")){
            return al + bl;
            
        } else if(c.equals("-")){
            return al - bl;
            
        } else{
            return al * bl;
        }
    }
}
