package Sorting;
import java.util.ArrayList;
import java.util.Collections;

public class SortAlgo {
    
    private algoType algorithm;
    private ArrayList<Integer> array;
    
    protected enum algoType {
	Selection, Bubble, Insertion, Merge, Radix, Collections
    }
    
    public SortAlgo(algoType givenType, ArrayList<Integer> givenArray) {
	algorithm = givenType;
	array = givenArray;
    }
    
    public void randomize() {
	Collections.shuffle(array);
    }
    
    public void sort() {
	switch(algorithm) {
	case Selection:
	    Selection select = new Selection(array);
	    select.sort();
	    array = select.getArray();
	    break;
    	case Bubble:
	    Bubble bubble = new Bubble(array);
	    bubble.sort();
	    array = bubble.getArray();
	    break;
    	case Insertion:
	    Insertion insertion = new Insertion(array);
	    insertion.sort();
	    array = insertion.getArray();
	    break;
    	case Merge:
	    Merge merge = new Merge(array);
	    merge.sort();
	    array = merge.getArray();
	    break;
    	case Radix:
	    Radix radix = new Radix(array);
	    radix.sort();
	    array = radix.getArray();
	    break;
    	case Collections:
    	    Collections.sort(array);
	    break;
	}
    }
    
    public ArrayList<Integer> getArray() {
	return array;
    }
    
}
