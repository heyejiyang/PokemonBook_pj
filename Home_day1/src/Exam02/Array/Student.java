package Exam02.Array;

public class Student {
    private static int idIndex = 1000;
    private int studentID;
    private String name;

    public Student() {
        idIndex++;
        studentID = idIndex;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void studentShowInfo() {
        System.out.println(studentID + "," + name);
    }

}
