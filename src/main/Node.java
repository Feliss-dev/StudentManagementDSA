package main;

public class Node {
	private StudentModel student;
	private Node next;
	public Node(StudentModel student) {
		this.student = student;
		this.next = next;
	}
	public StudentModel getStudent() {
		return student;
	}
	public void setStudent(StudentModel student) {
		this.student = student;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
