package Personal;

import java.util.Scanner;

public class MJP {
    static int comRank; // 컴퓨터 승리 횟수
    static int userRank; // 유저 승리 횟수
    static int computer;    //1, 2, 3 (컴퓨터 출력)
    static String computerChoice;  // 1=묵 , 2=찌, 3=빠 문자 (컴퓨터 출력)
    static String userChoice;      // 묵, 찌, 빠 (유저입력)
    static String restart;         // 게임 다시 시작할건지 (예 or 아무거나)
    static int result;  //1 = 이긴거, 2 = 진거, 3 = 비긴거

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //가위바위보
        while(true){
            System.out.println("♥♡♥♡게임을 시작합니다♥♡♥♡");

            userChoice = getUserChoice(sc);
            computerChoice = getComputerChoice();

            System.out.println("컴퓨터 바보 멍청이! : " + computerChoice);

            result = getResult(userChoice, computerChoice);

            while(result == 3){//비긴경우
                System.out.println("♥♡비겼어요 다시 할까요?♥♡");
                System.out.println("---------------");
                userChoice = getUserChoice(sc);
                computerChoice = getComputerChoice();

                System.out.println("컴퓨터 바보 멍청이! : " + computerChoice);
                result = getResult(userChoice, computerChoice);
            }

            if(result == 1){
                System.out.println("♥♡이겼습니다♥♡");
                System.out.println("---------------");
            }
            else{
                System.out.println("ㅠㅠ패배하였습니다ㅠㅠ");
                System.out.println("---------------");
            }

            //묵찌빠
            while(true){
                if(result == 1){
                    System.out.println("♥♡유저의 공격권 입니다♥♡");
                    System.out.println("---------------");
                }
                else{ //result == 2
                    System.out.println("ㅠㅠ컴퓨터의 공격권 입니다ㅠㅠ");
                    System.out.println("---------------");
                }

                userChoice = getUserChoice(sc);
                computerChoice = getComputerChoice();

                System.out.println("컴퓨터 바보 멍청이! : " + computerChoice);

                if(userChoice.equals(computerChoice)){
                    if(result == 1){
                        System.out.println("♥♡♥♡게임에서 이겼습니다♥♡♥♡");
                        System.out.println("---------------");
                        userRank++;
                    }
                    else{   // result == 2
                        System.out.println("ㅠㅠㅠㅠ게임에서 졌습니다ㅠㅠㅠㅠ");
                        System.out.println("---------------");
                        userRank++;
                    }
                    break;
                }
                else{   //같지 않을 때 승패 비교
                    result = getResult(userChoice, computerChoice);
                }
            }

            System.out.print("한판더 할까요?♥♡♥♡(예/나가는 버튼은 없음!) : ");
            restart = sc.next();
            if(!restart.equals("예")){
                break;
            }
        }
        System.out.println("유저의 점수는 : "+userRank+"! 컴퓨터의 점수는 : "+comRank+" ㅠㅠ");
        if(userRank > comRank){
            System.out.print("유저가 "+(userRank-comRank)+"판 더 이겼어요♥♡♥♡");
        }
        else{
            System.out.print("유저가 "+(comRank-userRank)+"판 더 졌어. 컴퓨터 바보 멍청이 똥개 해삼 말미잘!");
        }
    }

    //유저 선택
    public static String getUserChoice(Scanner sc){
        System.out.print("♡묵,찌,빠중 골라주세요♥ : ");
        return sc.next();
    }

    //컴퓨터 선택
    public static String getComputerChoice() {
        computer = (int)(Math.random() * 3)+1;
        switch (computer){
            case 1:
                return "묵";
            case 2:
                return "찌";
            case 3:
                return "빠";
            default:
                return "";
        }
    }

    public static int getResult(String user, String computer){
        if(user.equals("묵")){
            if(computer.equals("묵")) return 3;
            else if (computer.equals("찌")) return 1;
            else return 2;
        }
        else if(user.equals("찌")){
            if(computer.equals("묵")) return 2;
            else if (computer.equals("찌")) return 3;
            else return 1;
        }
        else{
            if(computer.equals("묵")) return 1;
            else if (computer.equals("찌")) return 2;
            else return 3;
        }
    }

}
