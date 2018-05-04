package application;
	
import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;


public class Main extends Application {
	
	private int[] queens = {-1,-1,-1,-1,-1,-1,-1,-1};

	@Override
	public void start(Stage primaryStage) {
		search();
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		Label[][] labels = new Label[8][8];
		for(int i = 0; i< 8; i++) {
			for(int j = 0; j < 8; j++) {
				root.add(labels[i][j] = new Label(), i, j);
				labels[i][j].setStyle("-fx-border-color: black");
				labels[i][j].setPrefSize(55, 55);
			}
		}
	//	ImageView image = new ImageView(new Image("file:E:\\eclipse-workspace\\T22-11\\1.jpg"));
		for(int i = 0; i < 8; i++) {
			if(queens[i] != -1) {
				labels[i][queens[i]].setAlignment(Pos.CENTER);
				labels[i][queens[i]].setGraphic(new Circle(0,0,25));
			}
		}
		Scene scene = new Scene(root,55*8, 55*8);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void search() {
		int k = 0;
		while(k >= 0 && k < 8) {
			int j = findPosition(k);
			if(j == -1) {
				queens[k] = -1;
				k--;
			}
			else {
				queens[k] = j;
				k++;
			}
		}
	}
	public int findPosition(int k) {
		int start = queens[k] + 1;
		for(int j = start; j < 8; j++) {
			if(isVaild(k, j)) {
				System.out.print(k + " " + j + "\n");
				return j;
			}
		}
		return -1;
	}
	public boolean isVaild(int row, int column) {
		for(int i = 1; i <=row; i++) {
			if(queens[row - i] == column || queens[row - i] == column -i || queens[row - i] == column +i)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
