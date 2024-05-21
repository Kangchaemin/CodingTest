import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        
        Node[] nodeArr = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++){
            nodeArr[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodeArr, (a1, b1) -> b1.y - a1.y);
        
        Node root = findRoot(nodeArr);
        
        ArrayList<Integer> preList = new ArrayList<>();
        preOrder(root, preList);
        
        ArrayList<Integer> postList = new ArrayList<>();
        postOrder(root, postList);
        
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    public void postOrder(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.value);
    }
    
    public void preOrder(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        
        list.add(root.value);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
    
    public void insert(Node root, Node other){
        if(other.x < root.x){
            if(root.left == null) {
                root.left = other;
            } else{
                insert(root.left, other);   
            }
        } else{
            if(root.right == null){
                root.right = other;
            } else{
                insert(root.right, other);
            }
        }
    }
    
    public Node findRoot(Node[] nodeArr){
        Node root = nodeArr[0];
        for(int i = 1; i < nodeArr.length; i++){
            insert(root, nodeArr[i]);
        }
        return root;
    }
    
    public class Node{
        int value;
        int x;
        int y;
        
        Node left;
        Node right;
        
        public Node(int value, int x, int y){
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
}
