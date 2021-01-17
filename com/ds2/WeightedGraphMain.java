import java.util.PriorityQueue;

public class WeightedGraphMain {
    public static void main(String[] args) {
        WeightedGraph wGraph  = new WeightedGraph();
        wGraph.insertNode("A");
        wGraph.insertNode("B");
        wGraph.insertNode("C");
        wGraph.insertNode("D");
        wGraph.addEdge("A", "B", 3);
        wGraph.addEdge("A", "C", 3);
        wGraph.addEdge("B", "D", 2);
        wGraph.addEdge("C", "D", 2);
        wGraph.print();
    }


}
