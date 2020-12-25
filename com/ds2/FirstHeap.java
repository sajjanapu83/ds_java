public class FirstHeap {
    private int size;

    private int [] items;

    public FirstHeap(int size){
        this.items = new int [size];
    }

    public void insertNode(int value){
        if(isFull())
            throw  new IllegalStateException();

        items[size++] = value;
        bubbleUp();
    }

    private  void bubbleUp(){
        var index  = size-1; // index of the node getting added
        while(index > 0 && items[index] > items[getParentIndex(index)]){
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public int remove(){
        if(isEmpty())
            throw new IllegalArgumentException();

        var  root = items[0];
        items[0]  =  items[--size];
        bubbleDown();
        return root;
    }

    private void bubbleDown(){
        var index =0;
        while (index <= size && !isValidRoot(index)){
            var largestChildIndex = largestChildIndex(index);
            swap(index, largestChildIndex);
            index = largestChildIndex;
        }
    }

    private void swap(int first, int second){
        var  temp =  items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    private int largestChildIndex(int index){
        if(!hasLeftChild(index))
            return index;

        if(!hasRightChild(index))
            return getLeftChildIndex(index);

        return  (items[getLeftChildIndex(index)] > items[getRightChildIndex(index)])  
        ?  getLeftChildIndex(index) : getRightChildIndex(index);
    }

    private boolean isValidRoot(int index){
        if (!hasLeftChild(index))
            return true;
        
        var isValid = items[index] >= items[getLeftChildIndex(index)];
        if (hasRightChild(index))
            isValid &= items[index]  >=  items[getRightChildIndex(index)];

        return isValid;
    }

    private boolean hasLeftChild(int index){
        return (items[getLeftChildIndex(index)] > 0);
    }

    private  boolean hasRightChild(int index){
        return (items[getRightChildIndex(index)] > 0);
    }

    private int getLeftChildIndex(int index){
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index){
        return (index * 2) + 2;
    }

    private int getParentIndex(int childIndex){
        return (childIndex - 1 ) / 2;
    }

    private boolean isFull(){
        return size == items.length;
    }

    private boolean isEmpty(){
        return size == 0;
    }
    
}
