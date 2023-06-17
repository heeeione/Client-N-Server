import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements ServerIF {
	private static DataIF data;
	private static final long serialVersionUID = 1L;
	protected Server() throws RemoteException {
		super();
	}
	public static void main(String[] arg) throws NotBoundException {
		try {
			Server server = new Server();
			Naming.rebind("Server", server);
			System.out.println("Server is ready !!!");
			data = (DataIF)Naming.lookup("Data");
		} catch(RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException {
		return data.getAllStudentData();
	}
	@Override
	public ArrayList<Course> getAllCourseData() throws RemoteException, NullDataException {
		return data.getAllCourseData();
	}
	@Override
	public boolean addStudent(String studentInfo) throws RemoteException {
		if(data.addStudent(studentInfo)) return true;
		else return false;
	}
	@Override
	public boolean deleteStudent(String studentId) throws RemoteException {
		if(data.deleteStudent(studentId)) return true;
		else return false;
	}
	@Override
	public boolean addCourse(String courseInfo) throws RemoteException {
		if(data.addCourse(courseInfo)) return true;
		else return false;
	}
	@Override
	public boolean deleteCourse(String courseId) throws RemoteException {
		if(data.deleteCourse(courseId)) return true;
		else return false;
	}
	@Override
	public Student getStudent(String studentId) throws RemoteException, NullDataException {
		ArrayList<Student> vStudent = this.getAllStudentData();
		for (int i = 0; i < vStudent.size(); i++) {
			Student student = vStudent.get(i);
			if (student.match(studentId)) return student;
		}
		return null;
	}
	@Override
	public Course getCourse(String courseId) throws RemoteException, NullDataException {
		ArrayList<Course> vCourse = this.getAllCourseData();
		for (int i = 0; i < vCourse.size(); i++) {
			Course course = vCourse.get(i);
			if (course.match(courseId)) return course;
		}
		return null;
	}
	@Override
	public boolean checkPreCourse(Student student, Course course) throws RemoteException {
		// 학생리스트에 학번 주고 학생이 들은 과목 가져옴
		ArrayList<String> completedCourses = student.getCompletedCourses();
		// 강의리스트에 강의 아이디 주고 선수과목 가져옴
		ArrayList<String> preCourses = course.getpreCoursesList();
		// 선수과목이 들은 과목이랑 같으면 true
		for (String preCourse: preCourses) { // 327
			boolean takenCourse = false;
			for (String completedCourse: completedCourses) { // 123 324 122
				if(preCourse.equals(completedCourse)) takenCourse = true;
			}
			if(!takenCourse) return false;
		}
		return true;
	}
	@Override
	public boolean enrollCourse(String studentId, String courseId) throws RemoteException {
		if (data.enrollCourse(studentId, courseId)) return true;
		else return false;
	}
	@Override
	public ArrayList<Enrollment> getAllEnrollCourse() throws RemoteException, NullDataException {
		return data.getAllEnrollCourse();
	}
}