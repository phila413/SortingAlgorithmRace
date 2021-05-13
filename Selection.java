package Sorting;
import java.util.ArrayList;
import java.util.Collections;

public class Selection {

    private ArrayList<Integer> array;
    
    public Selection(ArrayList<Integer> givenArray) {
	array = new ArrayList<Integer>(givenArray);
    }
    
    public void sort() {
	for(int x = 0; x < array.size()-1; ++x) {
	    swapMin(x);	    
	}
    }
    
    public void swapMin(int x) {
	int min = x;
	for(int y = x+1; y < array.size(); ++y) {
	    if(array.get(min) > array.get(y)) {
		min = y;
	    }
	}
	Collections.swap(array, x, min);
    }
    
    public ArrayList<Integer> getArray() {
	return array;
    }
    
}
