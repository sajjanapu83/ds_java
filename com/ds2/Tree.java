public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value = " + value;
        }
    }

    private Node root;

    public void insert(int value) {
        var newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }
        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        // Empty tree check
        if (root == null) {
            return false;
        }
        // traversing the tree
        var current = root;
        while (current != null) {
            // check if the root is the value
            if (current.value == value) {
                return true;
            }

            // left path
            if (value < current.value) {
                current = current.leftChild;
            }
            // right path
            if (value > current.value) {
                current = current.rightChild;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);

    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        // if (root == null)
        //     return -1;

        if (isLeafNode(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int minimum() {
        if (root == null)
            throw new IllegalStateException();

        // var current = root;
        // var last = current;
        // while (current != null) {
        //     last = current;
        //     current = current.leftChild;
        // }
        // return last.value;
        
        return minimum(root);
    }

    private int minimum(Node root) {
        if (isLeafNode(root))
            return root.value;

        // if (root.leftChild == null || root.rightChild == null)
        //     return Integer.MAX_VALUE;
        
        var left = minimum(root.leftChild);
        var right = minimum(root.rightChild);

        return Math.min(root.value, Math.min(left, right));
    }

    private boolean isLeafNode(Node root) {
        return (root.leftChild == null && root.rightChild == null);
    }

    public boolean equals(Tree other) {
        if (other == null)
            return false;

        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null) {
            return (first.value == second.value && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild));
        }
        return false;
    }

    public void swapRoot(){
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }
    
    public boolean isBinaryTree(){
        return isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinaryTree(Node root, int min, int max){
        if (root == null)
            return true;
        
        if (root.value < min || root.value > max)
            return false;

        return (isBinaryTree(root.leftChild,min,root.value -1) && isBinaryTree(root.rightChild, root.value +1, max));
    }

    public void nodesAtDistance(int distance){
        if (root == null)
            throw new IllegalArgumentException();
        
        nodesAtDistance(root, distance);
    }
    
    private void nodesAtDistance(Node root, int distance){
        if(isLeafNode(root) && distance != 0)
            throw new IllegalArgumentException();

        if (distance == 0){
            System.out.println(root.value);
            return;
        }
        nodesAtDistance(root.leftChild, distance - 1);
        nodesAtDistance(root.rightChild, distance - 1);
    }
}
