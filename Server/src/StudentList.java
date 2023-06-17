
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentList {
	protected ArrayList<Student> vStudent;
	public StudentList(String studentFileName) throws FileNotFoundException, IOException {
		BufferedReader studentFile = new BufferedReader(new FileReader(studentFileName));
		this.vStudent = new ArrayList<Student>();
		while (studentFile.ready()) {
			String studentInfo = studentFile.readLine();
			if (!studentInfo.equals("")) this.vStudent.add(new Student(studentInfo));
		}
		studentFile.close();
	}
	public ArrayList<Student> getAllStudentRecords() throws NullDataException {
		if(this.vStudent.size() == 0) throw new NullDataException("******* Student data is null *******");
		return this.vStudent;
	}
	public boolean addStudentRecords(String studentInfo) { // Null이면?
		if(this.vStudent.add(new Student(studentInfo))) return true;
		else return false;
	}
	public boolean deleteStudentRecords(String studentId) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student student = (Student) this.vStudent.get(i);
			if (student.match(studentId)) {
				if(this.vStudent.remove(student)) return true;
				else return false;
			}
		}
		return false;
	}
	public boolean isRegisteredStudent(String studentId) {
		for (int i = 0; i < this.vStudent.size(); i++) {
			Student student = (Student) this.vStudent.get(i);
			if (student.match(studentId)) return true;
		}
		return false;
	}
}