package main;

public class Node { // Tương đương typedef trong C
	
	private StudentModel student; // Chứa thông tin của sinh viên
	private Node next;			  // Node trỏ đến vị trí tiếp theo
	public Node(StudentModel student) {
		this.student = student;
		this.next = next;
	}
	public StudentModel getStudent() { // Lấy giá trị của sinh viên
		return student;
	}
	public void setStudent(StudentModel student) { // Gán giá trị cho biến sinh viên
		this.student = student;
	}
	public Node getNext() {             // Truy cập vào giá trị của node tiếp theo
		return next;
	}
	public void setNext(Node next) {	// Gán giá trị cho node tiếp theo
		this.next = next;
	}
	
	
}
