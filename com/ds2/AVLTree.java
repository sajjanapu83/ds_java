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
           
        root.height = 1 + Math.max(height(root.leftChild), height(root.rightChild));

        //var balanceFactor =  height(root.leftChild) - height(root.rightChild);
        
        if(isLeftHeavy(root)){
            System.out.println(root.value+" is left heavy");

        }
        else if(isRightHeavy(root)){
            System.out.println(root.value+" is right heavy"); 
            
        }      
        
        return root;
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
