package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class Insertion {
private ArrayList<Integer> array;
    
    public Insertion(ArrayList<Integer> givenArray) {
	array = new ArrayList<Integer>(givenArray);
    }
    
    public void sort() {
	for(int x = 1; x < array.size(); ++x) {
	    findAndSwapMin(x);	    
	}
    }
    
    public void findAndSwapMin(int x) {
	while(x != 0 && array.get(x) < array.get(x-1)) {
	    Collections.swap(array, x, x-1);
	    --x;
	}
    }
    
    public ArrayList<Integer> getArray() {
	return array;
    }
}
