package Exam02.Array;

import java.util.ArrayList;

public class ArrayList_Student {
    public static void main(String[] args) {
        ArrayList<Student> qwer = new ArrayList<>();

        Student student1 = new Student();
        student1.setName("다은");
        qwer.add(student1);

        Student student2 = new Student();
        student1.setName("지은");
        qwer.add(student2);

        Student student3 = new Student();
        student1.setName("아린");
        qwer.add(student3);

        for (Student student : qwer) {
            student.studentShowInfo();
        }
    }
}
