import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;


public class WeightedGraph{

    private class Node{
        private String value;
        private List<Edge> edges = new ArrayList<>(); 
        
        public Node(String value){
            this.value = value;
        }

        public void addEdge(Node to,int weight){
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges(){
            return edges;
        }

        @Override
        public String toString(){
            return this.value;
        }

    }

    private class Edge{
        Node from;
        Node to;
        int weight;

        public Edge(Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public String toString(){
            return from.toString()+" ->"+to.toString();
        }
    }

    private Map<String, Node> nodes = new  HashMap<>();
    // private  Map<Node, List<Edge>> adjacencyList = new  HashMap<>();

    public void insertNode(String value){
        // var newNode = new Node(value);
        nodes.putIfAbsent(value, new Node(value));
        // nodes.putIfAbsent(value, newNode);
        // adjacencyList.putIfAbsent(newNode, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        var newEdge = new  Edge(fromNode, toNode, weight);
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
        // adjacencyList.get(fromNode).add(newEdge);
        // adjacencyList.get(toNode).add(newEdge);
    }

    public void print(){

        for (var node : nodes.values()){
            var edges = node.getEdges();
            if(!edges.isEmpty())
                System.out.println(node+" : connected to "+edges);
        }

        // for (var source :  adjacencyList.keySet()){
        //     var targets = adjacencyList.get(source);
        //     if(!targets.isEmpty())
        //         System.out.println(source+": connected to "+targets);
        // }
    }

    private class NodeEntry{
        private  Node node;
        private int priority;

        public NodeEntry(Node node, int priority){
            this.node = node;
            this.priority = priority;
        }
    }

    public int getShortestDistance(String from, String to){

        var fromNode =  nodes.get(from);
        Map<Node, Integer> distances = new HashMap<>();

        for (var node: nodes.values()){
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(fromNode, 0);
 
        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry>  queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));

        queue.add(new  NodeEntry(fromNode, 0));

        while(!queue.isEmpty()){
            var current = queue.remove().node;
            visited.add(current);

            for(var edge : current.getEdges()){
                if(visited.contains(edge.to))
                    continue;

                var newDistance  = distances.get(current)+  edge.weight;
                if(newDistance < distances.get(edge.to)){
                    distances.replace(edge.to, newDistance);
                    queue.add(new  NodeEntry(edge.to, newDistance));
                }
            }
        }
        return distances.get(nodes.get(to));
    }

    public Path getShortestPath(String from, String to){

        var fromNode =  nodes.get(from);
        var toNode =  nodes.get(to);
        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();
        Map<Node, Integer> distances = new HashMap<>();

        for (var node: nodes.values()){
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(fromNode, 0);

        Map<Node> previousNodes = new HashMap<>();
 
        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry>  queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));

        queue.add(new  NodeEntry(fromNode, 0));

        while(!queue.isEmpty()){
            var current = queue.remove().node;
            visited.add(current);

            for(var edge : current.getEdges()){
                if(visited.contains(edge.to))
                    continue;

                var newDistance  = distances.get(current)+  edge.weight;
                if(newDistance < distances.get(edge.to)){
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new  NodeEntry(edge.to, newDistance));
                }
            }
        }

        return buildPath(previousNodes, toNode);
    }

    private  Path buildPath(Map<Node, Node>  previousNodes, Node  toNode){
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        var  previous  =  previousNodes.get(toNode);
        while(previous  != null){
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while (stack.isEmpty())
            path.add(stack.pop().value);

        return path;
    }

    public boolean hasCycle(){
        Set<Node> visited =  new HashSet<>();
        for(var  node : nodes.values()){
            if(!visited.contains(node) && hasCycle(node, null,visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Node parentNode, Set<Node> visited){
        visited.add(node);

        for(var edge: node.edges){
            if(edge.to == parentNode)
                continue;        
            if(visited.contains(edge.to) || hasCycle(edge.to, node, visited))
                return true;
        }

        return false;
    }

    public WeightedGraph getMinimumSpanningTree(){
        var  tree = new WeightedGraph();
        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e  -> e.weight));
        
        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.insertNode(startNode.value);

        while(tree.nodes.size() < nodes.size()){
            var minEdge = edges.remove();
            var nextNode = minEdge.to;

            if(containsNode(nextNode.value))
                continue;
            
            tree.insertNode(nextNode.value);
            tree.addEdge(minEdge.from.value, minEdge.to.value, minEdge.weight);

            for(var edge : nextNode.getEdges())
                if(!tree.containsNode(edge.to.value))
                    edges.add(edge);
            
        }
        return tree;
    }

    public boolean containsNode(String label){
        return nodes.containsKey(label);
    }

}