package application;

import java.io.*;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application{
	GridPane root = new GridPane();
	TextField field1 = new TextField();
	TextField field2 = new TextField();
	TextField field3 = new TextField();
	TextField field4 = new TextField();
	TextField field5 = new TextField();
	ArrayList<TextField> field = new ArrayList();
	long currentNum;
	long lastNum;
	char[] c = new char[10];
	
	@Override
	public void start(Stage primaryStage){
		AddressPane pane = new AddressPane();
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	class AddressPane extends BorderPane{
		AddressPane(){
			root.add(new Label("Name"), 0, 0);
			field1.setPrefColumnCount(20);
			root.add(field1, 1, 0);
			
			root.add(new Label("Street"), 0, 1);
			field2.setPrefColumnCount(20);
			root.add(field2, 1, 1);
			
			root.setPadding(new Insets(10,10,10,10));
			root.setVgap(10);
			root.setHgap(10);
			
			root.add(new Label("City"), 0, 2);
			
			HBox box1 = new HBox(5);
			field3.setPrefColumnCount(10);
			field4.setPrefColumnCount(2);
			field5.setPrefColumnCount(5);
			box1.getChildren().addAll(field3, new Label("State"), field4, new Label("Zip"), field5);
			root.add(box1, 1, 2);
			field.add(field1);
			field.add(field2);
			field.add(field3);
			field.add(field4);
			field.add(field5);
			
			Button addButton = new Button("add");
			addButton.setOnAction(e -> {
				addAddress();
				getLastNum();
				currentNum += 2;
			});
			Button firstButton = new Button("First");
			firstButton.setOnAction(e -> {
				viewText(0);
				currentNum = 0;
			});
			Button lastButton = new Button("Last");
			lastButton.setOnAction(e -> {
				viewText(-1);
			});
			Button previousButton = new Button("<");
			previousButton.setOnAction(e -> {
				currentNum -= 2;
				if(currentNum < 0){
					Alert information = new Alert(Alert.AlertType.WARNING,"当前已是第一个");
					currentNum = 0;
					information.show();
				}
				else
					viewText(currentNum);
			});
			Button nextButton = new Button(">");
			nextButton.setOnAction(e -> {
				currentNum += 2;
				if(currentNum > getLastNum()){
					Alert information = new Alert(Alert.AlertType.WARNING,"当前已是最后一个");
					currentNum = getLastNum();
					information.show();
				}
				else
					viewText(currentNum);
			});
			Button updateButton = new Button("Update");
			updateButton.setOnAction(e -> {
				updateAddress();
			});
			Button clearButton = new Button("Clear");
			clearButton.setOnAction(e -> {
				for(int i = 0; i < field.size(); i++){
					field.get(i).clear();
				}
			});
			HBox buttonBox = new HBox(15);
			buttonBox.setAlignment(Pos.CENTER);
			buttonBox.setPadding(new Insets(20,10,10,10));
			buttonBox.getChildren().addAll(clearButton, addButton, firstButton, lastButton, previousButton, nextButton, updateButton);
			
			this.setCenter(root);
			this.setBottom(buttonBox);
		}
	}
	public void addAddress(){
		try{
			try(RandomAccessFile output = new RandomAccessFile("1.txt", "rw");){
				output.seek(output.length());
				for(int i = 0; i < field.size(); i++){
					String str = String.format("%-10s", field.get(i).getText());
					output.writeChars(str);
				}
			}
		}catch(IOException ex){ex.printStackTrace();}
	}
	public void updateAddress(){
		try{
			try(RandomAccessFile output = new RandomAccessFile("1.txt", "rw");){
				output.seek(currentNum * 50);
				for(int i = 0; i < field.size(); i++){
					String str = String.format("%-10s", field.get(i).getText());
					output.writeChars(str);
				}
			}
		}catch(IOException ex){ex.printStackTrace();}
	}
	public void viewText(long num){
		try{
			try(RandomAccessFile input = new RandomAccessFile("1.txt", "r");){
				if(num == -1){
					currentNum = num = getLastNum();
				}
				input.seek(num * 50);
				for(int i = 0; i < field.size(); i++){
					for(int j = 0; j < 10; j++){
						c[j] = input.readChar();
					}
					field.get(i).setText(new String(c));
				}

			}
		}catch(IOException ex){ex.printStackTrace();}
	}
	public long getLastNum(){
		try{
			try(RandomAccessFile input = new RandomAccessFile("1.txt", "r");){
				lastNum = input.length() / 50 - 2;
			}
		}catch(IOException ex){ex.printStackTrace();}
		return lastNum;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
