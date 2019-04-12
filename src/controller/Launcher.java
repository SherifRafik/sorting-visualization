package controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

	public static void main(String[] args) {
		launch(args);
	}

    @Override
    public void start(Stage primaryStage) throws Exception{
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString() + "\\src\\view\\TheStage.fxml";
        Parent root = FXMLLoader.load(new File(path).toURI().toURL());
        primaryStage.setOnCloseRequest(event -> primaryStage.close());
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Sorting");
        //Scene scene = new Scene(root,506,506);
        Scene scene = new Scene(root,827,483);
        scene.getStylesheets().add(getClass().getResource("/resources/application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
