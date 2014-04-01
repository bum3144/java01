package basic.exam05.step06.ex;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentControl {
	static Scanner	          scanner;
	public ArrayList<Student>	studentList	= new ArrayList<Student>();

	public void add(final Student student) {
		studentList.add(student);
	}

	public void remove(final int no) {
		studentList.remove(no);
	}

	public void update(final int no, final Student student) {
		studentList.set(no, student);
	}

	public void save() {
		try {
			FileWriter out = new FileWriter("studentList.data");
			for (Student student : studentList) {
				out.write(student.toString() + "\n");
			}
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		try {
			FileReader in = new FileReader("studentList.data");
			Scanner s = new Scanner(System.in);
			while (true) {
				try {
					studentList.add(Student.fromCSV(s.nextLine()));
				} catch (NoSuchElementException e) {
					break;
				}
			}
			s.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
