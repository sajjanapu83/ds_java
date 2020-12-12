public class LLMain {
    public static void main(String[] args) {
        SampleLinkedList newList = new SampleLinkedList();
        newList.addLast(10);
        newList.addLast(20);
        newList.addLast(30);
        newList.addLast(40);
        newList.addLast(50);
        newList.addLast(60);
        newList.addLast(70);
        //newList.createLoop();
        
        //newList.reverseList();
        //newList.print();
        //int result = newList.findKthElementFromList(4);
        //System.out.println(newList.hasLoop());
        newList.printMiddleValue();
               
    }
}
