package Exam02.Array;

public class Student {
    private static int idIndex = 1000;
    private int studentID;
    private String name;


    public Student(String name) {
        this.studentID = ++idIndex;
//        this.studentID = idIndex++;
        this.name = name;
    }


    public void studentShowInfo() {
        System.out.println(studentID + "," + name);
    }

}
