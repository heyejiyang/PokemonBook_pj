package Exam02.Array;

public class Student {
    private static int idIndex = 1000;
    private int studentID;
    private String name;

// 원랜 get,set, 기본 생성자 등등 많이 썻는데 다 없앴다.
    public Student(String name) {
        this.studentID = ++idIndex;
        // 난 1000부터 뽑고싶긴한데 책도 그렇고 강사님도 1001부터 하니깐.
//        this.studentID = idIndex++;
        this.name = name;
    }


    public void studentShowInfo() {
        System.out.println(studentID + "," + name);
    }

}
