public class SearchMain {
    public static void main(String[] args) {
        int [] list = {1,2,3,4,5,6,7,8,9};
        Search stream =  new Search();
        // var result = stream.linearSearch(list, 9);
        // var result =  stream.binarySearchRcr(list, 4);
        // var result =  stream.binarySearchItr(list, 4);
        // var result =  stream.ternarySearch(list, 6);
        // var result =  stream.jumpSearch(list, 4);
        var result =  stream.exponentialSearch(list, 9);
        System.out.println(result);
    }
}
