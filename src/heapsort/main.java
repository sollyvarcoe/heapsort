package heapsort;

public class main {
	
	public static void main(String [] args) throws Exception {
		Heap<Integer> testHeap = new Heap<Integer>(64);
		testHeap.addElement(4);
		testHeap.addElement(3);
		testHeap.addElement(6);
		testHeap.addElement(5);
		testHeap.addElement(2);
		System.out.println(testHeap.toString());
		System.out.println(testHeap.getHeapLast());
	}
}
