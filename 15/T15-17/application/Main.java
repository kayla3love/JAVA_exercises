package application;
	
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BallPane ball = new BallPane();
		ball.setOnMousePressed(e -> {ball.pause();});
		ball.setOnMouseReleased(e -> {ball.play();});
		ball.setOnKeyPressed(e->{
			if(e.getCode() == KeyCode.UP)
				ball.upSpeed();
			else if(e.getCode() == KeyCode.DOWN)
				ball.downSpeed();
		});
		Scene scene = new Scene(ball,200,100);
		primaryStage.setScene(scene);
		primaryStage.show();
		ball.requestFocus();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
class BallPane extends Pane{
	private final double radius = 20.0;
	private double x = radius;
	private double y = radius;
	private Circle circle = new Circle(x,y,radius);
	private double dx = 1, dy = 1;
	private Timeline animation;
	
	BallPane(){
		this(20,20);
	}
	BallPane(double x, double y){
		circle.setStroke(Color.GRAY);
		circle.setFill(Color.GRAY);
		this.getChildren().add(circle);
		animation = new Timeline(new KeyFrame(Duration.millis(100),e ->{
			ballMove();
		}));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	public void ballMove(){
		if(hEdge())
			dy *= -1;
		if(wEdge()){
			dx *= -1;
		}
		x += dx;
		y += dy;
		circle.setCenterX(x);
		circle.setCenterY(y);		
	}
	public void pause(){
		animation.pause();
	}
	public void play(){
		animation.play();
	}
	public void upSpeed(){
		animation.setRate(animation.getRate() + 0.1);
	}
	public void downSpeed(){
		if(animation.getRate() > 0)
			animation.setRate(animation.getRate() - 0.1);
	}
	public boolean hEdge(){
		if(this.getHeight() < y + radius || y < radius)
			return true;
		return false;
	}
	public boolean wEdge(){
		if(this.getWidth() < x + radius || x < radius)
			return true;
		return false;
	}
}
