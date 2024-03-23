package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static final StudentList studentList = new StudentList();

	private static final ArrayList<String> userIds = new ArrayList<>();

	public static void main(String[] args) {
		int option;
		do {
			displayMenu();
			option = scanner.nextInt();
			scanner.nextLine(); // Clear the newline character

			switch (option) {
			case 0:
				break;
			case 1:
				addStudent();
				break;
			case 2:
				addStudentAtPosition();
				System.out.println("Danh sách sinh viên sau khi thêm:");
				printStudentList();

				break;
			case 3:

				studentList.sortByName();
				break;
			case 4:
				studentList.showListOfStudentByGpa();
				; //

				break;
			case 5:

				studentList.StudentGreaterThan7();
				break;
			case 6:
				idList();
				studentList.IdPosition(getStudentIdtoFind()); //
				break;
			case 7:
				String findResult = inputResult();
				System.out.println("THÔNG BÁO: Danh sách sinh viên gồm:\n");
				boolean isFound = studentList.GpaList(findResult);
				if (!isFound) {
					System.out.println("Không tìm thấy sinh viên mà bạn muốn tìm ở trong danh sách");
				}

				break;
			case 8:

				studentList.sortByGpa();
				break;
			case 9:
				studentList.deleteStudentGpaSmallerThan5();
				System.out.println("Danh sách sinh viên sau khi xóa:\n");
				printStudentList();

				break;
			default:
				System.out.println("Lựa chọn của bạn không phù hợp!");
				break;
			}
		} while (option != 0);
		System.out.println("==============================================");
		System.out.println("CẢM ƠN ĐÃ SỬ DỤNG DỊCH VỤ CỦA CHÚNG TÔI");
		System.out.println("==============================================");
		scanner.close();
	}

	private static void displayMenu() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("0. Thoát khỏi chương trình. ");
		System.out.println("1. Thêm danh sách sinh viên.");
		System.out.println("2. Thêm sinh viên vào vị trí k mong muốn.");
		System.out.println("3. Liệt kê danh sách sinh viên theo thứ tự tăng dần của tên.");
		System.out.println("4. Xếp loại sinh viên theo ĐTB.");
		System.out.println("5. Đếm số lượng sinh viên có ĐTB và in ra màn hình.");
		System.out.println("6. Nhập vào mã số sinh viên, in ra vị trí của sinh viên trong danh sách.");
		System.out.println("7. Tìm kiếm DSSV theo kết quả học tập.");
		System.out.println("8. Sắp xếp danh sách sinh viên theo thứ tự giảm dần.");
		System.out.println("9. Xóa toàn bộ sinh viên có ĐTB <= 5");
		System.out.println("Mời bạn nhập lựa chọn(0-9):");
		System.out.println("---------------------------------------------------------------------------");
		System.out.print("\n");
	}

	private static void idList() {
		System.out.println("Danh sách id hiện có là: ");
		for (String id : userIds) {
			System.out.println(id);
		}
	}

	private static void addStudent() {
		String id = getStudentId();
		String name = getStudentName();
		double gpa = getStudentGpa();
		StudentModel student = new StudentModel(id, name, gpa);
		studentList.addManyStudents(student);
	}

	private static void addStudentAtPosition() {
		int position = getStudentPosition();
		scanner.nextLine();
		String id = getStudentId();
		String name = getStudentName();
		double gpa = getStudentGpa();
		StudentModel student = new StudentModel(id, name, gpa);
		studentList.addToK(student, position);
	}

	private static String getStudentId() {
		String id;
		do {
			System.out.println("\nNhập ID sinh viên (4 số từ 1000-9999): ");
			id = scanner.nextLine();
			if (!id.matches("[1-9]\\d{3}")) {
				System.out.println("\nSai kiểu dữ liệu hoặc ID trùng khớp. Try again!\n");
			}
		} while (!id.matches("[1-9]\\d{3}") || userIds.contains(id));
		userIds.add(id);
		return id;
	}

	private static String getStudentIdtoFind() {
		String id;
		do {
			System.out.println("Nhập ID sinh viên (4 số từ 1000-9999): ");
			id = scanner.nextLine();
			if (!id.matches("[1-9]\\d{3}")) {
				System.out.println("\nSai kiểu dữ liệu hoặc ID trùng khớp. Try again!\n");
			}
		} while (!id.matches("[1-9]\\d{3}"));
		userIds.add(id);
		return id;
	}

	private static String getStudentName() {
		System.out.println("Nhập họ và tên sinh viên: ");
		return scanner.nextLine();
	}

	private static double getStudentGpa() {
		double gpa;
		do {
			System.out.println("Nhập GPA sinh viên (Dạng thập phân-ex: 9,...): ");
			while (!scanner.hasNextDouble()) {
				System.out.println("GPA phải nhập ở dạng double. Vui lòng nhập lại.");
				scanner.next(); // Đọc và bỏ qua đầu vào không phải double
			}
			gpa = scanner.nextDouble();
		} while (gpa < 0 || gpa > 10);
		return gpa;
	}

	private static int getStudentPosition() {
		System.out.println("Nhập vào vị trí k muốn thêm sinh viên vào: ");
		return scanner.nextInt();
	}

	private static String inputResult() {
		System.out.println("Nhập vào học lực muốn tìm kiếm-(Giỏi/Khá/Trung bình): ");
		return scanner.nextLine();
	}

	private static void printStudentList() {

		studentList.showListOfStudent();
	}

	// Các phương thức khác có thể được triển khai tương tự như các phương thức trên
}
