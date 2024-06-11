package Exam02.Array;

import java.util.ArrayList;

public class ArrayList_Student {
    public static void main(String[] args) {

        String[] names = {"다은", "지은", "아린"};
        ArrayList<Student> qwer = new ArrayList<>();

        for (String name : names) {
            Student student = new Student(name);
            qwer.add(student);
        }

        for (Student student : qwer) {
            student.studentShowInfo();
        }
    }
}

//        ArrayList<Student> qwer = new ArrayList<>();
//
//        Student student1 = new Student();
//        student1.setName("다은");
//        qwer.add(student1);
//
//        Student student2 = new Student();
//        student2.setName("지은");
//        qwer.add(student2);
//
//        Student student3 = new Student();
//        student3.setName("아린");
//        qwer.add(student3);
//
//        for (Student student : qwer) {
//            student.studentShowInfo();
//        }

