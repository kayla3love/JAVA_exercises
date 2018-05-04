import java.util.*;
import java.io.*;
public class NameRank {

	public static void main(String[] args){
		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter the year: ");
		int year = input1.nextInt();
		System.out.println("Enter the gender: ");
		String gender = input1.next();
		System.out.println("Enter the name: ");
		String name = input1.next();
		ArrayList<String> list = new ArrayList<>();
		try{
			list = findGender(year,gender);
			int[] rank = searchName(list,name);
			if(rank[2] == 1)
				System.out.println(name + " is ranked #" + rank[1] + " in year " + year + " " + rank[0]);
		}catch(Exception ex){}
		

	}
	public static ArrayList<String> findGender(int year,String gender)throws Exception{

		Scanner input2 = new Scanner(new File("names" + "/yob" + year + ".txt"));
		ArrayList<String> genderListF = new ArrayList<>();
		ArrayList<String> genderListM = new ArrayList<>();
		while(input2.hasNext()){
			String s = input2.nextLine();
			{
				if(s.contains(",F,")){
					genderListF.add(s);
				}
				else if(s.contains(",M,")){
					genderListM.add(s);
				}
			}	
		}
		return gender.equals("M") ? genderListM : genderListF;
	}
	
	public static int[] searchName(ArrayList<String> list,String name){
		int rank[] = new int[3];
		int isExist = 0;
		for(int i = 1; i < list.size() + 1; i++){
			if(list.get(i - 1).contains(name)){
				String s = list.get(i - 1);
				String[] s1 = s.split(",");
				rank[0] = Integer.parseInt(s1[s1.length - 1]);
				rank[1] = i;
				isExist = 1;
				break;
			}	
		}
		if(isExist == 0)
			System.out.println("The name is not ranked in the list");
		rank[2] = isExist;
		return rank;
	}
}
