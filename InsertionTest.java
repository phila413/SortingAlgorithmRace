package Sorting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.junit.Test;

public class InsertionTest {
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
	tests.put(1, arrayTest);
	ArrayList<Integer> arrayTest1 = new ArrayList<Integer>(arrayTest);
	swap(arrayTest1, 1, 2);
	swap(arrayTest1, 0, 1);
	tests.put(2, arrayTest1);
	ArrayList<Integer> arrayTest2 = new ArrayList<Integer>(arrayTest1);
	swap(arrayTest2, 2, 3);
	tests.put(3, arrayTest2);
	ArrayList<Integer> arrayTest3 = new ArrayList<Integer>(arrayTest2);
	swap(arrayTest3, 3, 4);
	swap(arrayTest3, 2, 3);
	swap(arrayTest3, 1, 2);
	tests.put(4, arrayTest3);
	ArrayList<Integer> arrayTest4 = new ArrayList<Integer>(arrayTest3);
	swap(arrayTest4, 4, 5);
	swap(arrayTest4, 3, 4);
	tests.put(5, arrayTest4);
	ArrayList<Integer> arrayTest5 = new ArrayList<Integer>(arrayTest4);
	swap(arrayTest5, 5, 6);
	swap(arrayTest5, 4, 5);
	tests.put(6, arrayTest5);
	
	
	Insertion sortingArray = new Insertion(array);
	for(int x = 1; x < array.size(); ++x) {
	    sortingArray.findAndSwapMin(x);
	    assertEquals("Array Does not match", tests.get(x), sortingArray.getArray());
	}
	
    }

    @Test
    public void TestSorting() {
	ArrayList<Integer> array = new ArrayList<Integer>();
	for(int x = 0; x < 10000; x++) {
	    array.add(x);
	}
	Collections.shuffle(array);
	Insertion insertion = new Insertion(array);
	Collections.sort(array);
	insertion.sort();
	assertEquals("arrays do not match", array, insertion.getArray());
    }
    
    private void swap (ArrayList<Integer> array, int spotOne, int spotTwo) {
	int temp = array.get(spotOne);
	array.set(spotOne,  array.get(spotTwo));
	array.set(spotTwo, temp);
    }
}
