import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Graph {

    public class Node {
        String label;

        public Node(String label) {
            this.label = label;
        }
    }

    HashMap<String,Node> hmapnodes = new HashMap<>();
    HashMap<Node, List<Node>> adjacencyList = new HashMap<>();



    public void addNode(String label){
        var node = new Node(label);
        hmapnodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node,new ArrayList<>());

    }

    public void addEdge(String from,String to){
        Node fromNode = hmapnodes.get(from);
        if(fromNode== null) throw new IllegalArgumentException();

        Node toNode = hmapnodes.get(to);
        if(toNode== null) throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
        adjacencyList.get(toNode).add(fromNode);// to make it bi directed

    }

    public void print(){
        for(Node source : adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty()){
                System.out.print(source.label +" is  connected to  : " );
                for(int i = 0 ; i < targets.size();i++){
                    System.out.print(targets.get(i).label +" ");
                }
                System.out.println();

            }
        }
    }

    public void removeNode(String label){
        Node node = hmapnodes.get(label);
        if(node == null) return;

        for(var n : adjacencyList.keySet()){
            adjacencyList.get(n).remove(node);
        }
        adjacencyList.remove(node);
        hmapnodes.remove(node);

    }

    public void removeEdge(String from,String to){
        Node fromNode =  hmapnodes.get(from);
        Node toNode = hmapnodes.get(to);

        if(fromNode == null || toNode== null) return;

        adjacencyList.get(fromNode).remove(toNode);
        adjacencyList.get(toNode).remove(fromNode);
    }







}
