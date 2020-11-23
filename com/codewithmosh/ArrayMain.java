

public class ArrayMain {

    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(50);
        numbers.insert(60);
        //numbers.removeAt(3);
        numbers.print();
        System.out.println("-------------------");
        numbers.reverseArr();


        // int [] arr1 = {11,21,30};
        // int [] arr2 = {10,11,21};

        // int [] finalArr = numbers.intersect(arr1, arr2);
        // for (int i=0;i<finalArr.length; i++)
        //     System.out.println(finalArr[i]);
    }

}
