public class FirstAVLTree {

    private class AVLNode{
        private  int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;
        public  AVLNode(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Value = "+value+" Height = "+height;
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
        else
            root.rightChild = insertNode(root.rightChild, newNode);

        setHeight(root);
        return balanceTree(root);
    }

    private AVLNode balanceTree(AVLNode root){
        //check which side is heavy
        if (isLeftHeavy(root)){
            //check what type of rotation (R / LR)
            if(balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }
        if(isRightHeavy(root)){
            if(balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateRight(AVLNode root){
        var newRoot =   root.leftChild;
        root.leftChild =  newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateLeft(AVLNode root){
        var newRoot  = root.rightChild;
        root.rightChild  =  newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private boolean isLeftHeavy(AVLNode root){
        return (balanceFactor(root) > 1);
    }

    private boolean isRightHeavy(AVLNode root){
        return (balanceFactor(root) < -1);
    }

    private int balanceFactor(AVLNode root){
        return  (root == null ) ? 0 : height(root.leftChild) - height(root.rightChild);
    }

    private  void setHeight(AVLNode root){
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) +1;
    }

    private int  height(AVLNode root){
        return (root ==  null) ? -1 : root.height;
    }
}
