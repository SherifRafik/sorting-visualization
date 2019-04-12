package view.visualization;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Visualizer extends JFrame {
	
	private static final long serialVersionUID = 1L;
	String sortingTechnique;
	
    public Visualizer(String sortingTechnique) {
    	this.sortingTechnique = sortingTechnique;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        init();
    }
    
    
    private void init() {
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    	if(sortingTechnique.equals("Selection Sort"))
    		selectionSortVisualization();
    	else if(sortingTechnique.equals("Insertion Sort"))
    		insertionSortVisualization();
    	else if(sortingTechnique.equals("Quick Sort"))
    		quickSortVisualization();
    	else
    		bubbleSortVisualization();
    	
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
        Point newLocation = new Point(middle.x - (this.getWidth() / 2), 
                                      middle.y - (this.getHeight() / 2));
        this.setLocation(newLocation);
        setVisible(true);
    }
    
    private void bubbleSortVisualization() {
        setTitle("Bubble Sort Visualization");
    	BubbleSortVisualization bsv = new BubbleSortVisualization();
        bsv.frame = this;
        add(bsv, BorderLayout.CENTER);
        bsv.init();
    }
    
    private void selectionSortVisualization() {
        setTitle("Selection Sort Visualization");
    	SelectionSortVisualization ssv = new SelectionSortVisualization();
    	ssv.frame = this;
        add(ssv, BorderLayout.CENTER);
        ssv.init();
    }
    private void insertionSortVisualization() {
        setTitle("Insertion Sort Visualization");
    	InsertionSortVisualization isv = new InsertionSortVisualization();
    	isv.frame = this;
        add(isv, BorderLayout.CENTER);
        isv.init();
    }
    
    private void quickSortVisualization() {
        setTitle("Quick Sort Visualization");
    	QuickSortVisualization qsv = new QuickSortVisualization();
    	qsv.frame = this;
        add(qsv, BorderLayout.CENTER);
        qsv.init();
    }
    
    
}
