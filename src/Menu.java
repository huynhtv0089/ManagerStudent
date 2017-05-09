import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	Manager manager = new Manager();
	MergeSort sort = new MergeSort();
	Validate validate = new Validate();
	FileExcel fileExcel = new FileExcel();
	Scanner in = new Scanner(System.in);
	
	ArrayList<Student> list = new ArrayList<Student>();
	ArrayList<Student> tmpList = new ArrayList<Student>();
	
	// Menu lua chon them sinh vien danh sach
	public void menuAdd() {
		System.out.print("Lựa chọn tiêu chí \n");
		System.out.print("Số 1. Thêm vào danh sách chính \n");
		System.out.print("Số 2. Thêm vào danh sách phụ \n");
		System.out.print("Số 0. Quay lại \n");
		System.out.print("Chọn số: ");
		String choice = in.nextLine();
		
		// Kiem tra la so
		if(validate.checkEmptyStr(choice) == false || validate.checkNumber(choice) == 0) choice = "0";
		int x = Integer.parseInt(choice);
		
		switch(x) {
			case 1:
				manager.addStudent("add", list);
				break;
			case 2:
				manager.addStudent("add", tmpList);
				break;
			case 0:
				break;
		}
	}
	
	//Menu lua chon hien thi danh sach sinh vien
	public void menuShow() {
		System.out.print("Lựa chọn tiêu chí \n");
		System.out.print("Số 1. Hiển thị danh sách chính \n");
		System.out.print("Số 2. Hiển thị danh sách phụ \n");
		System.out.print("Số 0. Quay lại \n");
		System.out.print("Chọn số: ");
		String choice = in.nextLine();
		
		// Kiem tra la so
		if(validate.checkEmptyStr(choice) == false || validate.checkNumber(choice) == 0) choice = "0";
		int x = Integer.parseInt(choice);
			
		switch(x) {
			case 1:
				if(validate.checkEmptyArr(list) == true)
					manager.outPut(list);
				break;
			case 2:
				if(validate.checkEmptyArr(tmpList) == true)
					manager.outPut(tmpList);
				break;
			case 0:
				break;
		}
	}
	
	// Menu chen sinh vien vao danh sach
	public void menuInsert() {
		System.out.print("Lựa chọn tiêu chí \n");
		System.out.print("Số 1. Chèn sinh viên trong danh sách chính\n");
		System.out.print("Số 2. Chèn sinh viên trong danh sách phụ\n");
		System.out.print("Số 0. Quay lại \n");
		System.out.print("Chọn số: ");
		String choice = in.nextLine();
		
		// Kiem tra la so
		if(validate.checkEmptyStr(choice) == false || validate.checkNumber(choice) == 0) choice = "0";
		int x = Integer.parseInt(choice);
		
		switch(x) {
			case 1:
				if(validate.checkEmptyArr(list) == true)
					manager.controlStudent("insert", list);
				break;
			case 2:
				if(validate.checkEmptyArr(tmpList) == true)
					manager.controlStudent("insert", tmpList);
				break;
			case 0:
				break;
		}
	}
	
	// Xoa 1 sinh vien trong danh sach
	public void menuRemove() {
		System.out.print("Lựa chọn tiêu chí \n");
		System.out.print("Số 1. Xóa sinh viên trong danh sách chính\n");
		System.out.print("Số 2. Xóa sinh viên trong danh sách phụ\n");
		System.out.print("Số 0. Quay lại \n");
		System.out.print("Chọn số: ");
		String choice = in.nextLine();
		
		// Kiem tra la so
		if(validate.checkEmptyStr(choice) == false || validate.checkNumber(choice) == 0) choice = "0";
		int x = Integer.parseInt(choice);
		
		switch(x) {
			case 1:
				if(validate.checkEmptyArr(list) == true)
					manager.controlStudent("remove", list);
				break;
			case 2:
				if(validate.checkEmptyArr(tmpList) == true)
					manager.controlStudent("remove", tmpList);
				break;
			case 0:
				break;
		}
	}
	
	// Menu tim sinh vien
	public void menuSearch() {
		String str;
		
		System.out.print("Lựa chọn tiêu chí \n");
		System.out.print("Số 1. Tìm sinh viên trong danh sách chính\n");
		System.out.print("Số 2. Tìm sinh viên trong danh sách phụ\n");
		System.out.print("Số 0. Quay lại \n");
		System.out.print("Chọn x: ");
		String choice = in.nextLine();
		
		// Kiem tra la so
		if(validate.checkEmptyStr(choice) == false || validate.checkNumber(choice) == 0) choice = "0";
		int x = Integer.parseInt(choice);
		
		switch(x) {
			case 1:
				if(validate.checkEmptyArr(list) == true) {
					str = manager.getString();
					manager.searchStudent(str, list);
				}
				break;
			case 2:
				if(validate.checkEmptyArr(tmpList) == true) {
					str = manager.getString();
					manager.searchStudent(str, tmpList);
				}
				break;
			case 0:
				break;
		}
	}
	
	// Menu sap xep
	public void sortOption() {
		System.out.print("Lựa chọn tiêu chí \n");
		System.out.print("Số 1. Sắp xếp theo mã số sinh viên \n");
		System.out.print("Số 2. Sắp xếp theo họ sinh viên \n");
		System.out.print("Số 3. Sắp xếp theo tên sinh viên \n");
		System.out.print("Số 4. Sắp xếp theo số chứng minh nhân dân \n");
		System.out.print("Số 5. Sắp xếp theo ngày, tháng, năm sinh \n");
		System.out.print("Số 6. Sắp xếp theo nguyên quán \n");
		System.out.print("Số 0. Quay lại \n");
		System.out.print("Chọn số: ");
		String choice = in.nextLine();
		
		// Kiem tra la so
		if(validate.checkEmptyStr(choice) == false || validate.checkNumber(choice) == 0) choice = "0";
		int x = Integer.parseInt(choice);
		
		// Khoi tao bien y
		int  y = -1;
		if(x != 0) {
			System.out.print("Lựa chọn kiểu sắp xếp: \n");
			System.out.print("Số 1. Tăng dần \n");
			System.out.print("Số 2. Giảm dần \n");
			System.out.print("Số 0. Quay lại \n");
			System.out.print("Chọn số: ");
			String nextChoice = in.nextLine();
			
			// Kiem tra la so
			if(validate.checkEmptyStr(nextChoice) == false || validate.checkNumber(nextChoice) == 0) nextChoice = "0";
			y = Integer.parseInt(nextChoice);
		}
		
		switch(x) {
			case 1:
				switch(y) {
					case 1:
						sort.mergeSort(list, "mssv", "donate");
						manager.outPut(list);
						break;
					case 2:
						sort.mergeSort(list, "mssv", "vinegar");
						manager.outPut(list);
						break;
					case 0:
						break;
				}
				break;
			case 2:
				switch(y) {
					case 1:
						sort.mergeSort(list, "firstName", "donate");
						manager.outPut(list);
						break;
					case 2:
						sort.mergeSort(list, "firstName", "vinegar");
						manager.outPut(list);
						break;
					case 0:
						break;
				}
				break;
			case 3:
				switch(y) {
					case 1:
						sort.mergeSort(list, "lastName", "donate");
						manager.outPut(list);
						break;
					case 2:
						sort.mergeSort(list, "lastName", "vinegar");
						manager.outPut(list);
						break;
					case 0:
						break;
				}
				break;
			case 4: 
				switch(y) {
					case 1:
						sort.mergeSort(list, "cmnd", "donate");
						manager.outPut(list);
						break;
					case 2:
						sort.mergeSort(list, "cmnd", "vinegar");
						manager.outPut(list);
						break;
					case 0:
						break;
				}
				break;
			case 5:
				switch(y) {
					case 1:
						sort.mergeSort(list, "birth", "donate");
						manager.outPut(list);
						break;
					case 2:
						sort.mergeSort(list, "birth", "vinegar");
						manager.outPut(list);
						break;
					case 0:
						break;
				}
				break;
			case 6:
				switch(y) {
					case 1:
						sort.mergeSort(list, "place", "donate");
						manager.outPut(list);
						break;
					case 2:
						sort.mergeSort(list, "place", "vinegar");
						manager.outPut(list);
						break;
					case 0:
						break;
				}
				break;
			case 0:
				break;
		}
	}
		
	// Menu gop 2 danh sach lai voi nhau
	public void mergeArray() {
		System.out.print("Lựa chọn tiêu chí \n");
		System.out.print("Số 1. Gộp vào danh sách chính, danh sách phụ bị xóa \n");
		System.out.print("Số 2. Gộp vào danh sách chính, giữ lại danh sách phụ \n");
		System.out.print("Chọn số: ");
		int choice = Integer.parseInt(in.nextLine());
		switch(choice) {
			case 1:
				if(validate.checkEmptyArr(list) == true) {
					list.addAll(tmpList);
					tmpList.clear();
				}
				break;
			case 2:
				list.addAll(tmpList);
				break;
			case 0:
				break;
		}
	}
	
	// Menu Doc va xuat Excel
	public void menuFile() throws IOException {
		// Khoi tao
		String name;
		System.out.print("Lựa chọn tiêu chí \n");
		System.out.print("Số 1. Xuất danh sách sinh viên \n");
		System.out.print("Số 2. Đọc danh sách sinh viên \n");
		System.out.print("Số 0. Quay lại \n");
		System.out.print("Chọn số: ");
		String choice = in.nextLine();
		
		// Kiem tra la so
		if(validate.checkEmptyStr(choice) == false || validate.checkNumber(choice) == 0) choice = "0";
		int x = Integer.parseInt(choice);
		
		int y = -1;
		if(x != 0) {
			System.out.print("Lựa danh sách \n");
			System.out.print("Số 1. Chọn danh sách chính \n");
			System.out.print("Số 2. Chọn danh sách phụ \n");
			System.out.print("Số 0. Quay lại \n");
			System.out.print("Chọn số: ");
			String nextChoice = in.nextLine();
			
			// Kiem tra la so
			if(validate.checkEmptyStr(nextChoice) == false || validate.checkNumber(nextChoice) == 0) nextChoice = "0";
			y = Integer.parseInt(nextChoice);
		}
		
		switch(x) {
			case 1:
				switch(y) {
					case 1:
						System.out.print("Nhập tên file: ");
						name = in.nextLine();
						fileExcel.createExcel(list, name);
						break;
					case 2:
						System.out.print("Nhập tên file: ");
						name = in.nextLine();
						fileExcel.createExcel(tmpList, name);
						break;
					case 0:
						break;
				}
				break;
			case 2:
				switch(y) {
					case 1:
						System.out.print("Nhập tên file cần đọc: ");
						name = in.nextLine();
						fileExcel.readExcel(list, name);
						break;
					case 2:
						System.out.print("Nhập tên file cần đọc: ");
						name = in.nextLine();
						fileExcel.readExcel(tmpList, name);
						break;
					case 0:
						break;
				}
				break;
			case 0:
				break;
		}
	}
	
	// Menu main
	
	public void menuMain() throws IOException {
		int x = -1;
		while(x <= 9) {
			System.out.println("----------- Menu ---------");
			System.out.println("Số 1. Thêm sinh viên");
			System.out.println("Số 2. Hiển thị danh sách sinh viên");
			System.out.println("Số 3. Chèn một sinh viên");
			System.out.println("Số 4. Xóa một sinh viên");
			System.out.println("Số 5. Sắp xếp danh sách");
			System.out.println("Số 6. Tim kiem");
			System.out.println("Số 7. Gộp danh sách phụ vào danh sách chính");
			System.out.println("Số 8. Xuất và Đọc file Excel");
			System.out.println("Số 9. Sửa thông tin sinh viên");
			System.out.println("--------------------------");
			System.out.print("Nhập số: ");
			String choice = in.nextLine();
			
			// Kiem tra la so
			if(validate.checkEmptyStr(choice) == false || validate.checkNumber(choice) == 0) choice = "0";
			x = Integer.parseInt(choice);
			
			//Neu nhap lon hon 9 thi cho quay lai vong lap
			if(x > 9) x = 0;
			
			
			switch(x) {
				case 1:
					this.menuAdd();
					break;
				case 2:
					this.menuShow();
					break;	
				case 3:
					this.menuInsert();
					break;
				case 4:
					this.menuRemove();
					break;
				case 5:
					this.sortOption();
					break;
				case 6:
					this.menuSearch();
					break;
				case 7:
					this.mergeArray();
					break;
				case 8:
					this.menuFile();
					break;
				case 9:
					break;
				case 0:
					break;
			}
		}
	}
}
