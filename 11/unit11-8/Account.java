import java.util.*;
public class Account {

	public static void main(String[] args) {
		FatherAccount father = new FatherAccount("George", 1122, 1000);
		father.setAnnualInterestRate(1.5);
		father.deposit(100);
		father.deposit(40);
		father.deposit(50);
		father.withDraw(5);
		father.withDraw(4);
		father.withDraw(2);
		System.out.println(father);
		for(Transactions a : father.transactions){
			System.out.println(a.getDescription());
		}
	}
}
class FatherAccount{
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	private String name;
	ArrayList<Transactions> transactions = new ArrayList<>();
	
	public FatherAccount(){
		this(0,0);
	}
	public FatherAccount(int id, double balance){
		this.id = id;
		this.balance = balance;
		annualInterestRate = 0;
		dateCreated = new Date();
	}
	public FatherAccount(String name, int id, double balance){
		this(id,balance);
		this.name = name;
	}
	public int getId(){
		return id;
	}
	public double getBalance(){
		return balance;
	}
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public void setAnnualInterestRate(double annualInterestRate){
		this.annualInterestRate = annualInterestRate;
	}
	public Date getDateCreated(){
		return dateCreated;
	}
	public double getMonthlyInterest(){
		return balance * annualInterestRate / 100 /12;
	}
	public void withDraw(double outMoney){
		balance -= outMoney;
		Transactions t = new Transactions('W', outMoney, this.getBalance());
		transactions.add(t);
	}
	public void deposit(double inMoney){
		balance += inMoney;
		Transactions t = new Transactions('D', inMoney, this.getBalance());
		transactions.add(t);
	}
	public String toString(){
		return "Account name is " + name + "\nbalance is " + this.getBalance();
	}
}
class Transactions{
	private Date transactionsDate;
	private char type;
	private double amount;
	private double balance;
	private String description;
	public Transactions(char type, double amount, double balance){
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		transactionsDate = new Date();
		this.description = "交易类型 " + type + " 交易金额 " + amount + " 余额 " + balance + " 交易时间 " + transactionsDate ;
	}
	public String getDescription(){
		return this.description;
	}
}	
