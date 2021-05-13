package Sorting;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.junit.Test;

public class BubbleTest {
    @Test
    public void TestIterations () {
	ArrayList<Integer> array = new ArrayList<Integer>();
	array.add(7);
	array.add(3);
	array.add(1);
	array.add(6);
	array.add(2);
	array.add(4);
	array.add(5);
	
	HashMap<Integer, ArrayList<Integer>> tests = new HashMap<Integer, ArrayList<Integer>>();
	ArrayList<Integer> arrayTest = new ArrayList<Integer>(array);
	swap(arrayTest, 0, 1);
	swap(arrayTest, 1, 2);
	swap(arrayTest, 2, 3);
	swap(arrayTest, 3, 4);
	swap(arrayTest, 4, 5);
	swap(arrayTest, 5, 6);
	tests.put(0, arrayTest);
	ArrayList<Integer> arrayTest1 = new ArrayList<Integer>(arrayTest);
	swap(arrayTest1, 0, 1);
	swap(arrayTest1, 2, 3);
	swap(arrayTest1, 3, 4);
	swap(arrayTest1, 4, 5);
	tests.put(1, arrayTest1);
	ArrayList<Integer> arrayTest2 = new ArrayList<Integer>(arrayTest1);
	swap(arrayTest2, 1, 2);
	tests.put(2, arrayTest2);
	
	Bubble sortingArray = new Bubble(array);
	for(int x = 0; x < 3; ++x) {
	    sortingArray.bubbleSwap(x);
	    assertEquals("Array Does not match", tests.get(x), sortingArray.getArray());
	    
	}
	
    }

    @Test
    public void TestSorting() {
	ArrayList<Integer> array = new ArrayList<Integer>();
	for(int x = 0; x < 5000; x++) {
	    array.add(x);
	}
	Collections.shuffle(array);
	Bubble bubble = new Bubble(array);
	Collections.sort(array);
	bubble.sort();
	assertEquals("arrays do not match", array, bubble.getArray());
    }
    
    private void swap (ArrayList<Integer> array, int spotOne, int spotTwo) {
	int temp = array.get(spotOne);
	array.set(spotOne,  array.get(spotTwo));
	array.set(spotTwo, temp);
    }
}
