package JulyEighth;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class LC133 {
    Node cloneGraph(Node node) {
           Queue<Node> q = new LinkedList<>() ;

           HashMap<Integer,Node> map = new HashMap<>() ;

           Node head = new Node(node.val) ;

           q.add(head) ;

           map.put(node.val,head) ;

           while(!q.isEmpty()){
               Node parent = q.poll() ;

               Node parentCopy = map.get(parent.val) ;
               parentCopy.neighbors = new ArrayList<>() ;

               for(Node child: parent.neighbors){
                   Node childCopy = null ;
                   if(!map.containsKey(child.val)){
                       childCopy = new Node(child.val) ;
                       map.put(child.val,childCopy) ;
                       q.add(childCopy) ;
                   }else{
                       childCopy = map.get(child.val) ;
                   }

                   parentCopy.neighbors.add(childCopy) ;
               }
           }

           return head ;
    }
}
