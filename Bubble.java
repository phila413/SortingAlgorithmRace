package Sorting;
import java.util.ArrayList;
import java.util.Collections;

public class Bubble {

    private ArrayList<Integer> array;
    private int size;
    
    public Bubble(ArrayList<Integer> givenArray) {
	array = new ArrayList<Integer>(givenArray);
	size = array.size()-1;
    }
    
    public void sort() {
	for(int x = 0; x < size; ++x) {
	    bubbleSwap(x);	    
	}
    }
    
    public void bubbleSwap(int x) {
	int spot = array.get(0);
	for(int y = 0; y < size - x; ++y) {
	    int nextSpot = array.get(y+1);
	    if(spot > nextSpot) {
		Collections.swap(array, y, y+1);
	    } else {
		spot = nextSpot;
	    }   
	}
    }
    
    public ArrayList<Integer> getArray() {
	return array;
    }
    
}
