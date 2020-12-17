public class AVLTree {
    
    private class AVLNode{
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;
        public AVLNode(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Value = "+value;
        }
    }

    private AVLNode root;

    public void insertNode(int value){
        var newNode = new AVLNode(value);
        root = insertNode(root, newNode);
    }

    private AVLNode insertNode(AVLNode root, AVLNode newNode){
        if (root == null)
            return newNode;
        if (newNode.value < root.value)
            root.leftChild = insertNode(root.leftChild, newNode);
        if (newNode.value > root.value)
            root.rightChild = insertNode(root.rightChild, newNode);
           
        setHeight(root);
        return balace(root);
    }

    private AVLNode balace(AVLNode root){
        if(isLeftHeavy(root)){
            if(balanceFactor(root.leftChild) < 0)
                root.leftChild  =  rotateLeft(root.leftChild); // System.out.println("left rotate node : "+root.leftChild.value);
            return rotateRight(root); //System.out.println("right rotate node : "+root.value);
        }
        else if(isRightHeavy(root)){
            if(balanceFactor(root.rightChild) > 0)
                root.rightChild =  rotateRight(root.rightChild); //System.out.println("right rotate node : "+root.rightChild.value);
            return rotateLeft(root); //System.out.println("left rotate node : "+root.value);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root){
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root){
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);
        return  newRoot;
    }

    private void setHeight(AVLNode root){
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) +1;
    }

    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node)  >  1;
    }
    
    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node)  < -1;
    }
    
    private int balanceFactor(AVLNode node){
        return (node == null) ? 0 : height(node.leftChild)  - height(node.rightChild);
    }
    
    private int height(AVLNode node){
        return (node == null) ? -1 : node.height;
    }

}
