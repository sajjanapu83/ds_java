import javax.lang.model.util.ElementScanner6;

public class Search{
    public int linearSearch(int []  array, int target){
        for (int i=0;i<array.length;i++)
            if(array[i] == target)
                return i;
        return -1;
    }

    public int binarySearchRcr(int [] array, int target){
        return binarySearchRcr(array, 0, array.length-1, target);
    }

    private int binarySearchRcr(int  [] array,  int first, int last,int target){
        if(last < first)
            return -1;

        var middle = (first + last)/2;
        if(target <  array[middle])
            return binarySearchRcr(array, first, middle-1, target);
        else if (target >  array[middle])
            return binarySearchRcr(array, middle+1, last, target);
        else
            return middle;
    }

    public int binarySearchItr(int [] array, int target){
        var left = 0;
        var right = array.length-1;

        while (left <= right){
            var middle = (left +right) / 2;

            if (array[middle] == target)
                return middle;

            if(array[middle] > target)
                right = middle -1;
            else
                left = middle+1;
        }
        return -1;
    }

    public int ternarySearch(int [] array, int target){
        return ternarySearch(array, 0, array.length-1, target);
    }

    private int ternarySearch(int  [] array,  int left, int right,int target){
        if(right < left)
            return -1;

        int partitionSize = (right - left)/3;
        int mid1 = left +partitionSize;
        int  mid2 = right - partitionSize;

        if(target == array[mid1])
            return mid1;

        if (target == array[mid2])
            return  mid2;
 
        if(target <  array[mid1])
            return ternarySearch(array, left, mid1-1, target);
        else if (target >  array[mid2])
            return ternarySearch(array, mid2+1, right, target);
        else
            return ternarySearch(array, mid1, mid2, target);
    }

    public  int jumpSearch(int []  array, int  target){
        int blockSize= (int)Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;
        
        while(start < array.length && array[next -1] < target){
            start = next;
            next += blockSize;
            if(next  > array.length)
                next = array.length;
        }

        for (int i=start; i<next; i++)
            if(array[i] == target)
                return i;
        return -1;
    }

    public int exponentialSearch(int [] array, int target){
        int bound = 1;
        while ( bound < array.length && array[bound] <  target)
            bound *= 2;
        
        var first = bound/2;
        var last =  Math.min(bound, array.length-1);
        return binarySearchRcr(array, first, last, target);
    }



}