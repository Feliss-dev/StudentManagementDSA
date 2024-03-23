package main;

public class StudentList {
    private Node head, tail;

    public StudentList() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
    
    //Thêm 1 sinh viên mới vào cuối danh sách
    public void addNewStudent(StudentModel student) {
        Node newNode = new Node(student); 		// Khởi tạo nút
        if (isEmpty()) { 				  		// Kiểm tra rổng
            this.head = this.tail = newNode;	// Gán nút đầu tiên bằng nút mới vừa tạo
        } else {
            this.tail.setNext(newNode);			// Nếu nút không rỗng, để tail trỏ tới nút tiếp theo là nút mới
            this.tail = newNode;				// Gán tail bằng nút mới
        }
    }
    
	public void addToHead(StudentModel student) {
		Node newNode = new Node(student);
		// Kiểm tra nếu danh sách đang rỗng
		if(this.head == null) {					// Nếu danh sách rỗng nút mới = nút đầu
			this.head = newNode;
		}
		else {
			newNode.setNext(this.head) ;		// Nếu danh sách không rỗng, gán nút tiếp theo sau head = newNode
			this.head = newNode;
		}
	}
    
    public void showListOfStudent() {
        Node current = this.head;
        while (current != null) {						// Duyệt danh sách
            printStudentInfo(current.getStudent());		// In ra thông tin của nút đang trỏ 
            current = current.getNext();				// Trỏ tới nút tiếp theo
        }
    }

    public void addManyStudents(StudentModel... listOfStudent) {
        for (StudentModel newStudent : listOfStudent) {			// Thêm nhiều sinh viên 
            addNewStudent(newStudent);
        }
    }

    public void printStudentInfo(StudentModel student) {				// In ra thông tin của sinh viên 
        System.out.println(student.getStudentID() + " - "				// Bao gồm: ID, Tên, GPA
                + student.getFullName() + " - " + student.getGpa()
        );
    }

    public void showListOfStudentByGpa() {			// Hàm in ra kết quả của sinh viên dựa trên GPA
        Node current = this.head;					// Duyệt danh sách - Lấy thông tin của nút - In ra
        while (current != null) {
            System.out.println("Xếp loại SV: " + current.getStudent().getStudentID() + " - "
                    + current.getStudent().getFullName() + " - " + current.getStudent().getGpa()
                    + " - " + current.getStudent().getResult());
            current = current.getNext();
        }
    }

    public boolean StudentGreaterThan7() { // Hàm tìm và in ra các sinh viên có điểm trung bình lớn hơn 7
        Node current = this.head;
        int count = 0; // Khởi tạo biến count = 0 để đếm số lượng
        while (current != null) {
            if (current.getStudent().getGpa() >= 7) { //Kiểm tra điểm sinh viên có lớn 7 hay không
                count++;
                printStudentInfo(current.getStudent());  // In ra thông tin nếu thỏa mãn đk
            }
            current = current.getNext();        //Truy cập đến nút tiếp theo
        }
        System.out.println("Số lượng sinh viên có điểm trung bình lớn hơn hoặc bằng 7 là: " + count);
        return count > 0;
    }

    public boolean IdPosition(String id) {   // Hàm kiểm tra vị trí của sinh viên dựa trên item
        Node current = this.head;
        int count = 0;
        while (current != null) {
            count++;
            if (current.getStudent().getStudentID().contains(id)) {  // Kiểm tra id nhập vào có tồn tại không
                System.out.println("\nTHÔNG BÁO: Sinh viên có " + id + " nằm ở vị trí " + count); // In ra
                return true;
            }
            current = current.getNext(); // Truy cập biến tiếp theo
        }
        return false;
    }

    public boolean GpaList(String result) { // Hàm in ra các sinh có xếp hạng được nhập
        Node current = this.head;
        boolean isFound = false;
        while (current != null) {
            if (current.getStudent().getResult().equalsIgnoreCase(result)) { // Nếu xếp hạng nhập vào tồn tại
                printStudentInfo(current.getStudent());     // In ra tất cả các sinh viên có xếp hạng đấy
                isFound = true;
            }
            current = current.getNext();
        }
        return isFound;
    }

    public boolean deleteStudentGpaSmallerThan5() { // Xóa tất cả các sinh viên có điểm trung bình < 5
        if (isEmpty())
            return false;

        Node prevNode = null;                         // Khởi tạo nút null
        Node currNode = this.head;					  // Khởi tạo nút đang trỏ vào là nút đầu tiên

        while (currNode != null) {
            if (currNode.getStudent().getGpa() < 5.0) {
                if (prevNode == null) {
                    this.head = this.head.getNext();
                    currNode = this.head;
                } else {
                    prevNode.setNext(currNode.getNext());
                    currNode = currNode.getNext();
                }
            } else {
                prevNode = currNode;
                currNode = currNode.getNext();
            }
        }
        return true;
    }

    public void sortByName() {     // Sắp xếp theo tên-Tên nào có độ lớn ở dạng số nguyên nhỏ hơn sẽ lên đầu
        Node current = this.head;
        while (current != null) {
            Node min = current;				// Khởi tạo tên có độ lớn nhỏ nhất là nút đang trỏ vào
            Node next = current.getNext();	// Nút tiếp theo
            while (next != null) {          // Nếu nút tiếp theo min không rỗng
                if (next.getStudent().getFullName().compareTo(min.getStudent().getFullName()) < 0) {
                    min = next;				// Độ lớn của next nhỏ hơn min thì gán min = next
                }
                next = next.getNext();		// Truy cập đến nút next tiếp theo
            }										    // Đổi chỗ vị trí nút next và min
             											// Minh họa của selection sort:
            StudentModel temp = current.getStudent();	// temp = current
            current.setStudent(min.getStudent());	    // current = min
            min.setStudent(temp);					    // min = temp   Sau đó truy cập đến nút tiếp theo
            current = current.getNext();
        }
        showListOfStudent();
    }

    public void sortByGpa() { 						// Sắp xếp thứ tự từ cao đến thấp dựa vào GPA
        Node current = this.head;
        while (current != null) {
            Node max = current;
            Node next = current.getNext();
            while (next != null) {
                if (next.getStudent().getGpa() > max.getStudent().getGpa()) {  //Lấy GPA từ cao đến thấp theo danh sách
                    max = next;
                }
                next = next.getNext();
            }
            StudentModel temp = current.getStudent();
            current.setStudent(max.getStudent());
            max.setStudent(temp);
            current = current.getNext();
        }
        showListOfStudent();
    }
    public void addToK(StudentModel student, int k) {   // Thêm sinh viên vào 1 vị trí bất kì trong danh sách
        if (isEmpty() || k <= 1) {
            addToHead(student);
            return;
        }

        Node newNode = new Node(student);
        int count = 1;
        Node prevNode = null;
        Node currNode = this.head;

        while (currNode != null && count < k) {
            count++;
            prevNode = currNode;
            currNode = currNode.getNext();
        }

        if (currNode == null && count < k) {
            addNewStudent(student);
            return;
        }

        prevNode.setNext(newNode);
        newNode.setNext(currNode);
    }
}
