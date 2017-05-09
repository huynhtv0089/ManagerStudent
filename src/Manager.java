import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Manager {
	Validate validate = new Validate();
	Scanner in = new Scanner(System.in);
	
	public Manager() {}
	
	// Nhap 1 sinh vien
	public Student inPut(Student st) {
		String ten = null, sinhNhat = null, nguyenQuan = null, email = null, diaChi = null; 
		int mssv = 0, cmnd = 0;
		
		try {
			System.out.print("Mssv: ");
			mssv = Integer.parseInt(in.nextLine());
			System.out.print("Ten: ");
			ten = in.nextLine();
			System.out.print("So cmnd: ");
			cmnd = Integer.parseInt(in.nextLine());
			System.out.print("Sinh nhat: ");
			sinhNhat = in.nextLine();
			System.out.print("Nguyen quan: ");
			nguyenQuan = in.nextLine();
			System.out.print("Email: ");
			email = in.nextLine();	
			System.out.print("Dia chi: ");
			diaChi = in.nextLine();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// Kiem tra mssv
		if(validate.checkMSSV(mssv) == true) st.setMssv(mssv); else st.setMssv(0);
		// Kiem tra ngay sinh nhat
		if(validate.checkBirthday(sinhNhat) == true) st.setBirthday(sinhNhat); else st.setBirthday("null");
		// Kiem tra chung minh nhan dan
		if(validate.checkNumId(cmnd) == true) st.setNumId(cmnd); else st.setNumId(0);
		// Kiem tra mail
		if(validate.checkMail(email) == true) st.setEmail(email); else st.setEmail("null");
		
		// Thêm vào ArrayList
		st.setName(ten);
		st.setBirthplace(nguyenQuan);
		st.setEmail(email);
		st.setAddress(diaChi);
		
		return st;
	}
	
	
	// Hien thi danh sach sinh vien
	public void outPut(ArrayList<Student> studentList) {
		System.out.printf("%1s  %17s  %16s  %15s  %15s  %14s  %21s \n", "MSSV", "Họ Và Tên", "CMND", "Sinh Nhật", "Nguyên Quán", "Email", "Địa Chỉ");
		for(int i = 0; i < studentList.size(); i++)
			System.out.println(studentList.get(i));
	}
	
	// Them 1 sinh vien
	public ArrayList<Student> addStudent(String command, ArrayList<Student> studentList) {
		Student st = new Student();
		//Phan biet co nen insert hay khong
		if(command.equals("add"))
			inPut(st);
		if(validate.checkDuplicateMSSV(st.getMssv(), studentList) == true) {
			// Neu nhap sai, co loi,.. thi se khong duoc them vao danh sach
			if(st.getMssv() != 0 && st.getBirthday() != "null" && st.getNumId() != 0 && st.getEmail() != "null") {
				studentList.add(st);
			}
		}

		return studentList;
	}
	
	// Lay vi tri
		public String getPosition(String str, ArrayList<Student> studentList) {
	        if(validate.checkNumber(str) != 0) { // number
				int num = validate.checkNumber(str);
				String arrNum = "";
				for(int i=0; i<studentList.size(); i++)
					// kiem tra 2 Integer
					if(num == studentList.get(i).getMssv() || num == studentList.get(i).getNumId())
						arrNum += "|" + (i+1);
				return arrNum;
			}else { // not number
				String arrStr = "";
				for(int i=0; i<studentList.size(); i++)
					// Kiem tra 5 String con lai
					if( str.equals(studentList.get(i).getName()) || str.equals(studentList.get(i).getBirthday()) || str.equals(studentList.get(i).getBirthplace())
						|| str.equals(studentList.get(i).getEmail()) || str.equals(studentList.get(i).getAddress()) )
						arrStr += "|" + (i+1);
				return arrStr;
			}
		}
	
	// Them 1 sinh vine
	public void controlStudent(String command, ArrayList<Student> studentList) {
		// Xuat cau thong bao nhap gia tri - getString
		String str = getString();
		
		/*
		 * Tim gia tri cua sinh sinh vien
		 * Tao kieu array neu co 2 gia tri giong nhau
		 */
		int[] arrTmp = this.searchStudent(str, studentList);
		Student sv = new Student();
		
		if(arrTmp.length <= 2) { // Ket qua la 1
			if(command.equals("insert")) {
				for(int i=1; i<arrTmp.length; i++) {
					System.out.print("Bạn có muốn chèn vào sau vị trí số " + arrTmp[i] + " không ?\n");
					System.out.print("Nhập y(Yes) hoặc n(No): ");
					String answer = in.nextLine();
					if(answer.equals("y")) {
						this.inPut(sv);
						studentList.add((arrTmp[i]-1), sv);
					}
				}
			}else if(command.equals("remove")) {
				for(int i=1; i<arrTmp.length; i++) {
					System.out.print("Bạn có muốn xóa sinh viên ở sau vị trí số " + arrTmp[i] + " không ?\n");
					System.out.print("Nhập y(Yes) hoặc n(No): ");
					String answer = in.nextLine();
					if(answer.equals("y")) {
						studentList.remove(arrTmp[i]-1);
					}
				}
			}
		}else { // Nhieu ket qua
			System.out.print("Có " + (arrTmp.length - 1) + " Kết quả trả về. \n");
			if(command.equals("insert")) {	
				System.out.print("Như kết quả, nhập vị trí muốn chèn vào: ");
				int answer = Integer.parseInt(in.nextLine());
				this.inPut(sv);
				studentList.add(answer-1, sv);
			}else if(command.equals("remove")) {
				System.out.print("Như kết quả, nhập vị trí bạn muốn xóa: ");
				int answer = Integer.parseInt(in.nextLine());
				System.out.print("Bạn chắc chắn chứ ?\n");
				System.out.print("Nhập y(Yes) hoặc n(No): ");
				String answerStr = in.nextLine();
				if(answerStr.equals("y"))
					studentList.remove(answer-1);
			}
		}
	}
	
	// Tim kiem 1 sinh vien
	public int[] searchStudent(String str, ArrayList<Student> studentList) {
		String arrTmp = this.getPosition(str, studentList);	
		
		// Cat chuoi ra thanh mang
		String arrStr[] = arrTmp.split("[|]") ;
		int[] arrInt = new int[arrStr.length];
		
		// Ep kieu String sang kieu int
		for(int i=1; i<arrStr.length; i++)
			arrInt[i] = Integer.parseInt(arrStr[i]);
		
		// Show list
		System.out.printf("%6s %8s  %14s  %15s  %15s  %16s  %16s  %19s \n", "Vị Trí", "MSSV", "Họ Và Tên", "CMND", "Sinh Nhật", "Nguyên Quán", "Email", "Địa Chỉ");
		for(int i=1; i<arrInt.length; i++)
			System.out.print("  " +arrInt[i] + "\t" + studentList.get(arrInt[i]-1) + "\n");
		
		//Tra ve vi tri cua phan tu trong Arraylist
		return arrInt;
	}
	
	// Lay String khi nhap
	public String getString() {
		System.out.print("Nhập thông tin của sinh viên bất kỳ: ");
		String str = in.nextLine();
		
		return str;
	}
	
}
