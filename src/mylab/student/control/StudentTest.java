package mylab.student.control;

import mylab.student.entity.Student;

public class StudentTest {
	public static void main(String[] args) {
		Student student = new Student("�й�", "��μ�", "��ǻ�Ͱ���", 3);
		
		System.out.println(student);
		
		System.out.println("5�г����� ����");
		student.setGrade(5);
	}
}
