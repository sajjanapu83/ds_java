import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
    
    private class Node{
        private String label;
    
        public Node(String label){
            this.label = label;
        }
    
        @Override
        public String toString(){
            return this.label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label){
        var newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
        adjacencyList.putIfAbsent(newNode, new ArrayList<>());
    }

    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();
        
        adjacencyList.get(fromNode).add(toNode);
    }

    public void print(){
        for (var source : adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source+" is connected to - "+targets);
        }
    }

    public void removeNode(String label){
        var node = nodes.get(label);
        if(node == null)
            return;
        
        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to){
        var  fromNode = nodes.get(from);
        var  toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirst(String root){
        var node = nodes.get(root);

        if (node ==  null)
            return;

        traverseDepthFirst(node, new HashSet<>());
    }

    private void traverseDepthFirst(Node root, Set<Node> visited){
        System.out.println(root);
        visited.add(root);

        for(var node : adjacencyList.get(root)){
            if(!visited.contains(node))
                traverseDepthFirst(node, visited);
        }
    }

    public void traverseDepthFirstItr(String root){
        var node = nodes.get(root);

        if (node ==  null)
            return;
        
        Set<Node> visited = new HashSet<>();
        Stack<Node>  toVisit = new Stack<>();
        toVisit.push(node);

        while(!toVisit.isEmpty()){
            var current = toVisit.pop();
            if(visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for(var neighbor : adjacencyList.get(current)){
                if(!visited.contains(neighbor))
                    toVisit.push(neighbor);
            }            
        }
    }

    public void  traverseBreadthFirst(String root){
        var rootNode = nodes.get(root);

        if(rootNode == null)
            return;

        Set<Node> visited = new HashSet<>();
        Queue<Node>  toVisit = new ArrayDeque<>();
        toVisit.add(rootNode);

        while(!toVisit.isEmpty()){

            var current = toVisit.remove();
            if(visited.contains(current))
                continue;
            
            System.out.println(current);
            visited.add(current);

            for(var neighbor : adjacencyList.get(current)){
                if (!visited.contains(neighbor))
                    toVisit.add(neighbor);
            }
        }

    }

    public List<String> topologicalSort(){
        List<String>  response = new ArrayList<>();
        Stack<Node> result = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for(var node : nodes.values())
            topologicalSort(node, visited, result);

        while(!result.empty()){
            response.add(result.pop().label);
        }

        return response;
    }

    private void  topologicalSort(Node node, Set<Node> visited, Stack<Node> result){
        
        if(visited.contains(node))
            return;

        visited.add(node);

        for(var neighbor : adjacencyList.get(node))
            topologicalSort(neighbor, visited, result);

        result.push(node);
    }

    public boolean hasCycle(){
        Set<Node> all = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        Set<Node>  visited = new HashSet<>();
        all.addAll(nodes.values());
        
        while(!all.isEmpty()){
            var  current = all.iterator().next();
            if(hasCycle(current, all, visiting, visited))
                return true;           
        }
        return false;   
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node>  visited){
        all.remove(node);
        visiting.add(node);

        for(var neighbor : adjacencyList.get(node)){

            if(visited.contains(neighbor))
                continue;

            if(visiting.contains(neighbor))
                return true;

            if(hasCycle(neighbor, all, visiting, visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;

    }

}
