import java.util.HashMap;

public class TrieNode {
    private char value;
    private HashMap<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isEndOfWord;

    public TrieNode(char ch){
        this.value = ch;
    }

    @Override
    public String toString(){
        return "Value : "+this.value;
    }

    public boolean hasAnyChildNodeWithValue(char ch){
        return childNodes.containsKey(ch);
    }

    public void addChildNodeWithValue(char ch){
        childNodes.put(ch, new TrieNode(ch));
    }

    public TrieNode getChildNode(char ch){
        return childNodes.get(ch);
    }

    public void setIsEndOfWord(boolean flag){
        this.isEndOfWord = flag;
    }

    public boolean getIsEndOfWord(){
        return this.isEndOfWord;
    }

    public boolean hasAnyChildren(){
        return !childNodes.isEmpty();
    }

    public void removeChild(char ch){
        childNodes.remove(ch);
    }

    public TrieNode [] getChildren(){
        return childNodes.values().toArray(new TrieNode[0]);
    }

    public char getChildValue(){
        return  this.value;
    }
}
