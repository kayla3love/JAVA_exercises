
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSyncUsingLock {
	private static Account account = new Account();
	private static ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i = 0; i < 100; i++) {
			executor.execute(new AddPennyTask());
		}
		executor.shutdown();
		while(!executor.isTerminated()) {     //判断线程任务是否终止
		}
		System.out.println(account.getBalance());
	}
private static class AddPennyTask implements Runnable{

	@Override
	public void run() {
		
		account.deposit(1);
	}
}

private static class Account{
	private int balance = 0;
	public int getBalance() {
		return balance;
	}
	public void deposit(int amount) {
		lock.lock();
		try {
			int newBalance = balance + amount;
			Thread.sleep(5);
			balance = newBalance;
		}catch(Exception ex) {ex.printStackTrace();}
		finally {
			lock.unlock();
		}
	}
}
}