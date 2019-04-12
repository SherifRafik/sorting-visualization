package view.visualization;

import processing.core.*;

public class InsertionSortVisualization extends PApplet {


	private static final long serialVersionUID = 1L;
	
	private int[] toBeSorted;
	private int firstUnsortedIndex;
	private int xLocation;
	private int widthOfRect;
	
	public void setup() {
		size(600,500);
		toBeSorted = new int[20];
		
		for(int i = 0 ; i < toBeSorted.length ; i++) {
			toBeSorted[i] = (int)(Math.random() * height);
		}
		
		xLocation = width / toBeSorted.length;
		widthOfRect = xLocation - 1;
		firstUnsortedIndex = 1;
	}

	public void draw() {
		if(firstUnsortedIndex >= toBeSorted.length)
			return;
		
		background(0);
		int newElement = toBeSorted[firstUnsortedIndex];
		int j;
		for(j = firstUnsortedIndex; j > 0 && toBeSorted[j - 1] > newElement ; j--) {
			toBeSorted[j] = toBeSorted[j - 1];
		}
				
		System.out.println(j);
		for(int i = 0 ; i < toBeSorted.length ; i++) {
			delay(15);
			fill(255);
		    rect(i*xLocation, height-toBeSorted[i], widthOfRect , toBeSorted[i]);
		}		
		toBeSorted[j] = newElement;


		firstUnsortedIndex++;
	}
}
