package view.visualization;

import java.util.ArrayList;

import processing.core.PApplet;

public class QuickSortVisualization extends PApplet{
	
	private static final long serialVersionUID = 1L;
	
	
	private int[] toBeSorted;
	private int[] backup;
	private int xLocation;
	private int widthOfRect;
	private ArrayList<Pair> swap;
	private int swapIndex;
	private boolean isSorted = false;
	public void setup() {
		size(600,500);
		toBeSorted = new int[20];
		swap = new ArrayList<Pair>();
		
		backup = new int[toBeSorted.length];
		for(int i = 0 ; i < toBeSorted.length ; i++) {
			toBeSorted[i] = (int)(Math.random() * height);
			backup[i] = toBeSorted[i];
		}
		
		xLocation = width / toBeSorted.length;
		widthOfRect = xLocation - 1;
		swapIndex = 0;
		sort();
		isSorted = true;
		System.out.println(swap.size());
	}
	
	public void draw() {
		background(0);
		for(int i = 0 ; i < backup.length ; i++) {
			fill(255);
			/*if(i == swap.get(swapIndex).firstValue)
				fill(255, 255, 66);
			if(i == swap.get(swapIndex).secondValue)
				fill(0, 153, 14);*/
		    rect(i*xLocation, height-backup[i], widthOfRect , backup[i]);
		    //delay(15);
		}
		
		if(swapIndex < swap.size()) {
			swap(backup , swap.get(swapIndex).firstValue , swap.get(swapIndex).secondValue);
			swapIndex++;
		}else
			return;
	}
	
	public void sort() {
		quickSort(toBeSorted, 0, toBeSorted.length - 1);
	}
	
	private void quickSort(int[] array, int start, int end) {
		if(start < end) {
			int partitionIndex = partition(array, start ,end);
			quickSort(array , start , partitionIndex - 1);
			quickSort(array, partitionIndex + 1 , end);
		}
	}
	
    private int partition(int[] array, int start, int end) 
    {
		int pivot = array[end];
		int lastSmall = start - 1;
		for(int i = start; i <= end ; i++) {
			if(array[i] <= pivot) {
				lastSmall++;
				swap(array,lastSmall,i);
			}
		}
		return lastSmall;
    }

    
	private void swap(int[] array , int i, int j) {
		if(!isSorted) {
			Pair currentSwap = new Pair(i , j);
			this.swap.add(currentSwap);
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
