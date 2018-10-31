package heapsort;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.*;

public class test {
	
	@Test
	public void testSort() {
		try {
			Heap<Integer> testHeap = new Heap<Integer>(64);
			testHeap.addElement(3);
			testHeap.addElement(2);
			testHeap.addElement(1);
			Object[] array = new Object[3];
			array[0] = 1;
			array[1] = 2;
			array[2] = 3;
			assertArrayEquals(array, testHeap.heapSort());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
