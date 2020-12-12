public class FirstTree {
    // Skeleton
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node is : " + value;
        }
    }

    private Node root;

    // insert elements in to binary search tree
    public void insertNode(int value) {
        var newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        var current = root;
        while (true) {
            // left path
            if (current.value > value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            }
            // right path
            else if (current.value < value) {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            } else {
                System.out.println("Node value already exists");
                break;
            }

        }
    }

    public boolean findNode(int value) {
        if (root == null)
            throw new IllegalArgumentException();

        var current = root;
        while (current != null) {
            if (current.value == value)
                return true;

            if (value < current.value) {
                current = current.leftChild;
            }

            if (value > current.value) {
                current = current.rightChild;
            }
        }
        return false;
    }

    public int minimum() {
        if (root == null)
            return -1;

        return minimum(root);
    }

    private int minimum(Node root) {
        int left = 0;
        int right = 0;

        // return value of node at leaf
        if (root.leftChild == null && root.rightChild == null)
            return root.value;
        // if node has only one child then other child value should be Maximum value
        if (root.leftChild == null) {
            right = minimum(root.rightChild);
            left = Integer.MAX_VALUE;
        }
        if (root.rightChild == null) {
            left = minimum(root.leftChild);
            right = Integer.MAX_VALUE;
        }
        if (root.leftChild != null && root.rightChild != null) {
            right = minimum(root.rightChild);
            left = minimum(root.leftChild);
        }
        return Math.min(root.value, Math.min(left, right));
    }

    public int height() {
        if (root == null)
            return -1;

        return height(root);
    }

    private int height(Node root) {
        if (root.leftChild == null && root.rightChild == null)
            return 0;
        if (root.rightChild == null) {
            return 1 + Math.max(height(root.leftChild), Integer.MIN_VALUE);
        }
        if (root.leftChild == null) {
            return 1 + Math.max(height(root.rightChild), Integer.MIN_VALUE);
        }
        if (root.leftChild != null && root.rightChild != null)
            return 1 + Math.max(height(root.rightChild), height(root.leftChild));

        return -1;
    }

    public void nodesAtDistance(int distance) {
        if (root == null)
            System.out.println("Tree is empty .....");

        nodesAtDistance(root, distance);
    }

    private void nodesAtDistance(Node root, int distance) {
        if(root == null)
            return;

        if (root.leftChild == null && root.rightChild == null && distance != 0){
            throw new IllegalArgumentException();
        }
        
        if (distance == 0) {
            System.out.println(root.value);
            return;
        }
        if (root.rightChild == null) {
            nodesAtDistance(root.leftChild, distance - 1);
        }
        if (root.leftChild == null) {
            nodesAtDistance(root.rightChild, distance - 1);
        }
        if (root.leftChild != null && root.rightChild != null) {
            nodesAtDistance(root.leftChild, distance - 1);
            nodesAtDistance(root.rightChild, distance - 1);

        }

    }


}
