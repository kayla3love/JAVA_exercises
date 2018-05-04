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
import javafx.scene.shape.Line;
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
	private double length = 0;
	public void setOrder(int order){
		this.order = order;
		paint();
	}
	public void paint(){
		Point2D p1 = new Point2D(this.getHeight() / 5, this.getHeight() - this.getHeight() / 5);
		Point2D p2 = new Point2D(this.getWidth() - this.getHeight() / 5, this.getHeight() - this.getHeight() / 5);
		Point2D p3 = new Point2D(this.getHeight() / 5 + (p2.getX() - p1.getX()) / 2, this.getHeight() / 5);
		length = p1.distance(p2);
		this.getChildren().clear();
		displayTriangles(order, (int)p2.getX(), (int)p2.getY(), (int)p1.getX(), (int)p1.getY());	
		displayTriangles(order, (int)p1.getX(), (int)p1.getY(), (int)p3.getX(), (int)p3.getY());
		displayTriangles(order, (int)p3.getX(), (int)p3.getY(), (int)p2.getX(), (int)p2.getY());
	}
	public void displayTriangles(int order, int x1, int y1, int x2, int y2){
		if(order == 0) {  
			Line line = new Line(x1, y1, x2, y2);
			this.getChildren().add(line);  
		} 
		else {  
			// 计算坐标(xa,ya)  
		    int xa = (int)Math.round(x1 + (x2-x1)/3.0);  
		    int ya = (int)Math.round(y1 + (y2-y1)/3.0);  
		    // 计算坐标(xb,yb)  
		    int xb = (int)Math.round((xa + x2) / 2.0);  
		    int yb = (int)Math.round((ya + y2) / 2.0);  
		    // 计算递归后的线元长度  
		    int len = (int)(length/Math.pow(3, (this.order-order+1)));  
		    double angle = getAngle(x1, y1, x2, y2);  
		    // 计算坐标(xc,yc)  
		    int xc = (int)Math.round(xa + len * Math.cos(angle));  
		    int yc = (int)Math.round(ya - len * Math.sin(angle));  
		    // 递归  
		    displayTriangles(order-1, x1, y1, xa, ya);  
		    displayTriangles(order-1, xa, ya, xc, yc);  
		    displayTriangles(order-1, xc, yc, xb, yb);  
		    displayTriangles(order-1, xb, yb, x2, y2);  
		 }  
	}
	private double getAngle(double x1, double y1, double x2, double y2) { // 计算相邻两直线间的夹角  
        return Math.atan2((y1-y2), (x2-x1)) + Math.PI/3;  
    }  
}
