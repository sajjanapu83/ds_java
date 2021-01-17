public class SelectionSort {
    public void sort(int [] array){
        for (int i=0; i <array.length;i++){
            int minIndex = i;
            for (int j=i;j<array.length; j++){
                if(array[minIndex] > array[j]){
                    minIndex = j;
                    swap(array, minIndex, i);
                }
            }
        }
    }

    private int [] swap(int [] array, int first, int second){
        var temp = array[first];
        array[first] = array [second];
        array[second] = temp;

        return array;
    }
}
