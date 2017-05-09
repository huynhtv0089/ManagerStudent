import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileExcel {
	
	Manager manager = new Manager();
	Validate validate = new Validate();
	
	//Create file excel
	public XSSFCellStyle createStyleForTitle(XSSFWorkbook workbook) {
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}
	
	public void createExcel(ArrayList<Student> studentList, String nameFile) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		
		ArrayList<Student> List = manager.addStudent("noadd", studentList);
		int rowNum = 0;
		Cell cell;
		Row row;
		
		XSSFCellStyle style = createStyleForTitle(workbook);
		row = sheet.createRow(rowNum);
		
		//MSSV
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("MSSV");
		cell.setCellStyle(style);
		//Name
		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Họ và tên");
		cell.setCellStyle(style);
		//CMND
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Số CMND");
		cell.setCellStyle(style);
		// Birthday
		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Ngày, tháng, năm sinh");
		cell.setCellStyle(style);
		//Birthplace
		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Quê quán");
		cell.setCellStyle(style);
		//Email
		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Email");
		cell.setCellStyle(style);
		//Address
		cell = row.createCell(6, CellType.STRING);
		cell.setCellValue("Địa chỉ hiện tại");
		cell.setCellStyle(style);
		
		//DATA
		for(Student st : List) {
			rowNum++;
			row = sheet.createRow(rowNum);
			
			//MSSV
			cell = row.createCell(0, CellType.NUMERIC);
			cell.setCellValue(st.getMssv());
			//Name
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(st.getName());
			//CMND
			cell = row.createCell(2, CellType.NUMERIC);
			cell.setCellValue(st.getNumId());
			//Birthday
			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(st.getBirthday());
			//Birthplace
			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(st.getBirthplace());
			//Email
			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(st.getEmail());
			//Address
			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue(st.getAddress());
		}
		
		File file = new File("C:"+ nameFile +".xlsx");
		file.getParentFile().mkdirs();
		
		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		System.out.println("Đã tạo file ở địa chỉ: " + file.getAbsolutePath());
	}
	
	// Doc va luu file Excel vo danh sach
	public void readExcel(ArrayList<Student> studentList, String nameFile) throws IOException {
		//read file xlsx
		FileInputStream inputStream = new FileInputStream(new File("C:"+ nameFile +".xlsx"));
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		if(sheet != null && sheet.getLastRowNum() > 0) {
			int count = 0;
			String name, birthday, birthplace, email, address;
			int mssv, numId;
			for(int i=1; i<=sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if(row != null && row.getLastCellNum() > 0) {
					Student st = new Student();
					
					//Cell 0: Mssv
					Cell cell = row.getCell(0);
					st.setMssv((int)cell.getNumericCellValue());
					
					//Cell 1: Name
					cell = row.getCell(1);
					st.setName(cell.getStringCellValue());
					
					//Cell 2: CMND
					cell = row.getCell(2);
					st.setNumId((int) cell.getNumericCellValue());
					
					//Cell 3: Birthday
					cell = row.getCell(3);
					st.setBirthday(cell.getStringCellValue());

					//Cell 4: Birthplace
					cell = row.getCell(4);
					st.setBirthplace(cell.getStringCellValue());
					
					//Cell 5: eMail 
					cell = row.getCell(5);
					st.setEmail(cell.getStringCellValue());
					
					//Cell 6: Address
					cell = row.getCell(6);
					st.setAddress(cell.getStringCellValue());
					
					if(validate.checkDuplicateMSSV(st.getMssv(), studentList) == true) {
						studentList.add(st);
						count++;
					}
				}
			}
			workbook.close();
			System.out.print("Co " + count + " sinh vien đã thêm thành công.\n");
		}
		workbook.close();
	}
	
}
