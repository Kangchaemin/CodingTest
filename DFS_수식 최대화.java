import java.util.*;

class Solution {
	
	static char opers [] = {'+', '-', '*'};
	
	static int check [] = new int [3];
	
	static ArrayList<Long> Numbers = new ArrayList<>();
	
	static ArrayList<Character> Ops = new ArrayList<>();
	
	static ArrayList<Long> Answer = new ArrayList<>();

	public long solution(String expression) {
        
        long answer = 0;
		
		String add_num = ""; // charAt으로 100 = 1 + 0 + 0
		for(int ex = 0; ex < expression.length(); ex++) {
			
			if(expression.charAt(ex) >= '0' && expression.charAt(ex) <= '9') {
				add_num = add_num + expression.charAt(ex);
			}
			
			else {
				Numbers.add(Long.parseLong(add_num)); 	// 숫자 넣기
				Ops.add(expression.charAt(ex)); 		// 연산자 집어넣어주기
				add_num = ""; 	// 문자열을 초기화 해줘야 다음 숫자를 받는다
			}
		}
		
		Numbers.add(Long.parseLong(add_num)); // 맨 마지막 숫자 넣기.
		
		dfs(0, new char [3]);
        
        answer = Collections.max(Answer);
        
        return answer;
	}

	public static void dfs(int count, char[] p) {
		
		if(count == 3) {
			ArrayList<Long> tmp_Numbers = new ArrayList<>(Numbers);
			ArrayList<Character> tmp_Ops = new ArrayList<>(Ops);
			
			for(int pp = 0; pp < p.length; pp++) {
				
				for(int i = 0; i < tmp_Ops.size(); i++) {
					
                    // 연산자 배열안에 있는게 지금 우선순위에 있는거랑 같다면
					if(tmp_Ops.get(i) == p[pp]) { 
						
						Long tmp_result = Cal(tmp_Numbers.remove(i), tmp_Numbers.remove(i), p[pp]); 
						
						tmp_Numbers.add(i, tmp_result);
						
						tmp_Ops.remove(i); // 연산자 제거
						
						i--;
					}
				}
			}
			
			Answer.add(Math.abs(tmp_Numbers.get(0))); // 절대값 변환.
			
			return; // 종료.
		}
		
		for(int i = 0; i < opers.length; i++) {
			
			if(check[i] == 0) { // 아직 방문을 하지 않는 곳이면
				
				check[i] = 1; // 방문 체크
				
				p[count] = opers[i];
				
				dfs(count+1, p);
				
				check[i] = 0; // 체크 해제
			}
		}
		
	}

	public static Long Cal(Long a, Long b, char c) {
	
		long jump_this_ops = 0; 
		
		if(c == '+') 
			return a + b;
		
		else if(c == '-') 
			return a - b;
		
		else if(c == '*')
			return a * b;
		
		else
			return jump_this_ops;
	}

}
