public class SecondTree {
    private class Node{
        int value;
        Node leftChild;
        Node rightChild;
        public Node(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Node is : "+value;
        }
    }
    
    private Node root;
    
    public void insertNode(int value){
        var newNode = new Node(value);
        if (root == null){
            root = newNode;
        }
        else{
            var current = root;
            while(true){
                if (value < current.value){
                    if (current.leftChild == null){
                        current.leftChild = newNode;
                        break;
                    }
                    current = current.leftChild;
                }
                if (value > current.value){
                    if (current.rightChild == null){
                        current.rightChild = newNode;
                        break;
                    }
                    current = current.rightChild;
                }
            }
        }
    }

    public boolean findNode(int value){
        var current = root;
        while (current != null){
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void traverseTree(){
        traverseTree(root);
    }

    private void traverseTree(Node root){
        if (root == null)
            return;
        // Pre - Root, LC, RC
        // In - LC, Root, RC
        // Post- LC, RC, Root    
        System.out.println(root.value);
        traverseTree(root.leftChild);
        traverseTree(root.rightChild);
    }

    public int  height(){
        return height(root);
    }

    private int height(Node root){
        if (root.leftChild == null && root.rightChild == null)
            return 0;       
        if (root.leftChild == null)
            return 1 +  Math.max(Integer.MIN_VALUE, height(root.rightChild));
        if (root.rightChild == null)
            return 1 +  Math.max(Integer.MIN_VALUE, height(root.leftChild));
        if (root.leftChild != null && root.rightChild != null)  
            return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    return -1;
    }

    public int minimum(){
        return minimum(root);
    }

    private int minimum(Node root){
        if(root.leftChild == null && root.rightChild == null)
            return root.value;
        if (root.leftChild == null)
            return Math.min(root.value, Math.min(minimum(root.rightChild),Integer.MAX_VALUE));
        if (root.rightChild == null)
            return Math.min(root.value, Math.min(minimum(root.leftChild),Integer.MAX_VALUE));
        if (root.leftChild != null && root.rightChild != null)
            return Math.min(root.value, Math.min(minimum(root.leftChild), minimum(root.rightChild)));
        return -1;
    }

    public  void nodesAtDistance(int distance){
        if (distance > height(root))
            throw new IllegalArgumentException();

        nodesAtDistance(root, distance);
    }

    private void nodesAtDistance(Node root, int distance){
        // TODO - Edge case for node is leaf node and distance is not zero
        
        if (root == null)
            return;
        
        if(distance == 0){
            System.out.println(root.value);
            return;
        }

        nodesAtDistance(root.leftChild, distance-1);
        nodesAtDistance(root.rightChild, distance-1);

    }

    public boolean isBinaryTree(){
        return isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinaryTree(Node root, int min, int max){
        if (root == null)
            return true;

        if (min > root.value || max < root.value)
            return false;

        return isBinaryTree(root.leftChild, min, root.value -1)  
        && isBinaryTree(root.rightChild, root.value +1, max);
    }

    public void swapRoots(){
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }
}
