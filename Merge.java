package Sorting;

import java.util.ArrayList;
import java.util.List;

public class Merge {

    private ArrayList<Integer> array;
    
    public Merge(ArrayList<Integer> givenArray) {
	array = new ArrayList<Integer>(givenArray);
    }
    
    public void sort() {
	array = (ArrayList<Integer>) recurseSort(array);
    }
    
    public List<Integer> recurseSort(List<Integer> array){
	
	if(array.size() == 1) {
	    return array;
	}
	
	List<Integer> firstHalf =  array.subList(0, array.size()/2);
	List<Integer> secondHalf =  array.subList(array.size()/2, array.size());
	
	firstHalf = recurseSort(firstHalf);	
	secondHalf = recurseSort(secondHalf);
	
	ArrayList<Integer> fullSortedArray = new ArrayList<Integer>();
	int x = 0;
	int y = 0;
	while (x < firstHalf.size() && y < secondHalf.size()) {
	    if(firstHalf.get(x) < secondHalf.get(y)) {
		fullSortedArray.add(firstHalf.get(x));
		++x;
	    }
	    else if(firstHalf.get(x) > secondHalf.get(y)) {
		fullSortedArray.add(secondHalf.get(y));
		++y;
	    }
	}
	while(x < firstHalf.size()) {
	    fullSortedArray.add(firstHalf.get(x));
	    ++x;
	}
	while(y < secondHalf.size()) {
	    fullSortedArray.add(secondHalf.get(y));
	    ++y;
	}
	return fullSortedArray;
    }
    
    public ArrayList<Integer> getArray() {
	return array;
    }
    
}
