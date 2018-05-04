
public class CourseTest {

	public static void main(String[] args) {
		Course course1 = new Course("chinese");
		Course course2 = new Course("Math");
		
		course1.addStudent("k");
		course1.addStudent("n");
		course1.addStudent("m");
		course1.addStudent("l");
		course1.dropStudent("k");
		course1.clear();
		
		System.out.println("Number of students in course1 is " +  course1.getNumOfStudents());
		String[] student =  course1.getStudents();
		for(int i = 0; i < student.length; i++){
			System.out.print(student[i] + " ");
		}
	}
}
class Course{
	private String courseName;
	private String[] students = new String[1];
	
	private int numOfStudents = 0;
	
	Course(String name){
		courseName = name;
	}
	public String[] getStudents(){
		return students;
	}
	public int getNumOfStudents(){
		return numOfStudents;
	}
	public String[] addStudent(String student){
		if(numOfStudents == 0){
			students[0] = student;
			numOfStudents = 1;
		}
		else{
			String[] newStudent = new String[++numOfStudents];
			System.arraycopy(students, 0, newStudent, 0, students.length);
			newStudent[numOfStudents - 1] = student;
			students = newStudent;
		}
		return students;
	}
	public String[] dropStudent(String student){
		for(int i = 0; i < students.length; i++){
			if(students[i] == student){
				String[] newStudent = new String[--numOfStudents];
				System.arraycopy(students, 0, newStudent, 0, i);
				System.arraycopy(students, i + 1, newStudent, i, numOfStudents - i);
				students = newStudent;
			}
		}
		return students;
	}
	public String[] clear(){
		students = new String[1];
		return students;
	}
}
