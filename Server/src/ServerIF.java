import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerIF extends Remote {
	ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException;
	ArrayList<Course> getAllCourseData() throws RemoteException, NullDataException;
	boolean addStudent(String studentInfo) throws RemoteException;
	boolean deleteStudent(String studentId) throws RemoteException;
	boolean addCourse(String courseInfo) throws RemoteException;
	boolean deleteCourse(String courseId) throws RemoteException;
	Student getStudent(String studentId) throws RemoteException, NullDataException;
	Course getCourse(String courseId) throws RemoteException, NullDataException;
	boolean checkPreCourse(Student student, Course course) throws RemoteException;
	boolean enrollCourse(String studentId, String courseId) throws RemoteException;
	ArrayList<Enrollment> getAllEnrollCourse() throws RemoteException, NullDataException;
}