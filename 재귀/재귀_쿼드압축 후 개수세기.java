class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        return answer;
    }
    
    public void quad(int[][] arr, int x, int y, int size){
        if( zip(arr, x, y, size, arr[x][y]) ){
            if(arr[x][y] == 1){
                answer[1] += 1;
            } else{
                answer[0] +=1 ;
            }
            return;
        }
        
        quad(arr, x, y, size/2);
        quad(arr, x+size/2, y, size/2);
        quad(arr, x, y+size/2, size/2);
        quad(arr, x+size/2, y+size/2, size/2);
    }
    
    public boolean zip(int[][] arr, int x, int y, int size, int val){
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[i][j] != val){
                    return false;
                }
            }
        }
        return true;
    }
}
