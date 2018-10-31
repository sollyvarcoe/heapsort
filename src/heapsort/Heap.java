package heapsort;
import static org.junit.Assert.assertNotNull;


public class Heap <E extends Comparable<E>> {
	private Object heapArray[];
	private int heapLast;
	private int heapSize;
	
	
	public Heap(int heapSize) throws Exception {
		if (heapSize <= 0) throw new Exception("Heap must be of size 1 or greater");
		this.heapSize = heapSize;
		heapArray = new Object[heapSize + 1];
		heapLast = 0;
		
		
		
	}
	
	public Heap() {
		this.heapSize = 64;
		heapArray = new Object[65];
		heapLast = 0;
		
	}
	
	public void addElement(E element) throws Exception{
		assertNotNull(element);
		if (heapFull()) throw new Exception("Heap is full");
		heapLast++;
		heapArray[heapLast] = element;
		heapifyUp();
	}
	
	private int compareObj(Object x, Object y) {
		return ((E) x).compareTo(((E) y));
	}
	
	private void heapifyUp() {
		int i = heapLast;
		while (i > 1) {	
			if (compareObj(heapArray[i],heapArray[i/2]) >= 0) return;
			Object temp = heapArray[i/2];
			heapArray[i/2] = heapArray[i];
			heapArray[i] = temp;
			
		}
	}
	
	private void heapifyDown() {
		int i = 1;
		int leftCh = i*2;
		int rightCh = leftCh + 1;
		while (leftCh <= heapLast) { 
			int smallestCh = leftCh;
			if (rightCh <= heapLast) {
				smallestCh = smallest(leftCh, rightCh);
			}
			if (compareObj(heapArray[i],heapArray[smallestCh]) <= 0) return;
			Object temp = heapArray[smallestCh];
			heapArray[smallestCh] = heapArray[i];
			heapArray[i] = temp;
			i = smallestCh;
			leftCh = i*2;
			rightCh = leftCh + 1;
			
		}
	}

	private int smallest(int leftCh, int rightCh) {
		if (compareObj(heapArray[leftCh],heapArray[rightCh]) <= 0) return leftCh;
		return rightCh;
		
	}

	public E extractMin() throws Exception{
		if (isEmpty()) throw new Exception("Heap is empty");
		E extracted = (E) heapArray[1];
		heapArray[1] = heapArray[heapLast];
		heapLast--;
		heapifyDown();
		return extracted;
		
	}
	
	public Boolean heapFull() {
		return heapSize == heapLast;
	}
	
	public Boolean isEmpty() {
		return (heapLast == 0);
	}
	
	public String toString() {
		String s = "[";
        for (int i = 1; i <= heapLast; i++) {
            s += heapArray[i];
            if (i != heapLast)
                s += ",";
        }
        return s + "]";
	}
	
	public Object[] heapSort() throws Exception {
		Object sorted[] = new Object[heapLast];
		
		int i = 0;
		while (!isEmpty()) {
			sorted[i] = extractMin();
			i++;
		}
		
		
		for (Object obj : sorted) {
			System.out.println(obj);
		}
		return sorted;
		
	}

	public int getHeapLast() {
		return heapLast;
	}
	
	public int getHeapSize() {
		return heapSize;
	}
}






