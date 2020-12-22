public class Heap {
    private int[] items;
    private int size;

    public Heap(int value) {
        this.items = new int[value];
    }

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();
        items[size++] = value;
        bubbleUp();
    }

    public void remove() {
        if (isEmpty())
            throw new IllegalArgumentException();
        items[0] = items[--size];
        bubbleDown();
    }

    private void bubbleDown() {
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            var largestChildIndex = largestChildIndex(index);
            swapItems(index, largestChildIndex);
            index = largestChildIndex;
        }
    }

    private int largestChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (items[leftChildIndex(index)] > items[rightChildIndex(index)]) ? leftChildIndex(index)
                : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return (leftChildIndex(index) <= size);
    }

    private boolean hasRightChild(int index) {
        return (rightChildIndex(index) <= size);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isValidParent(int index) {
        if(!hasLeftChild(index))
            return true;
        
        var isValid = items[index] >= leftChild(index);
 
        if(hasRightChild(index))
            isValid &=  items[index] >= rightChild(index);

        return isValid;
    }

    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    private void bubbleUp() {
        var index = size - 1;
        while (index > 0 && items[index] > items[parent(index)]) {
            swapItems(index, parent(index));
            index = parent(index);
        }
    }

    public boolean isFull() {
        return size == items.length;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swapItems(int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
}
