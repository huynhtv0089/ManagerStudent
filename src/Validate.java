import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	
	// Kiem tra danh sach rong
	public boolean checkEmptyArr(ArrayList<Student> studentList) {
		if(studentList.isEmpty()) {
			System.out.print("Thông báo: Danh sách không có dữ liệu.\n");
			return false;
		}else {
			return true;
		}
	}
	
	// Kiem tra chuoi rong
	public boolean checkEmptyStr(String str) {
		if(str.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	// kiem tra number va lay number
	public int checkNumber(String str) {
		Pattern pattern = Pattern.compile("\\d*");
        Matcher matcher = pattern.matcher(str);
        
        int num = 0;
        if(matcher.matches()) {
        	num = Integer.parseInt(str);
        	return num;
        }else {
        	return 0;
        }
	}
	
	// Kiem tra mssv co trung hay khong
	public boolean checkDuplicateMSSV(int mssv, ArrayList<Student> studentList) {
		for(int i=0; i<studentList.size(); i++) {
			if(studentList.get(i).getMssv() == mssv) {
				System.out.print("Lỗi: Mã số sinh viên đã trùng\n");
				return false;
			}
		}
		return true;
	}
	
	//Kiem tra gia tri ma so sinh vien
	public boolean checkMSSV(int mssv) {
		// Doi int thanh String
		String str = Integer.toString(mssv);
		if(this.checkNumber(str) != 0) {
			if(mssv < 1999999999) {
				Pattern pattern = Pattern.compile("\\d{10}");
		        Matcher matcher = pattern.matcher(str);
				if(!matcher.matches()) {
					System.out.print("Lỗi: Mã số sinh viên phải là 10 chữ số\n");
					return false;
				}
			}else {
				System.out.print("Lỗi: Giá trị mã số sinh viên vượt quá giới hạn cho phép, phải thấp hơn: 1.999.999.999\n");
				return false;
			}
		}else { 
			System.out.print("Lỗi: Giá trị mã số sinh viên không phải là số\n");
			return false;
		}
		return true;
	}
	
	// Kiem tra gia tri Birthday
	public boolean checkBirthday(String birthday) {
		Pattern pattern = Pattern.compile("\\d{1,2}\\/\\d{1,2}\\/\\d{4,4}");
        Matcher matcher = pattern.matcher(birthday);
        
        // Kiem tra do dai cua ngay thang nam sinh
        if(matcher.matches()) {
			// Gan them ky tu "/" vao chuoi
			String tmpStr = "/" + birthday;
			
			// Cat chuoi
			// Gia tri str[0] la gia tri rong khi da cat "/"
			String[] str = tmpStr.split("[/]");
			int[] tmpInt = new int[str.length];
					
			// Kiem tra ky tu co phai la so
			for(int i=1; i < str.length; i++) {
				// Neu khong phai so
				if(this.checkNumber(str[i]) == 0) {
					System.out.print("Lỗi: Giá trị ngày hoặc tháng hoặc năm sinh không phải là số\n");
					return false;
				}else {
					// Chuyen kieu String sang int
					tmpInt[i] = Integer.parseInt(str[i]);
				}
			}
			
			// Kiem tra ve thang
			if(tmpInt[2] > 12) {
				System.out.print("Lỗi: Yêu cầu nhập đúng giá trị ngày, tháng, năm sinh\n");
				return false;
			}
			// Kiem tra ve nam
			if (tmpInt[3] > 2016) {
				System.out.print("Lỗi: Yêu cầu nhập đúng giá trị ngày, tháng, năm sinh\n");
				return false;	
			}
			// Kiem tra ngay, trong thang
			// Neu la nam nhuan thi thang 2: 29 ngay,
			if((tmpInt[3]%400 == 0) || tmpInt[3]%4 == 0 && tmpInt[3]%100 != 0) {
				if(tmpInt[1] > 29) {
					System.out.print("Lỗi: Yêu cầu nhập đúng giá trị ngày, tháng, năm sinh\n");
					return false;
				}
			}else {
				if(tmpInt[1] > 28){
					System.out.print("Lỗi: Yêu cầu nhập đúng giá trị ngày, tháng, năm sinh\n");
					return false;
				}
			}
			// Kiem tra nhung thang co 30, hoac 31 ngay
			if(tmpInt[2] == 1 || tmpInt[2] == 3 || tmpInt[2] == 5 || tmpInt[2] == 7 || tmpInt[2] == 8 || tmpInt[2] == 10 ||tmpInt[2] == 12) {
				if(tmpInt[1] > 31) {
					System.out.print("Lỗi: Yêu cầu nhập đúng giá trị ngày, tháng, năm sinh\n");
					return false;
				}
			}else if(tmpInt[2] == 4 || tmpInt[2] == 6 || tmpInt[2] == 9 || tmpInt[2] == 11) {
				if(tmpInt[1] > 30) {
					System.out.print("Lỗi: Yêu cầu nhập đúng giá trị ngày, tháng, năm sinh\n");
					return false;
				}
			}
			
        }else {
        	System.out.print("Lỗi: Không phải là ngày, tháng, năm sinh\n");
        	return false;
        }
		return true;
	}
	
	// Kiem tra gia tri Chung minh nhan dan
	public boolean checkNumId(int numId) {
		// Doi int thanh String
		String str = Integer.toString(numId);
		if(this.checkNumber(str) != 0) {
			Pattern pattern = Pattern.compile("\\d{9}");
	        Matcher matcher = pattern.matcher(str);
			if(!matcher.matches()) {
				System.out.print("Lỗi: Chứng minh nhân dân phải là 9 chữ số\n");
				return false;
			}
			
		}else { 
			System.out.print("Lỗi: Giá trị chứng minh nhân dân không phải là số\n");
			return false;
		}
		return true;
	}
	
	// Kiem tra gia tri mail
	public boolean checkMail(String mail) {
		Pattern pattern = Pattern.compile("^[a-z][a-z0-9\\_\\.]{4,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$");
        Matcher matcher = pattern.matcher(mail);
        if(!matcher.matches()) {
			System.out.print("Lỗi: Giá trị mail nhập vào không đúng\n");
			return false;
		}
        
        return true;
	}
}
