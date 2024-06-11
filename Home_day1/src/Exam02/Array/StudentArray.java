package Exam02.Array;

public class StudentArray {
    public static void main(String[] args) {

        String[] names = {"Yunda", "ChaeDoa", "DoSeonHwa", "RyuDaHye", "KimMinJae"};
        Student[] students = new Student[names.length];

        for (int i = 0; i < names.length; i++) {
            students[i] = new Student(names[i]);
        }

        // 각 학생의 정보를 출력
        for (Student student : students) {
            student.studentShowInfo();
        }
    }
}

//        Student[] students = new Student[5];
//
//        students[0] = new Student();
//        students[0].setName("Yunda");
//
//        students[1] = new Student();
//        students[1].setName("ChaeDoa");
//
//        students[2] = new Student();
//        students[2].setName("DoSeonHwa");
//
//        students[3] = new Student();
//        students[3].setName("RyuDaHye");
//
//        students[4] = new Student();
//        students[4].setName("KimMinJae");
//
//        // 각 학생의 정보를 출력
//        for (int i = 0; i < students.length; i++) {
//            students[i].studentShowInfo();
//        }

