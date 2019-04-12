package view.visualization;

import processing.core.*;

public class SelectionSortVisualization extends PApplet {
	
	private static final long serialVersionUID = 1L;
	int[] toBeSorted;
	int currentIndex,minIndex;
	int xLocation;
	int widthOfRect , lengthOfArray;
	
	public void setup() {
		size(600,500);
		toBeSorted = new int[20];
		
		for(int i = 0 ; i < toBeSorted.length ; i++) {
			toBeSorted[i] = (int)(Math.random() * height);
		}
		minIndex = 0;
		currentIndex = 0;
		xLocation = width / toBeSorted.length;
		widthOfRect = xLocation - 1;
	}
	
	public void draw() {
		if(currentIndex >= toBeSorted.length)
			return;
		background(0);
		
		minIndex = currentIndex;
		
		for(int j = currentIndex + 1 ; j < toBeSorted.length ;j++) {
			if(toBeSorted[j] < toBeSorted[minIndex]) {
				minIndex = j;
			}
		}
		
		for(int i = 0 ; i < toBeSorted.length ; i++) {
			fill(255);
		    if (i==currentIndex)
			    fill(255, 255, 66);
		    if (i==minIndex)
		    	fill(0, 153, 14);
		    if (i<currentIndex)
			    fill(254, 64, 13);
		    rect(i*xLocation, height-toBeSorted[i], widthOfRect , toBeSorted[i]);
		    delay(15);
		}

		int temp = toBeSorted[currentIndex];
		toBeSorted[currentIndex] = toBeSorted[minIndex];
		toBeSorted[minIndex] = temp;

		currentIndex++;

	}


}
