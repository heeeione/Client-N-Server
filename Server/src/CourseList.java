import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseList {
	protected ArrayList<Course> vCourse;

	public CourseList(String courseFileName) throws IOException {
		BufferedReader courseFile = new BufferedReader(new FileReader(courseFileName));
		this.vCourse = new ArrayList<Course>();
		while (courseFile.ready()) {
			String courseInfo = courseFile.readLine();
			if (!courseInfo.equals("")) this.vCourse.add(new Course(courseInfo));
		}
		courseFile.close();
	}
	public boolean isRegisteredCourse(String courseId) {
		for (int i = 0; i < this.vCourse.size(); i++) {
			Course course = (Course) this.vCourse.get(i);
			if(course.match(courseId)) return true;
		}
		return false;
	}
	public ArrayList<Course> getAllCourseRecords() throws NullDataException {
		if(this.vCourse.size() == 0) throw new NullDataException("******* Course data is null *******");
		return this.vCourse;
	}
	public boolean addCourseRecords(String courseInfo) {
		if(vCourse.add(new Course(courseInfo))) return true;
		else return false;
	}
	public boolean deleteCourseRecords(String courseId) {
		for (int i = 0; i < this.vCourse.size(); i++) {
			Course course = (Course) this.vCourse.get(i);
			if (course.match(courseId)) {
				if(this.vCourse.remove(course)) return true;
				else return false;
			}
		}
		return false;
	}
}