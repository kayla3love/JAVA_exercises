package application;
	
import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
   
public class Main extends Application {  
	private CirclePane pane1 = new CirclePane();
    @Override  
    public void start(Stage primaryStage) {  
    	BorderPane pane = new BorderPane();
   
    	HBox pane2 = new HBox();
    	pane2.setSpacing(10);
    	pane2.setAlignment(Pos.BOTTOM_CENTER);
    	Button button1 = new Button("Enlarge");
    	button1.setOnAction(e -> pane1.enLarge());
        Button button2 = new Button("Shrink");
        button2.setOnAction(e -> pane1.shrink());
        pane2.getChildren().addAll(button1, button2);
        
        pane.setCenter(pane1);
        pane.setBottom(pane2);

        Scene scene = new Scene(pane,500,500);  
        primaryStage.setTitle("draw a circle");  
        primaryStage.setScene(scene);  
        primaryStage.show();  
    }
    public static void main(String[] args) {  
        launch(args);  
    }  

}  
	class CirclePane extends StackPane{
		private Circle circle = new Circle(20);
		
		public CirclePane(){
			this.getChildren().add(circle);
	        circle.setStroke(Color.BLACK);
	        circle.setFill(Color.WHITE);
		}
		public void enLarge(){
			circle.setRadius(circle.getRadius() + 2);
		}
		public void shrink(){
			circle.setRadius(circle.getRadius() - 2);
		}    
	}