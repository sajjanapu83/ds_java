
import java.util.NoSuchElementException;

public class Array {
    private int count;
    private int[] items;

    // Creating an Arry for given length
    public Array(int size) {
        items = new int[size];
    }

    // to print the array on console.
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    /* 
    Inserting element - if array is full, then create an array double the size,
    copy all the elements to new Array, replace the items and the element at the end 
    */
    public void insert(int element) {
        if (count == items.length) {
            int[] newArray = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newArray[i] = items[i];
            }
            items = newArray;
        }
        items[count++] = element;
    }

    public void removeAt (int index){  
        
        if(index<0 || index >= count){
        throw new NoSuchElementException();
        }
        else{
            for (int i=index; i<count; i++){
                items[i]=items[i+1];
            }
            count--;
        }
    }

    public int indexof(int element){
        for (int i=0; i<count; i++){
            if (items[i] == element){
                return i;
            }
        }
        return -1;
    }

    public int max(){
        int max = items[0];       
        for ( int i=1; i < items.length; i++){
            if (max < items[i]){
                max = items[i];
            }
        }
        return max;
    }

    public int [] intersect(int [] arr1, int [] arr2){
        int [] finalArr = new int [arr1.length];

        for (int i=0; i<arr1.length; i++){
            for (int j=0; j <arr2.length; j++){
                if (arr1[i] == arr2[j]){
                    finalArr[i] = arr1[i];
                }
            }    
        }
        return finalArr;
    }

    public void reverseArr(){
        int temp;
        int j =count -1;
        
        for (int i = 0; i < count / 2; i++){
            temp = items[i];
            items[i]=items[j-i];
            items[j-i]=temp;
        }
        print();
    }
}