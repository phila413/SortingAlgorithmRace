package Sorting;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SelectionTest {
    
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
	swap(arrayTest, 0, 2);
	tests.put(0, arrayTest);
	ArrayList<Integer> arrayTest1 = new ArrayList<Integer>(arrayTest);
	swap(arrayTest1, 1, 4);
	tests.put(1, arrayTest1);
	ArrayList<Integer> arrayTest2 = new ArrayList<Integer>(arrayTest1);
	swap(arrayTest2, 2, 4);
	tests.put(2, arrayTest2);
	ArrayList<Integer> arrayTest3 = new ArrayList<Integer>(arrayTest2);
	swap(arrayTest3, 3, 5);
	tests.put(3, arrayTest3);
	ArrayList<Integer> arrayTest4 = new ArrayList<Integer>(arrayTest3);
	swap(arrayTest4, 4, 6);
	tests.put(4, arrayTest4);
	ArrayList<Integer> arrayTest5 = new ArrayList<Integer>(arrayTest4);
	swap(arrayTest5, 5, 5);
	tests.put(5, arrayTest5);
	
	
	Selection sortingArray = new Selection(array);
	for(int x = 0; x < array.size()-1; ++x) {
	    sortingArray.swapMin(x);
	    assertEquals("Array Does not match", sortingArray.getArray(), tests.get(x));
	}
	
    }

    @Test
    public void TestSorting() {
	ArrayList<Integer> array = new ArrayList<Integer>();
	for(int x = 0; x < 10000; x++) {
	    array.add(x);
	}
	Collections.shuffle(array);
	Selection select = new Selection(array);
	Collections.sort(array);
	select.sort();
	assertEquals("arrays do not match", array, select.getArray());
    }
    
    private void swap (ArrayList<Integer> array, int spotOne, int spotTwo) {
	int temp = array.get(spotOne);
	array.set(spotOne,  array.get(spotTwo));
	array.set(spotTwo, temp);
    }
}
