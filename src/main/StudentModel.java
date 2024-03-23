package main;

public class StudentModel {
	private String studentID;
    private String fullName;
    private double gpa;
    private String result;

    public StudentModel() {
	}

	public StudentModel(String studentID, String fullName, double gpa) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.gpa = gpa;
        this.result = calculateResult(gpa);
    }

    private String calculateResult(double gpa) {
        if (gpa <= 5) {
            return "Trung bình";
        } else if (gpa <= 8) {
            return "Khá";
        } else {
            return "Giỏi";
        }
    }

    // Getter và Setter cho các thuộc tính
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
        this.result = calculateResult(gpa);
    }

    public String getResult() {
        return result;
    }

}
