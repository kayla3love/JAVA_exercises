import java.util.*;
import java.net.*;
public class WebSearch {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a URL: ");
		String firstURLString = input.nextLine();
		crawler(firstURLString);
	}
	public static void crawler(String firstUrl){
		ArrayList<String> listOfPendingURLs = new ArrayList<>();   //δ��������
		ArrayList<String> listOfTraversedURLs = new ArrayList<>(); //�ѱ�������
		listOfPendingURLs.add(firstUrl);
		while(!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 1000){
			String urlString = listOfPendingURLs.remove(0);  //��url
			if(!listOfTraversedURLs.contains(urlString)){
				listOfTraversedURLs.add(urlString);
				//System.out.println("Crawl " + urlString);
				
				for(String s : getSubURLs(urlString)){
					if(!listOfTraversedURLs.contains(s)){
						listOfPendingURLs.add(s);
					}
				}
			}
		}
	}
	public static ArrayList<String> getSubURLs(String urlString){
		ArrayList<String> list = new ArrayList<>();
		try{
			URL url = new URL(urlString);
			Scanner input = new Scanner(url.openStream());
			int current = 0;
			while(input.hasNext()){
				String line = input.nextLine();
				if(line.contains("����")){
					System.out.println(urlString + "  ����");
					System.exit(0);
				}
				current = line.indexOf("http:", current);
				while(current > 0){    //˵����һ�л�������url
					int endIndex = line.indexOf("\"", current);
					if(endIndex > 0){
						list.add(line.substring(current, endIndex));
						current = line.indexOf("http:", endIndex);
					}
					else
						current = -1;
				}
			}
		}catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}
		return list;
	}
}
