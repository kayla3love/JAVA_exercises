import java.util.*;
public class CalendarPrint {

	public static void main(String[] args) {
		Calendar calendar = setCalendar(args);
		printHead(calendar);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		//System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		printContent(dayOfWeek, dayOfMonth);
	}
	public static Calendar setCalendar(String[] args){
		Calendar calendar = new GregorianCalendar();
		if(args.length == 2){
			String month = args[0];
			String year = args[1];
			calendar.set(Calendar.YEAR, Integer.parseInt(year));
			calendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		}
		else if(args.length == 1){
			String month = args[0];
			calendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		}
		return calendar;
	}
	public static void printHead(Calendar calendar){
		String[] months = {"Jan","Feb","Mar","Apr",
				"May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
		System.out.printf("%30s\n",months[calendar.get(Calendar.MONTH)]+ ", " + calendar.get(Calendar.YEAR)+"          ");
		System.out.printf("%30s\n","------------------------------");
		System.out.printf("%30s\n", "Sun Mon Tue Wed Thu Fri Sat  ");
	}
	public static void printContent(int dayOfWeek, int dayOfMonth){
		for(int i = 0; i < dayOfWeek - 1; i++){
			System.out.print("    ");
		}
		int first = 8 - dayOfWeek;
		for(int i = 1; i < first + 1; i++){
			System.out.printf("%4d",i);
		}
		System.out.print("\n");
		for(int i = first + 1; i <= dayOfMonth; i++){
			System.out.printf("%4d",i);
			if((i - first) % 7 ==0){
				System.out.print("\n");
			}
		}
	}
}
