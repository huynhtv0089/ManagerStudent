import java.util.ArrayList;

public class MergeSort {
	public MergeSort() {}
	
	public void merge(ArrayList<Student> studentList, ArrayList<Student> leftStudentList, ArrayList<Student> rightStudentList, String option, String value) {
		int index = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		
		while(leftIndex < leftStudentList.size() && rightIndex < rightStudentList.size()) {
			/*
			 * Sap sep theo ma so sinh vien
			 */
			if(option.equals("mssv")) {
				if(value.equals("donate")) { // Sap xep tang dan
					if(leftStudentList.get(leftIndex).getMssv() > rightStudentList.get(rightIndex).getMssv()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else { 
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
	
				} else if(value.equals("vinegar")) { // Sap xep giam dan
					if(leftStudentList.get(leftIndex).getMssv() < rightStudentList.get(rightIndex).getMssv()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else {
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
				}
			/*
			 * Sap xep theo chung minh nhan dan	
			 */
			} else if(option.equals("cmnd")) {
				if(value.equals("donate")) { // Sap xep tang dan
					if(leftStudentList.get(leftIndex).getNumId() < rightStudentList.get(rightIndex).getNumId()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else {
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
					
				} else if(value.equals("vinegar")) { // Sap xep giam dan
					if(leftStudentList.get(leftIndex).getNumId() > rightStudentList.get(rightIndex).getNumId()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else {
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
				}
			/*
			 * Sap xep theo ngay, thang, nam sinh
			 */
			} else if(option.equals("birth")) {
				if(value.equals("donate")) { // Sap xep tang dan
					if(leftStudentList.get(leftIndex).getBirth() < rightStudentList.get(rightIndex).getBirth()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else {
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
					
				} else if(value.equals("vinegar")) { // Sap xep giam dan
					if(leftStudentList.get(leftIndex).getBirth() > rightStudentList.get(rightIndex).getBirth()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else {
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
				}
			/*
			 * Sap xep theo nguyen quan
			 */
			}else if(option.equals("place")) {
				if(value.equals("donate")) { // Sap xep tang dan
					if(leftStudentList.get(leftIndex).getPlace() < rightStudentList.get(rightIndex).getPlace()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else {
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
					
				} else if(value.equals("vinegar")) { // Sap xep giam dan
					if(leftStudentList.get(leftIndex).getPlace() > rightStudentList.get(rightIndex).getPlace()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else {
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
				}
			/*
			 * Sap xep theo ho
			 */
			}else if(option.equals("firstName")) {
				if(value.equals("donate")) { // Sap xep tang dan
					if(leftStudentList.get(leftIndex).getFirstName() < rightStudentList.get(rightIndex).getFirstName()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else {
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
					
				} else if(value.equals("vinegar")) { // Sap xep giam dan
					if(leftStudentList.get(leftIndex).getFirstName() > rightStudentList.get(rightIndex).getFirstName()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else {
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
				}
			/*
			 * Sap xep theo ten
			 */
			}else if(option.equals("lastName")) {
				if(value.equals("donate")) { // Sap xep tang dan
					if(leftStudentList.get(leftIndex).getLastName() < rightStudentList.get(rightIndex).getLastName()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else {
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
					
				} else if(value.equals("vinegar")) { // Sap xep giam dan
					if(leftStudentList.get(leftIndex).getLastName() > rightStudentList.get(rightIndex).getLastName()) {
						studentList.set(index, leftStudentList.get(leftIndex));
						leftIndex++;
						index++;
					} else {
						studentList.set(index, rightStudentList.get(rightIndex));
						rightIndex++;
						index++;
					}
				}
			}
		}
		
		
		if(rightIndex >= rightStudentList.size()) {
			while(leftIndex < leftStudentList.size()) {
				studentList.set(index, leftStudentList.get(leftIndex));
				leftIndex++;
				index++;
			}
		}
		
		if(leftIndex >= leftStudentList.size()) {
			while(rightIndex < rightStudentList.size()) {
				studentList.set(index, rightStudentList.get(rightIndex));
				rightIndex++;
				index++;
			}
		}
	}
	
	public void mergeSort(ArrayList<Student> studentList, String option, String value) {
		if (studentList.size() == 1) {
			return;
		}
		int mid = studentList.size() / 2;
		ArrayList<Student> leftStudentList = new ArrayList<Student>();
		ArrayList<Student> rightStudentList = new ArrayList<Student>();
		 
		for (int i = 0; i < mid; i++) {
			leftStudentList.add(studentList.get(i));
		}
		 
		for (int i = mid; i <= studentList.size() - 1; i++) {
			rightStudentList.add(studentList.get(i));
		}
		
		mergeSort(leftStudentList, option, value);
		mergeSort(rightStudentList, option, value);

		this.merge(studentList, leftStudentList, rightStudentList, option, value);		
	}
	
}
