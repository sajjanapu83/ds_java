public class Trie {
    
    public static final int ALPHABET_SIZE=25;
    
    private  class Node{
        private char value;
        private Node [] childNodes = new Node[ALPHABET_SIZE];
        private boolean isEndOfWord;

        public Node(char value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Value : "+ value;
        }
    }

    private Node root = new Node(' ');
    
    public  void insertNode(String word){

    }
}
