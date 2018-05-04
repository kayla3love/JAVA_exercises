package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		HBox hbox = new HBox(10);
		TextField field = new TextField();
		TriPane tri = new TriPane();
		field.setOnAction(e -> {
			tri.setOrder(Integer.parseInt(field.getText()));
		});
		field.setPrefColumnCount(5);
		hbox.getChildren().addAll(new Label("Enter an order: "), field);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(5,5,5,5));
		root.setBottom(hbox);
		
		root.setCenter(tri);
		Scene scene = new Scene(root,200,210);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		scene.widthProperty().addListener(ov -> tri.paint());
		scene.heightProperty().addListener(ov -> tri.paint());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
class TriPane extends Pane{
	private int order = 0;
	public void setOrder(int order){
		this.order = order;
		paint();
	}
	public void paint(){
		Point2D p1 = new Point2D(this.getWidth() / 2, 10);
		Point2D p2 = new Point2D(10, this.getHeight() - 10);
		Point2D p3 = new Point2D(this.getWidth() - 10, this.getHeight() - 10);
		this.getChildren().clear();
		displayTriangles(order, p1, p2, p3);	
	}
	public void displayTriangles(int order, Point2D p1, Point2D p2, Point2D p3){
		if(order == 0){
			Polygon triangle = new Polygon();
			triangle.getPoints().addAll(p1.getX(),p1.getY(),p2.getX(),p2.getY(),p3.getX(),p3.getY());
			triangle.setStroke(Color.BLACK);
			triangle.setFill(Color.WHITE);
			this.getChildren().add(triangle);
		}
		else{
			Point2D p12 = p1.midpoint(p2);
			Point2D p23 = p2.midpoint(p3);
			Point2D p13 = p1.midpoint(p3);
			displayTriangles(order - 1, p1, p12, p13);
			displayTriangles(order - 1, p12, p2, p23);
			displayTriangles(order - 1, p13, p23, p3);
		}
	}
}
