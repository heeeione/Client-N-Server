import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Enrollment implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String studentId;
	protected ArrayList<String> courseId;
	
	public Enrollment(String inputString) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputString);
		this.studentId = stringTokenizer.nextToken();
		this.courseId = new ArrayList<String>();
		while (stringTokenizer.hasMoreTokens()) {
			this.courseId.add(stringTokenizer.nextToken());
		}
	}
	public String toString() {
		String stringReturn = this.studentId;
		for (int i = 0; i < this.courseId.size(); i++) {
			stringReturn = stringReturn + " " + this.courseId.get(i).toString();
		}
		return stringReturn;
	}

}
