package Exam03;

public class Customer {
 /* 상속 받은 곳에서 쓸 수 있도록 protected 사용 + get,set S */
    protected int customerID; // 고객 아이디
    protected String customerName; // 고객 이름
    protected String customerGrade; // 고객 등급
 /* 상속 받은 곳에서 쓸 수 있도록 protected 사용 + get,set E */
    int bonusPoint; // 보너스 포인트
    double bonusRatio; // 적립 비율

    public Customer() { // 디폴트 생성자
        customerGrade = "SILVER"; //기본 등급
        bonusRatio = 0.01; // 보너스 포인트 기본 적립 비율
    }

    public Customer(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
        customerGrade = "SILVER";
        bonusRatio = 0.01; // 적립금 1퍼센트
    }

    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio; // 보너스 포인트 계산
        return price;
    }

    public String showCustomerInfo() {
        return customerName + " 님의 등급은 " + customerGrade + "이며, 보너스 포인트는" + bonusPoint + "입니다.";
    }


    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

}

