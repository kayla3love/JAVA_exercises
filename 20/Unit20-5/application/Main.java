package application;
	
import java.util.ArrayList;

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
		this.getChildren().add(new Ball(30,30,10,color));
	}
	public void remove() {
		if(this.getChildren().size() > 0)
			this.getChildren().remove(this.getChildren().size() - 1);
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
		ArrayList<Node> ballList = new ArrayList<>(this.getChildren());
		ArrayList<Integer> num = new ArrayList<>();
		ArrayList<Integer> num2 = new ArrayList<>();
		num.clear();
		num2.clear();

		for(int i = ballList.size() - 1; i > 0; i--) {
			for(int j = i - 1; j >= 0; j--){
				if(crashTest((Ball)ballList.get(i), (Ball)ballList.get(j))) {
					num.add(i);
					num2.add(j);

				}
			}
		}
		if(num.size() != 0 && num2.size() != 0) {
			for(int i = 0; i < num.size(); i++) {
				((Ball)ballList.get(num2.get(i))).setRadius(((Ball)ballList.get(num2.get(i))).getRadius() + ((Ball)ballList.get(num.get(i))).getRadius());
			}
			for(int i = 0; i < num.size(); i++) {
				this.getChildren().remove(ballList.get(num.get(i)));
			}
		}
		
		for(Node node : this.getChildren()) {
			Ball ball = (Ball)node;
			if(ball.getCenterX() < ball.getRadius()) {
				ball.dx *= -1;
				ball.setCenterX(ball.getRadius());
			}
			if(ball.getCenterX() > this.getWidth() - ball.getRadius()){
				ball.dx *= -1;
				ball.setCenterX(this.getWidth() - ball.getRadius());
			}
			if(ball.getCenterY() < ball.getRadius()) {
				ball.dy *= -1;
				ball.setCenterY(ball.getRadius());
			}
			if(ball.getCenterY() > this.getHeight() - ball.getRadius()) {
				ball.dy *= -1;
				ball.setCenterY(this.getHeight() - ball.getRadius());
			}
			ball.setCenterX(ball.dx + ball.getCenterX());
			ball.setCenterY(ball.dy + ball.getCenterY());
		}
		
	}
	public boolean crashTest(Ball ball1, Ball ball2){
		int distance = (int)Math.sqrt(Math.pow(ball1.getCenterX() - ball2.getCenterX(), 2) + Math.pow(ball1.getCenterY() - ball2.getCenterY(), 2));
		if(distance <= ball1.getRadius() + ball2.getRadius())
			return true;
		else 
			return false;
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
}
