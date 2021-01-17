import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.List;

public class FirstGraph {

    private class Node {
        private String value;

        public Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String value) {
        if (value == null)
            throw new IllegalArgumentException();

        var newNode = new Node(value);

        if (nodes.containsKey(value))
            throw new IllegalArgumentException();

        nodes.put(value, newNode);
        adjacencyList.put(newNode, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (var node : adjacencyList.keySet()) {
            var neighbors = adjacencyList.get(node);
            if (!neighbors.isEmpty())
                System.out.println(node + " Connects with " + neighbors);
        }
    }

    public void removeNode(String value) {
        var node = nodes.get(value);
        if (node == null)
            return;

        for (var n : adjacencyList.keySet()) {
            adjacencyList.get(n).remove(node);
        }

        nodes.remove(value);
        adjacencyList.remove(node);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void traverseDepthFirst(String root) {
        var node = nodes.get(root);
        if (node == null)
            return;

        traverseDepthFirst(node, new HashSet<>());
    }

    private void traverseDepthFirst(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);

        for (var neighbor : adjacencyList.get(root)) {
            if (!visited.contains(neighbor))
                traverseDepthFirst(neighbor, visited);
        }
    }

    public void traverseDepthFirstItr(String root) {
        var rootNode = nodes.get(root);
        if (root == null)
            return;
        Stack<Node> toVisit = new Stack<>();
        Set<Node> result = new HashSet<>();
        toVisit.push(rootNode);
        while (!toVisit.empty()) {
            var current = toVisit.pop();
            if (result.contains(current))
                continue;
            System.out.println(current);
            result.add(current);
            for (var neighbor : adjacencyList.get(current)) {
                if (!result.contains(neighbor))
                    toVisit.push(neighbor);
            }
        }
    }

    public void traverseBreadthFirst(String root) {
        var rootNode = nodes.get(root);
        if (root == null)
            return;

        Set<Node> result = new HashSet<>();
        Queue<Node> toVisit = new ArrayDeque<>();
        toVisit.add(rootNode);

        while (!toVisit.isEmpty()) {
            var current = toVisit.remove();

            if (result.contains(current))
                continue;

            System.out.println(current);
            result.add(current);

            for (var neighbor : adjacencyList.get(current)) {
                if (!result.contains(neighbor))
                    toVisit.add(neighbor);
            }
        }
    }

    public List<String> topologicalSort() {
        List<String> response = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        Stack<Node> result = new Stack<>();

        for (var node : nodes.values()) {
            if (node != null)
                topologicalSort(node, visited, result);
        }
        while (!result.isEmpty()) {
            response.add(result.pop().value);
        }
        return response;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> result) {
        visited.add(node);
        result.push(node);

        for(var neighbor : adjacencyList.get(node)){
            if(!visited.contains(neighbor))
                topologicalSort(neighbor, visited, result);
        }
    }

    public boolean hasCycle() {
        Set<Node> allNodes = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        allNodes.addAll(nodes.values());

        while (!allNodes.isEmpty()) {
            var current = allNodes.iterator().next();
            if (hasCycle(current, allNodes, visiting, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> allNodes, Set<Node> visiting, Set<Node> visited) {
        allNodes.remove(node);
        visiting.add(node);
        
        //validation and recursion
        for (var neighbor : adjacencyList.get(node)){
            if (visiting.contains(neighbor))
                return true;
            if(!visited.contains(neighbor)){
                if(hasCycle(neighbor, allNodes, visiting, visited))
                    return true;
            }
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }

}
