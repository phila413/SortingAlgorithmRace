package Sorting;

import java.util.ArrayList;

public class Radix {

    private ArrayList<Integer> array;
    
    public Radix(ArrayList<Integer> givenArray) {
	array = new ArrayList<Integer>(givenArray);
    }
    
    public ArrayList<Integer> sort() {
	int max = array.get(0);
	for (int x = 0; x < array.size(); ++x) {
	    if (array.get(x) > max) {
		max = array.get(x);
	    }
	}
	
	for (int x = 1; x < max; x *= 10) {
	    array = digitSort(x);
	}
	
	return array;
    }
    
    public ArrayList<Integer> digitSort(int digitSize) {
	int[] count = new int[10];
	int[] totalCount = new int[10];
	int[] output = new int[array.size()];
	
	for (int x = 0; x < array.size(); ++x) {
	    count[(array.get(x) / digitSize) % 10]++; 
	}
	totalCount[0] = count[0];
	for (int x = 1; x < 10; ++x) {
	    totalCount[x] = totalCount[x-1] + count[x];
	}

	for (int x = 0; x < array.size(); ++x) {
	    int digit = (array.get(x) / digitSize) % 10;
	    output[totalCount[digit] - count[digit]] = array.get(x);
	    totalCount[digit]++;
	}
	
	for(int x = 0; x < array.size(); ++x) {
	    array.set(x, output[x]);
	}
	
	return array;
    }
    
    public ArrayList<Integer> getArray() {
	return array;
    }
    
}
