import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Data extends UnicastRemoteObject implements DataIF {
	private static final long serialVersionUID = 1L;
	protected static StudentList studentList;
	protected static CourseList courseList;
	protected static EnrollmentList enrollmentList;
	protected Data() throws RemoteException {
		super();
	}
	public static void main(String[] arg) throws AlreadyBoundException, FileNotFoundException, IOException {
		try {
			Data data = new Data();
			Naming.rebind("Data", data);
			System.out.println("Data is ready !!!");
			studentList = new StudentList("Students.txt");
			courseList = new CourseList("Courses.txt");
			enrollmentList = new EnrollmentList("Enrollment.txt");
		} catch(RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException {
		return studentList.getAllStudentRecords();
	}
	@Override
	public ArrayList<Course> getAllCourseData() throws RemoteException, NullDataException {
		return courseList.getAllCourseRecords();
	}

	@Override
	public boolean addStudent(String studentInfo) throws RemoteException {
		if(studentList.addStudentRecords(studentInfo)) return true;
		else return false;
	}
	@Override
	public boolean enrollCourse(String studentId, String courseId) throws RemoteException {
		String enrollInfo = studentId + " " + courseId;
		if(enrollmentList.enrollCourse(enrollInfo)) return true;
		else return false;
	}
	@Override
	public boolean deleteStudent(String studentId) throws RemoteException {
		if(studentList.deleteStudentRecords(studentId)) return true;
		else return false;
	}
	@Override
	public boolean addCourse(String courseInfo) throws RemoteException {
		if(courseList.addCourseRecords(courseInfo)) return true;
		else return false;
	}
	@Override
	public boolean deleteCourse(String courseId) throws RemoteException {
		if(courseList.deleteCourseRecords(courseId)) return true;
		else return false;
	}
	@Override
	public ArrayList<Enrollment> getAllEnrollCourse() throws RemoteException, NullDataException {
		return enrollmentList.getAllEnrollment();
	}
}