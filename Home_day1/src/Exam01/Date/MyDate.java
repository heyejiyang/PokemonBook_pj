package Exam01.Date;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isValid() {
        if (month < 1 || month > 12) {
            return false; // 월이 유효하지 않음
        }

        if (day < 1 || day > 31) {
            return false; // 일이 유효하지 않음
        }

        // 월별 최대 일수를 확인
        switch (month) {
            case 4: case 6: case 9: case 11:
                if (day > 30) {
                    return false;
                }
                break;
            case 2:
                if (isLeapYear(year)) {
                    if (day > 29) {
                        return false;
                    }
                } else {
                    if (day > 28) {
                        return false;
                    }
                }
                break;
            default:
                if (day > 31) {
                    return false;
                }
        }

        return true; // 모든 조건을 통과하면 유효한 날짜
    }

    private boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true; // 윤년
                } else {
                    return false; // 윤년 아님
                }
            } else {
                return true; // 윤년
            }
        } else {
            return false; // 윤년 아님
        }
    }


}
