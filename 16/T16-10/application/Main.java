package application;
	
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

			BorderPane root = new BorderPane();
			ScrollBar bar1 = new ScrollBar();
			ScrollBar bar2 = new ScrollBar();
			bar2.setOrientation(Orientation.VERTICAL);
			root.setRight(bar2);
			root.setBottom(bar1);
			
			Text text = new Text(20,20,"JavaFX Programming");
			Pane textPane = new Pane();
			textPane.getChildren().add(text);
			root.setCenter(textPane);
			
			bar1.valueProperty().addListener(ov -> {
				text.setX(bar1.getValue() * textPane.getWidth() / bar1.getMax());
			});
			bar2.valueProperty().addListener(ov -> {
				text.setY(bar2.getValue() * textPane.getHeight() / bar2.getMax());
			});
			
			Scene scene = new Scene(root,450,170);
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
