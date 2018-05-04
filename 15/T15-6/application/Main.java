package application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	private TextField tfAnnualIntersetRate = new TextField();
	private TextField tfNumberofYears = new TextField();
	private TextField tfLoanAmount = new TextField();
	private TextField tfMonthlyPayment = new TextField();
	private TextField tfTotalPayment = new TextField();
	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(30,5,5,5));
		pane.setHgap(5);
		pane.setVgap(5);
		pane.add(new Label("Annual Interest Rate: "), 0, 0);
		pane.add(tfAnnualIntersetRate, 1, 0);
		pane.add(new Label("Number of Years:  "), 0, 1);
		pane.add(tfNumberofYears, 1, 1);
		pane.add(new Label("Loan Amount: "), 0, 2);
		pane.add(tfLoanAmount, 1, 2);
		pane.add(new Label("Monthly Payment: "), 0, 3);
		pane.add(tfMonthlyPayment, 1, 3);
		pane.add(new Label("Total Payment: "), 0, 4);
		pane.add(tfTotalPayment, 1, 4);
		
		Button calculate = new Button("Calculate");
		pane.add(calculate, 1, 5);
		GridPane.setHalignment(calculate, HPos.RIGHT);
		tfMonthlyPayment.setEditable(false);
		tfTotalPayment.setEditable(false);
		
		calculate.setOnAction(e -> calculateLoanPayment());
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void calculateLoanPayment(){
		double interest = Double.parseDouble(tfAnnualIntersetRate.getText());
		int year = Integer.parseInt(tfNumberofYears.getText());
		double loanAmount = Double.parseDouble(tfLoanAmount.getText());
		double monthlyPayment = loanAmount * interest / 1200 / (1 - (1 / Math.pow(1 + interest / 1200, year * 12)));
		tfMonthlyPayment.setText(String.format("$%.2f", monthlyPayment));
		double totalPayment = monthlyPayment * year *12;
		tfTotalPayment.setText(String.format("$%.2f", totalPayment));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
