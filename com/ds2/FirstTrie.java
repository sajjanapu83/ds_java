import java.util.ArrayList;
import java.util.List;

public class FirstTrie {
    private TrieNode root = new TrieNode(' ');

    public void insertNode(String word){
        var current = root;
        for (var ch: word.toCharArray()){
            if(!current.hasAnyChildNodeWithValue(ch))
                current.addChildNodeWithValue(ch);
            current = current.getChildNode(ch);
        }
        current.setIsEndOfWord(true);
    }
    
    public boolean contains(String word){
        if( word == null)
            return false;

        var current = root;
        for (var ch: word.toCharArray()){
            if(!current.hasAnyChildNodeWithValue(ch))
                return false;
            current = current.getChildNode(ch);
        }
        return current.getIsEndOfWord();
    }

    public void delete(String word){
        delete(word, root, 0);
    }

    private void delete(String word, TrieNode root, int index){
        if(index == word.length()){
            root.setIsEndOfWord(false);
            return;
        }
        var ch = word.charAt(index);
        var child = root.getChildNode(ch);
        delete(word, child, index+1);
        if (!child.hasAnyChildren() && !child.getIsEndOfWord())
            root.removeChild(ch);
    }

    public List<String> findWords(String prefix){
        List<String> words = new ArrayList<>();
        var  lastNode = findLastNode(prefix);
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(TrieNode root, String prefix, List<String> words){
        if(root == null)
            return;

        if(root.getIsEndOfWord())
            words.add(prefix);
        
        for(var  child :  root.getChildren())
            findWords(child, prefix+child.getChildValue(), words);
    }

    private TrieNode findLastNode(String word){
        var current = root;
        for(var ch: word.toCharArray()){
            if (current.getChildNode(ch) == null)
                return null;
            current = current.getChildNode(ch);
        }
        return current;
    }

    public void  traverse(){
        traverse(root);
    }

    private void traverse(TrieNode root){
        System.out.println(root.getChildValue());
        for (var child : root.getChildren())
            traverse(child);
    }
}
