package Exam01.Cooperation;

public class TakeTrans {
    public static void main(String[] args) {
        // 두 명의 학생을 생성
        Student Yunda = new Student("윤다은", 5000);
        Student ChaeDoa = new Student("채도아", 8000);
        Student DoSeonHwa = new Student("도선화", 1200);
        Student RyuDaHye = new Student("류다혜", 100);

//        Bus bus262 = new Bus(262);

        Bus bus7016 = new Bus(7016);
        DoSeonHwa.takeBus(bus7016);
        DoSeonHwa.showInfo();
        bus7016.showInfo();

        RyuDaHye.takeBus(bus7016);
        RyuDaHye.showInfo();

        Taxi yellowTaxi = new Taxi("kakaoTaxi");
        ChaeDoa.tatkTaxi(yellowTaxi);
        ChaeDoa.showInfo();
        yellowTaxi.showInfo();

        Taxi grayTaxi = new Taxi("개인택시");
        Yunda.tatkTaxi(grayTaxi);
        Yunda.showInfo();
        grayTaxi.showInfo();

    }
}
