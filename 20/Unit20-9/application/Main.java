package application;
	
import java.util.Comparator;
import java.util.PriorityQueue;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		ScrollBar sb = new ScrollBar();
		sb.setMax(20);
		sb.setValue(10);
		root.setTop(sb);
		MultipleBallPane ballPane = new MultipleBallPane();
		ballPane.rateProperty().bind(sb.valueProperty());
		root.setCenter(ballPane);
		
		Button addButton = new Button("+");
		addButton.setOnAction(e -> ballPane.add());
		Button removeButton = new Button("-");
		removeButton.setOnAction(e -> ballPane.remove());
		Button playButton = new Button("play");
		playButton.setOnAction(e -> ballPane.play());
		Button pauseButton = new Button("pause");
		pauseButton.setOnAction(e -> ballPane.pause());
		HBox box = new HBox(5);
		box.setPadding(new Insets(5,5,5,5));
		box.getChildren().addAll(addButton, removeButton, playButton, pauseButton);
		box.setAlignment(Pos.CENTER);
		root.setBottom(box);
		
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
class MultipleBallPane extends Pane{
	private Timeline animation;
	public MultipleBallPane(){
		animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	public void add() {
		Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
		double radius = Math.random() * 18 + 2;
		System.out.println(radius);
		this.getChildren().add(new Ball(30,30,radius,color));
	}
	public void remove() {
		if(this.getChildren().size() > 0) {
			PriorityQueue<Ball> queue = new PriorityQueue<>(this.getChildren().size(), new ComparatorBall());
			for(Node node : this.getChildren())
				queue.add((Ball)node);
			this.getChildren().remove(queue.peek());
		}
	}
	public void play() {
		animation.play();
	}
	public void pause() {
		animation.pause();
	}
	public void increseSpeed(){
		animation.setRate(animation.getRate() + 0.1);
	}
	public void decreaseSpeed() {
		animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
	}
	public void moveBall() {
		for(Node node : this.getChildren()) {
			Ball ball = (Ball)node;
			if(ball.getCenterX() < ball.getRadius() || ball.getCenterX() > this.getWidth() - ball.getRadius()){
				ball.dx *= -1;
			}
			if(ball.getCenterY() < ball.getRadius() || ball.getCenterY() > this.getHeight() - ball.getRadius()) {
				ball.dy *= -1;
			}
			ball.setCenterX(ball.dx + ball.getCenterX());
			ball.setCenterY(ball.dy + ball.getCenterY());
		}
	}
	public DoubleProperty rateProperty() {
		return animation.rateProperty();
	}
	class Ball extends Circle{
		private double dx =1, dy =1;
		public Ball(double x, double y, double radius, Color color){
			super(x, y, radius);
			this.setFill(color);
		}
	}
	class ComparatorBall implements Comparator<Ball>{
		@Override
		public int compare(Ball ball1, Ball ball2) {
			if(ball1.getRadius() < ball2.getRadius())
				return 1;
			else if(ball1.getRadius() > ball2.getRadius())
				return -1;
			else
				return 0;
		}	
	}
}
