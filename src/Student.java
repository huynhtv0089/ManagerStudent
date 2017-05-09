
public class Student {
	private String name, birthday, birthplace, email, address;
	private int mssv, numId;
	
	public Student() {}
	
	public Student(int mssv, String name, int numId, String birthday, String birthplace, String email, String address) {
		this.mssv = mssv;
		this.name = name;
		this.numId = numId;
		this.birthday = birthday;
		this.birthplace = birthplace;
		this.email = email;
		this.address = address;
	}
	
	public int getMssv() {
		return this.mssv;
	}
	public void setMssv(int mssv) {
		this.mssv = mssv;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumId() {
		return this.numId;
	}
	public void setNumId(int numId) {
		this.numId = numId;
	}
	
	public String getBirthday() {
		return this.birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getBirthplace() {
		return this.birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return mssv + "    " + name +"\t   " + numId + "\t" + birthday + "\t" + birthplace + "    " + email + "\t   " + address;
	}
	
	
	/*
	 * Lay du lieu
	 */
	
	// Lay ngay, thang, nam sinh
	public int getBirth() {
		// Gan them "/" vao chuoi
		String strBirth = "/" + this.birthday;
		
		// Cat chuoi
		String[] tmpStr = strBirth.split("[/]");	
		
		// Chuyen dinh dang, vd:20161205
		String birth = tmpStr[3] + tmpStr[2] + tmpStr[1];
		
		// Ep kieu
		int intBirth = Integer.parseInt(birth);
		
		return intBirth;
	}
	
	// Bang chu cai Alphabet
	public int alphabetNumber(String str) {
		int getNum = 0;
		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
				 				"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
		
		for(int i=0; i<number.length; i++) {
			if(str.equals(alphabet[i])) {
				getNum = number[i];
			}
		}
		return getNum;
	}
	
	// Cat ten
	public String splitName() {
		String strName = " " + this.getName(); 
		String[] arrName = strName.split("[ ]");
		
		// Lay vi tri mang cuoi cung
		return arrName[arrName.length - 1];
	}
	
	// Lay tung ky tu trong chuoi
	public char charArr(String arrStr) {
		char[] arr = arrStr.toCharArray();
		
		// Lay Ky tu dau tien cua chuoi
		return arr[0];
	}
	
	// Lay so cua ky tu dau tien
	public int getFirstString(String str) {
		// Lay ky tuM
		char c = this.charArr(str);
		char[] charArr = {c};
		
		// Chuyen kieu Char sang String
		String strChar = String.copyValueOf(charArr);
		
		// Chuyen chu hoa thanh chu thuong
		String toLower = strChar.toLowerCase();
		
		//Lay int
		int getNum = this.alphabetNumber(toLower);
		
		return getNum;
	}
	
	// Lay nguyen quan
	public int getPlace() {
		return this.getFirstString(this.getBirthplace());
	}
	
	// Lay ho
	public int getFirstName() {
		return this.getFirstString(this.getName());
	}
	
	// Lay ten
	public int getLastName() {
		return this.getFirstString(this.splitName());
	}
}
