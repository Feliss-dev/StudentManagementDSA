package main;

public class StudentModel {
	// Các giá trị của 1 sinh viên: ID, Tên, Điểm, Xếp Loại
	private String studentID;
    private String fullName;
    private double gpa;
    private String result;

    public StudentModel() {
	}
    // Thông tin sinh viên
	public StudentModel(String studentID, String fullName, double gpa) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.gpa = gpa;
        this.result = calculateResult(gpa);
    }
	//Hàm tính toán xếp loại dựa trên điểm trung bình
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
