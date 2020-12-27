import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    
    public static final int ALPHABET_SIZE=25;
    
    private  class Node{
        private char value;
        //Array implementation
        //private Node [] childNodes = new Node[ALPHABET_SIZE];
        
        private HashMap<Character, Node> childNodes = new HashMap<>(); 

        private boolean isEndOfWord;

        public Node(char value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Value : "+ value;
        }

        public boolean hasChild(Character ch){
            return childNodes.containsKey(ch);
        }

        public void insertChild(Character value){
            childNodes.put(value, new Node(value));
        }

        public Node getChildNode(Character ch){
            return childNodes.get(ch);
        }

        public Node [] getChildren(){
            return childNodes.values().toArray(new Node[0]);
        }

        public boolean hasAnyChildren(){
            return !childNodes.isEmpty();
        }  
        
        public void removeChild(Character ch){
            childNodes.remove(ch);
        }

    }

    private Node root = new Node(' ');
    
    public  void insertNode(String word){
        var current =  root;
        for ( char ch : word.toCharArray()){
            if(!current.hasChild(ch))
                current.insertChild(ch);
            current = current.getChildNode(ch);

            // Array implementation
            // var index =  ch -'a';
            // if(current.childNodes[index] == null)
            //     current.childNodes[index] =  new  Node (ch);
            // current = current.childNodes[index];
        }
        current.isEndOfWord = true;

    }

    public boolean contains(String word){
        var current = root;
        for (var ch : word.toCharArray()){
            if(!current.hasChild(ch))
                return false;
            current=current.getChildNode(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse(){
        traverse(root);
    }

    private void traverse(Node root){
        for(var child: root.getChildren()){
            traverse(child);
        }
        System.out.println(root.value);
    }

    public void delete(String word){
        if (word == null)
            throw new  IllegalArgumentException();
        delete(word, root, 0);
    }

    private  void delete(String word, Node root, int index){
        if(index == word.length()){
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChildNode(ch);
        if(child == null)
            return;

        delete(word, child, index+1);

        if (!child.hasAnyChildren() && !child.isEndOfWord){
            root.removeChild(ch);
        }
    }

    public List<String> findWords(String prefix){
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);

        return words;

    }
    
    private void findWords(Node root, String prefix, List<String> words){
        if(root == null)
            return;

        if(root.isEndOfWord)
            words.add(prefix);

        for(var child: root.getChildren())
            findWords(child, prefix+child.value, words);

    }

    private Node findLastNodeOf(String prefix){
        var current =root;
        for (var ch : prefix.toCharArray()){
            var child = current.getChildNode(ch);
            if (child == null)
                return null;

            current = child;
        }
        return current;
    }

    // non recursion
    // private void delete(String word, Node root){
    //     var current = root;
    //     for (var ch: word.toCharArray()){
    //         if(!current.hasChild(ch))
    //             return;
    //         current = current.getChildNode(ch);
    //     }
    //     if (current.isEndOfWord)
    //         current.isEndOfWord = false;
    // }
}
