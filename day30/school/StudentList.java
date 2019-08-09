package day26.school;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
	private List<Student> stdArr = new ArrayList<>();

	public StudentList() {
		this(new ArrayList<>());
	}
	
	public StudentList(List<Student> stdArr) {
		super();
		this.stdArr = stdArr;
	}
	
	public List<Student> searchByStudent (String query) {
		query = query.toLowerCase();
		
		List<Student> list = new ArrayList<>();
		
		for(Student student : stdArr) {
			if(student.getName().toLowerCase().contains(query) || student.getID().toLowerCase().contains(query)) {
				list.add(student.clone());
			}
		}
		
		return list;
	}
	
	public List<Student> searchBySubject (String query) {
		List<Student> list = new ArrayList<>();
		
		for(Student student : stdArr) {
			for(Subject subject : student.getSubjects()) {
				if(subject.getID().contains(query) || subject.getName().contains(query)) {
					list.add(student.clone());
				}
			}
		}
		
		return list;
	}
	
	public List<Student> searchByField (String query) {
		List<Student> list = new ArrayList<>();
		
		SubjectType type;
		
		try {
			type = SubjectType.valueOf(query);
		} catch (Exception e) {
			return null;
		}
		
		for(Student student : stdArr) {
			for(Subject subject : student.getSubjects()) {
				if(subject.getType() == type) {
					list.add(student.clone());
				}
			}
		}
		
		return list;
	}
	
	public Student get(String stdID) {
		for(Student student : stdArr) {
			if(student.getID().equals(stdID)) {
				return student;
			}
		}
		
		return null;
	}
	
	public void add(Student student) {
		stdArr.add(student);
	}
	
	public boolean remove(String ID) {
		for(int i = 0; i < stdArr.size(); i++) {
			if(stdArr.get(i).getID().equals(ID)) {
				stdArr.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean edit(Student student) {
		boolean isRemoved = remove(student.getID());
		
		if(!isRemoved) {
			StdManager.outputLog("Edit failed! Student with name " + student.getName() + " and ID " + student.getID() + " does not exist in student list");
			return false;
		}
		
		stdArr.add(student);
		return true;
	}
	
	public Student get(int index) {
		return stdArr.get(index);
	}
	
	// Gets a new list of cloned students and returns it
	public List<Student> getFullList() {
		List<Student> newList = new ArrayList<>();
		
		for(Student student : stdArr) {
			newList.add(student.clone());
		}
		
		return newList;
	}
	
	public int size() {
		return stdArr.size();
	}
	
}
