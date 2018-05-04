import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerProducerUsingBlockingQueen {
	private static 	ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(1);
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProduceTask());
		executor.execute(new ConsumerTask());
		executor.shutdown();
	}
	public static class ProduceTask implements Runnable{
			@Override
		public void run() {
			try{
				int i = 1;
				while(true){
					System.out.println("Producer writes: " + i);
					buffer.put(i++);
					Thread.sleep((int)(Math.random() * 10000)); 					}
				}catch(InterruptedException ex){ex.printStackTrace();}
			}
	}
	public static class ConsumerTask implements Runnable{
			@Override
		public void run() {
			try{
				int i = 0;
				while(true){
					System.out.println("\t\t\tConsumer reads: " + buffer.take());
					Thread.sleep((int)(Math.random() * 10000)); 
				}
			}catch(InterruptedException ex){ex.printStackTrace();}			
		}		
	}
	
}
