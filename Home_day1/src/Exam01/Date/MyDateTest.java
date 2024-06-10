package Exam01.Date;

public class MyDateTest {
    public static void main(String[] args) {

        MyDate dat1 = new MyDate(30, 2, 2000);
        if (dat1.isValid()) {
            System.out.println("유효한 날짜입니다.");
        } else {
            System.out.println("유효하지 않은 날짜입니다.");
        }

        MyDate dat2 = new MyDate(2, 10, 2006);
        if (dat2.isValid()) {
            System.out.println("유효한 날짜입니다.");
        } else {
            System.out.println("유효하지 않은 날짜입니다.");
        }

        MyDate dat3 = new MyDate(29, 2, 2100);
        if (dat3.isValid()) {
            System.out.println("유효한 날짜입니다.");
        } else {
            System.out.println("유효하지 않은 날짜입니다.");
        }

    }
    }

