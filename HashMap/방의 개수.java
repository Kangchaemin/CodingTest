import java.util.*;

class Solution {
    
    public int moveX[] = {-1, -1, 0, 1, 1, 1, 0, -1};
    public int moveY[] = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public int solution(int[] arrows) {
        int answer = 0;
        
        HashMap<String, Node> map = new HashMap<>();
        
        Node node = new Node(0, 0);
        map.put(node.id, node);
        
        for(int arrow : arrows){
            for(int i = 0; i < 2; i++){
                int goX = node.x + moveX[arrow];
                int goY = node.y + moveY[arrow];
                //Node goNode = new Node(goX, goY);
                String goId = Node.makeId(goX, goY);

                if( !map.containsKey(goId) ){
                    map.put(goId, new Node(goX, goY));
                } else if(!node.connectSet.contains(goId)){
                    answer++;
                }
                
                Node goNode = map.get(goId);
                node.connectSet.add(goNode.id);
                goNode.connectSet.add(node.id);
                //node = goNode;
                node = map.get(goId);
            }
        }
        return answer;
    }
    
    public static class Node{
        int x;
        int y;
        String id;
        HashSet<String> connectSet;
        
        public Node(int x, int y){
            this.x = x;
            this.y = y;
            this.id = makeId(x, y);
            this.connectSet = new HashSet<>();
        }
        
        public static String makeId(int x, int y){
            return String.format("(%d, %d)", x, y);
        }
    }
}
