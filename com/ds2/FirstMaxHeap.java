public class FirstMaxHeap {
    private static void heapify(int [] array){
        var lastParentIndex = array.length / 2 - 1;

        for (int i=lastParentIndex; i>=0;i--)
            heapify(array, i);
    }

    private static void heapify(int [] array, int index){
        var  largerIndex = index;

        var leftChildIndex = (index * 2) + 1;
        if(leftChildIndex < array.length && array[leftChildIndex] > array[index])
            largerIndex = leftChildIndex;
        
        var  righChildIndex = (index  * 2)  + 2;
        if(righChildIndex < array.length && array[righChildIndex] > array[index])
            largerIndex = righChildIndex;
        
        if (index == largerIndex)
            return;
        
        swapNodes(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swapNodes(int  [] array, int first, int second){
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
