import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EnrollmentList {
	protected ArrayList<Enrollment> vEnrollment;
	public EnrollmentList(String enrollmentFileName) throws FileNotFoundException, IOException {
		BufferedReader enrollmentFile = new BufferedReader(new FileReader(enrollmentFileName));
		this.vEnrollment = new ArrayList<Enrollment>();
		while (enrollmentFile.ready()) {
			String enrollInfo = enrollmentFile.readLine();
			if (!enrollInfo.equals("")) this.vEnrollment.add(new Enrollment(enrollInfo));
		}
		enrollmentFile.close();
	}
	public boolean enrollCourse(String enrollInfo) {
		if (vEnrollment.add(new Enrollment(enrollInfo))) return true;
		else return false;
	}
	public ArrayList<Enrollment> getAllEnrollment() throws NullDataException {
		if(this.vEnrollment.size() == 0) throw new NullDataException("******* Enroll data is null *******");
		return this.vEnrollment;
	}
}