import java.util.List;



public class GraphMain {
    public static void main(String[] args) {
        
        // FirstGraph graph = new FirstGraph();
        // graph.addNode("A");
        // graph.addNode("B");
        // graph.addNode("C");
        // graph.addNode("D");
        // graph.addNode("E");
        // graph.addEdge("A", "B");
        // graph.addEdge("A", "C");
        // graph.addEdge("B", "C");
        // graph.addEdge("B", "D");
        // graph.addEdge("D", "E");
        // graph.traverseBreadthFirst("A");
        // graph.traverseDepthFirst("A");
        // graph.traverseDepthFirstItr("A");
        // graph.print();
        // System.out.println("Done");


        // Graph graph = new Graph();
        // graph.addNode("Apple");
        // graph.addNode("Mango");
        // graph.addNode("Banana");
        // graph.addNode("Kiwi");
        // graph.addNode("Papaya");
        // graph.addNode("Cherry");
        // graph.addEdge("Apple", "Mango");
        // graph.addEdge("Apple", "Banana");
        // graph.addEdge("Apple", "Kiwi");
        // graph.addEdge("Mango", "Banana");
        // graph.addEdge("Mango", "Kiwi");
        // graph.addEdge("Banana", "Kiwi");
        // graph.addEdge("Mango", "Cherry");
        // graph.removeEdge("Mango", "Kiwi");
        // graph.removeNode("Banana");
        // graph.print();
        // graph.traverseDepthFirst("Apple");
        // graph.traverseDepthFirstItr("Apple");
        // graph.traverseBreadthFirst("Apple");


        //graph  for topology sort use case
        FirstGraph topoTest = new FirstGraph();
        // Graph  topoTest  = new Graph();
        topoTest.addNode("P");
        topoTest.addNode("X");
        topoTest.addNode("A");
        topoTest.addNode("B");
        topoTest.addNode("C");
        topoTest.addEdge("X", "A");
        topoTest.addEdge("X", "B");
        topoTest.addEdge("X", "C");
        topoTest.addEdge("A", "P");
        topoTest.addEdge("B", "P");
        topoTest.addEdge("C", "P");
        List<String> response = topoTest.topologicalSort();
        System.out.println(response);


        //Cycle test
        // Graph  cycleTest  = new Graph();
        // FirstGraph cycleTest = new FirstGraph();
        // cycleTest.addNode("A");
        // cycleTest.addNode("B");
        // cycleTest.addNode("C");
        // cycleTest.addNode("D");
        // cycleTest.addEdge("A", "B");
        // cycleTest.addEdge("B", "C");
        // cycleTest.addEdge("C", "D");
        // cycleTest.addEdge("C", "A");
        // var result =  cycleTest.hasCycle();
        // System.out.println(result);
    }
}
