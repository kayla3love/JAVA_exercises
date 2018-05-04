package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;


public class Main extends Application {
	private char whoseTurn = 'X';
	private Cell[][] cell = new Cell[3][3];
	private Label l = new Label();
	private int win = 0;
	@Override
	public void start(Stage primaryStage) {
		l.setPrefSize(300, 30);
		HBox hbox = new HBox();
		Button button = new Button("ReStart");
		hbox.getChildren().addAll(l,button);
		hbox.setPadding(new Insets(10,10,10,10));
		BorderPane pane = new BorderPane();
		GridPane p = new GridPane();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				p.add(cell[i][j] = new Cell(),i,j);
			}
		}
		pane.setBottom(hbox);
		pane.setCenter(p);
		
		button.setOnAction(e -> {
			whoseTurn = 'X';
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					cell[i][j].clear();
				}
			}
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					GridPane.clearConstraints(p);
					p.add(cell[i][j] = new Cell(),i,j);
				}
			}
			l.setText("");
		});
		
		Scene scene = new Scene(pane,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public boolean isFull(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(cell[i][j].getToken() == '0')
					return false;
			}
		}
		return true;
	}
	public void isWin(){
		win = 0;
		for(int i = 0; i < 3; i++){
			if((cell[i][0].getToken() == whoseTurn) && (cell[i][1].getToken() == whoseTurn) && (cell[i][2].getToken() == whoseTurn)){
				l.setText(whoseTurn + "won! The game is over");
				win = 1;
			}
		}
		for(int i = 0; i < 3; i++){
			if((cell[0][i].getToken() == whoseTurn) && (cell[1][i].getToken() == whoseTurn) && (cell[2][i].getToken() == whoseTurn)){
				l.setText(whoseTurn + "won! The game is over");
				win = 1;
			}
		}
		if((cell[0][0].getToken() == whoseTurn) && (cell[1][1].getToken() == whoseTurn) && (cell[2][2].getToken() == whoseTurn)){
				l.setText(whoseTurn + "won! The game is over");
				win = 1;
		}
		if((cell[0][2].getToken() == whoseTurn) && (cell[1][1].getToken() == whoseTurn) && (cell[2][0].getToken() == whoseTurn)){
			l.setText(whoseTurn + "won! The game is over");
			win = 1;
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	class Cell extends Pane{
		private char token;
		private int count = 0;
		private Line line1;
		private Line line2;
		private Ellipse ellipse;
		private int shape = 0;
		public Cell(){
			this.token = '0';
			this.setPrefSize(2000, 2000);
			this.setStyle("-fx-border-color: black");
			this.setOnMouseClicked(e -> {
				count++;
				if(count == 1){
					handleMouseClick();
				}
			});
		}
		public char getToken(){
			return this.token;
		}
		public void handleMouseClick(){
			drawToken(whoseTurn);
			this.token = whoseTurn;
			isWin();
			if(isFull() && win == 0)
				l.setText("Draw! The game is over");
			
			if(whoseTurn == 'X'){
				whoseTurn = 'O';
			}
			else if(whoseTurn == 'O')
				whoseTurn = 'X';
		}
		public void drawToken(char t){
			if(t == 'X'){
				line1 = new Line(10,10,this.getWidth() - 10,this.getHeight() - 10);
				line2 = new Line(10,this.getHeight() - 10, this.getWidth() - 10,10);
				line1.endXProperty().bind(this.widthProperty().subtract(10));
				line1.endYProperty().bind(this.heightProperty().subtract(10));
				line2.endXProperty().bind(this.widthProperty().subtract(10));
				line2.startYProperty().bind(this.heightProperty().subtract(10));
				this.getChildren().addAll(line1, line2);
				shape = 1;
			}
			else if(t == 'O'){
				ellipse = new Ellipse(this.getWidth() / 2, this.getHeight() /2, this.getWidth() / 2 - 10,this.getHeight() / 2 - 10);
				ellipse.centerXProperty().bind(this.widthProperty().divide(2));
				ellipse.centerYProperty().bind(this.heightProperty().divide(2));
				ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
				ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
				ellipse.setStroke(Color.BLACK);
				ellipse.setFill(Color.WHITE);
				this.getChildren().add(ellipse);
				shape = 2;
			}
		}
		public void clear(){
			if(shape == 1){
				line1.setStroke(Color.WHITE);
				line2.setStroke(Color.WHITE);
			}
			if(shape == 2){
				ellipse.setStroke(Color.WHITE);
			}
		}
	}
}