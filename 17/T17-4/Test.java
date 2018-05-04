import java.io.*;
public class Test {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		if(args.length != 2){
			System.out.println("Usage: java Test sourcefile targetfile");
			System.exit(1);
		}
		File sourceFile = new File(args[0]);
		File targetFile = new File(args[1]);
		if(!sourceFile.exists()){
			System.out.println("source file " + args[0] + "does not exist");
			System.exit(2);
		}
		if(targetFile.exists()){
			System.out.println("target file " + args[1] + "already exists");
			System.exit(3);
		}
		try(
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
		){
			int r, numberOfBytesCpoies = 0;
			while((r = input.read()) != -1){
				output.write((byte)r);
				numberOfBytesCpoies++;
			}
			System.out.println(numberOfBytesCpoies);
		}
		
	}

}
