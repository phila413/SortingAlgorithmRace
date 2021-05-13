package Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Sorting.SortAlgo.algoType;

public class SortingMain {

    public static ArrayList<Integer> array = new ArrayList<Integer>();
    public static int repeat;
    public static int size;
    public static int update;
    
    public static void main(String[] args) {
	Scanner console = new Scanner(System.in);
	
	// Get specifications
	while (repeat < 10)
	{
    	    System.out.print("How many times should the algorithms be run: ");
    	    repeat = console.nextInt();
    	    if (repeat < 10)
    	    {
    		System.out.println("The algorithms need to run at least ten times (to gather an average)!");
    	    }
	}
	update = repeat / 10;
	while (size <= 0)
	{
	   System.out.print("How large should the arraylist be: ");
	   size = console.nextInt();
	   if (size <= 0)
	   {
	       System.out.println("The arraylists must have at least one item in them!");
	   }
	}	
	
	// Create array
	for(int x = 0; x < size; x++) {
	    array.add(x);
	}
	
	HashMap<algoType, int[]> data = new HashMap<algoType, int[]>();
	
	long startTime = System.currentTimeMillis();
	data.put(algoType.Selection, sort(algoType.Selection));
	data.put(algoType.Bubble, sort(algoType.Bubble));
	data.put(algoType.Insertion, sort(algoType.Insertion));
	data.put(algoType.Merge, sort(algoType.Merge));
	data.put(algoType.Radix, sort(algoType.Radix));
	data.put(algoType.Collections, sort(algoType.Collections));
	long endTime = System.currentTimeMillis();
	
	printData(data, endTime-startTime);
	
	console.close();
    }
    
    private static int[] sort(algoType sortType) {
	long startTime, endTime, totalTimeElapsed = 0;
	int[] sortData = new int[2];
	SortAlgo algorithm = new SortAlgo(sortType, array);
	
	System.out.printf("%-13s", (sortType.toString() + ":"));
	for (int x = 1; x < repeat+1; ++x) {
	    algorithm.randomize();
	    startTime = System.currentTimeMillis();
	    algorithm.sort();
	    endTime = System.currentTimeMillis();
    	    totalTimeElapsed += endTime - startTime;
    	    
    	    if(x % update == 0) {
    		if(x != update) {
    		    System.out.print(" -- ");
    		}
    		System.out.print((int) ((x / (double) repeat) * 100) + "%");
    	    } 
	}
	System.out.println();
	
	sortData[0] = (int) totalTimeElapsed;
	sortData[1] = (int) (totalTimeElapsed / repeat);
	return sortData;
    }

    private static void printData(HashMap<algoType, int[]> data, long totalTime) {
	int total = 0;
	System.out.println();
	System.out.println(" -------------------------------------------------------------");
	System.out.println(" |    Algorithm    |  Total Time (ms)  |  Average Time (ms)  |");
	System.out.println(" |-----------------|-------------------|---------------------|");
	for(algoType currentKey : data.keySet()){
	    System.out.printf(" | %-15s | %-17d | %-19d |\n", currentKey.toString(), data.get(currentKey)[0], data.get(currentKey)[1]);
	    total += data.get(currentKey)[0];
	}
	System.out.println(" -------------------------------------------------------------");
	System.out.println("  - Sample size: " + size + " numbers");
	System.out.println("  - Repeated:    " + repeat + " times");
	System.out.println("  - Time not sorting:    " + (totalTime - total) + " ms");
    }
    
}
