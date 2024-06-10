package Exam01.Cooperation;

public class Student {
    public String studentName;    // 학생 이름
    public int money;             // 학생이 가지고 있는 돈

    public Student(String studentName, int money)  // 이름과 돈 초기화하기
    {
        this.studentName = studentName;
        this.money = money;
    }

    public void takeBus(Bus bus) {
        if (this.money < 1000) {
            System.out.println("\n" + studentName + "님은 돈이 없어서 걸어가야합니다.");
            return;
        }
        bus.take(1000);
        this.money -= 1000;
    }

    public void takeSubway(Subway subway) {
        if (this.money < 1500) {
            System.out.println("\n" + studentName + "님은 돈이 없어서 걸어가야합니다.");
            return;
        }
        subway.take(1500);
        this.money -= 1500;
    }

    public void tatkTaxi(Taxi taxi) {
        if (this.money < 6700) {
            System.out.println("\n" + studentName + "님은 돈이 없어서 걸어가야합니다.");
            return;
        }
        taxi.take(6700);
        this.money -= 6700;
    }

    public void showInfo() {
        System.out.println("\n" + studentName + "님의 남은 돈은 " + money + "입니다.");
    }

//    public void Taxi(Taxi taxi) {
//        taxi.take(6700);
//        this.money -= 6700;
//        if (money < 6700) {
//            System.out.println("돈이 없어서 걸어가야합니다.");
//        }
//    }
}
