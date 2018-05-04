package application;
	
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;


public class Main extends Application {
	private String[] country = {"Cannada", "China", "Denmark", "France", "Germany", "India","UK","NorWay"};
	private ImageView[] image = {
			new ImageView("file:1.jpg"),
			new ImageView("file:2.jpg"),
			new ImageView("file:3.jpg"),
			new ImageView("file:4.jpg"),
			new ImageView("file:5.jpg"),
			new ImageView("file:6.jpg"),
			new ImageView("file:7.jpg"),
			new ImageView("file:8.jpg"),
	};
	@Override
	public void start(Stage primaryStage) {
		BorderPane b = new BorderPane();
		ObservableList<String> items = FXCollections.observableArrayList(country);
		ListView<String> name = new ListView<>(items);
		name.setPrefSize(100, 200);
		(name.getSelectionModel()).setSelectionMode(SelectionMode.MULTIPLE);
		SelectionMode a = name.getSelectionModel().getSelectionMode();
		FlowPane f = new FlowPane();
		b.setCenter(f);
		ScrollPane s = new ScrollPane(name);
		b.setLeft(s);
		
		name.getSelectionModel().selectedItemProperty().addListener(ov -> {
			f.getChildren().clear();
			ObservableList<Integer> o = name.getSelectionModel().getSelectedIndices();
			for(Integer i : o)
				f.getChildren().add(image[i]);
		});

		Scene scene = new Scene(b,200,170);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
	

