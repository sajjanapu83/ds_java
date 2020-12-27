import java.util.List;

public class TrieMain {
    public static void main(String[] args) {
        // Trie trie = new Trie();
        FirstTrie trie = new FirstTrie();

        // trie.insertNode("PINK");
        // trie.insertNode("PINKER");
        // trie.insertNode("QIN");

        trie.insertNode("car");
        trie.insertNode("carl");
        trie.insertNode("carrot");
        trie.insertNode("carpet");
        trie.insertNode("care");
        trie.insertNode("word");
        // trie.delete("care");
        System.out.println(trie.findWords(""));
      

        // System.out.println(trie.contains("carpet"));
        // trie.insertNode("carpet");
        // trie.insertNode("cash");
        // List<String> words = trie.findWords("carp");
        // System.out.println(words);

        // trie.delete("car");
        // System.out.println(trie.contains("care"));
        

        //System.out.println(trie.contains("QINK"));
        // trie.traverse();
        // trie.delete("PINK");
        // System.out.println(trie.contains("PINKER"));
    }
}
