package view;
import java.net.URL;
import java.util.ResourceBundle;

import controller.ArrayGenerator;
import controller.Sorter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import view.visualization.Visualizer;

public class TheStage implements Initializable {

    @FXML
    private LineChart<String, Number> chart;
    @FXML
    private TextField createSetText;
    @FXML
    private Button createSetBtn;
    @FXML
    private ComboBox<String> techniqueCmb;
    @FXML
    private Button sortBtn;
    @FXML
    private Button visualizeBtn;
    @FXML
    private Button clearChartBtn;

    private ArrayGenerator arrayGenerator;
    private boolean readyToPlot = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeComboBox();
        initializeTextField();
        initializeButtons();
    }

    private void initializeComboBox() {
        techniqueCmb.getItems().addAll("All Sorting Techniques", "Bubble Sort", "Selection Sort", "Insertion Sort", "Heap Sort", "Merge Sort", "Quick Sort");
        techniqueCmb.getSelectionModel().selectFirst();
    }

    private void initializeTextField(){
        createSetText.textProperty().addListener((ov, oldValue, newValue) -> {
            if (createSetText.getText().length() > 5) {
                String s = createSetText.getText().substring(0, 5);
                createSetText.setText(s);
            }
        });
    }

    private void initializeButtons() {
        createSetBtn.setOnAction(event -> {
            if (        createSetText.getText().matches("[0-9]+")
                    && !createSetText.getText().isEmpty()
                    && !createSetText.getText().equals("0")) {
                int i = Integer.parseInt(createSetText.getText());
                if (i>0) {
                    arrayGenerator = new ArrayGenerator(i);
                    readyToPlot = true;
                    System.out.println("heeeeeeerreeee!!!");
                }
            }
        });
        
        sortBtn.setOnAction(event -> {
            if (readyToPlot) {
                chart.getData().clear();
                String sortingTechnique = techniqueCmb.getValue();
                Sorter sorter;
                if (sortingTechnique.equals("All Sorting Techniques")) {
                    for (int i=1 ; i<7 ; i++) {
                        sorter = new Sorter(arrayGenerator.getToBeSorted(), techniqueCmb.getItems().get(i));
                        chart.getData().add(sorter.getCoordinates());
                    }
                } else {
                    System.out.println(sortingTechnique);
                    sorter = new Sorter(arrayGenerator.getToBeSorted(), sortingTechnique);
                    chart.getData().add(sorter.getCoordinates());
                }
            }
        });
        
        visualizeBtn.setOnAction(event -> {
        try {
        	new Visualizer(techniqueCmb.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
        
        clearChartBtn.setOnAction(event -> {
        	try {
        		chart.getData().clear();
        	}catch(Exception e) {
        		
        	}
        });

    }
}