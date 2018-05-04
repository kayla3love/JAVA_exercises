package application;
	
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		Pane root = new Pane();
		Rectangle rec = new Rectangle(0,0,25,50);
		rec.setFill(Color.ORANGE);
		Circle circle = new Circle(125,100,50);
		circle.setStroke(Color.WHITE);
		circle.setFill(Color.BLACK);
		root.getChildren().addAll(circle, rec);
		EventHandler<ActionEvent> a = ;
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(2000));
	    pt.setNode(rec);
	    pt.setPath(circle);
	    pt.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
	    pt.setCycleCount(5);
	    pt.setAutoReverse(true);
	    pt.play();
	    circle.setOnMousePressed(e -> {pt.pause();});
	    circle.setOnMouseReleased(e -> {pt.play();});
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
