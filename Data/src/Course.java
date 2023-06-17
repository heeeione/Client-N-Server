import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String courseId;
	protected String professorName;
	protected String courseName;
	protected ArrayList<String> preCourseList;
	
	public Course(String inputString) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputString);
		this.courseId = stringTokenizer.nextToken();
		this.professorName = stringTokenizer.nextToken();
		this.courseName = stringTokenizer.nextToken();
		this.preCourseList = new ArrayList<String>();
		while (stringTokenizer.hasMoreTokens()) {
			this.preCourseList.add(stringTokenizer.nextToken());
		}
	}
	public ArrayList<String> getpreCoursesList() {
		return this.preCourseList;
	}
	public String toString() {
		String stringReturn = this.courseId + " " + this.professorName + " " + this.courseName;
		for (int i = 0; i < this.preCourseList.size(); i++) {
			stringReturn = stringReturn + " " + this.preCourseList.get(i).toString();
		}
		return "\n" + stringReturn;
	}
	public boolean match(String courseId) {
		return this.courseId.equals(courseId);
	}
}