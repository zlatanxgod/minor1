import java.util.*;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");


        graph.addEdge("A","B");
        graph.addEdge("B","C");
        graph.addEdge("C","D");
        graph.addEdge("D","A");

        graph.removeEdge("D","A");

        //graph.removeNode("C");

        graph.print();

    }

}