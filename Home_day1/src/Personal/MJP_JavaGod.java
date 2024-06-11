//package Personal;
//
//import java.util.Scanner;
//
//public class MJP_JavaGod {
//    static int comWins;
//    static int userRank;
//    int userRating = 100; //기본점수 100점
//    static int userWins;
//    static int computer; //1, 2, 3     숫자(컴퓨터 출력)
//    static String computerChoice;  // 1=묵 , 2=찌, 3=빠      문자 (컴퓨터 출력)
//    static String userChoice;  // 묵, 찌, 빠 (유저입력)
//    static String restart;  // 게임 다시 시작할건지 (예 or 아무거나)
//    static int result;  //1 = 이긴거, 2 = 진거, 3 = 비긴거
//    static String choice; // 묵찌빠 예외처리
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner();
//
//        //가위바위보
//        while (true) {
//            comWins = 0;
//            userWins = 0;
//            while (userWins<3 && comWins <3) {
//                System.out.println("가위바위보 시작!!");
//                userChoice = getUserChoice(sc);
//                computerChoice = getComputerChoice();
//
//                System.out.println("컴퓨터: " + computerChoice);
//
//                result = getResult(userChoice, computerChoice);
//
//                while (result == 3) {//비긴경우
//                    System.out.println("비겼습니다. 다시 내주세요!");
//                    System.out.println(Templates.getInstance().Line());
//
//                    userChoice = getUserChoice(sc);
//                    computerChoice = getComputerChoice();
//
//                    System.out.println("컴퓨터 : " + computerChoice);
//                    result = getResult(userChoice, computerChoice);
//                }
//                /* 여기 로직은 빼도 될 거 같음 E */
//                if (result == 1) {
//                    System.out.println("가위바위보에서 승리하셨습니다!👍");
//                    System.out.println(Templates.getInstance().Line());
//                } else {
//                    System.out.println("😢가위바위보에서 패배하였습니다");
//                    System.out.println(Templates.getInstance().Line());
//                }
//                /* 여기 로직은 빼도 될 거 같음 S */
//
//                //묵찌빠
//                while (true) {
//                    if (result == 1) {
//                        System.out.println("😎당신의 공격권 입니다!😎");
//                        System.out.println(Templates.getInstance().Line());
//                    } else { //result == 2
//                        System.out.println("️️📺컴퓨터의 공격권 입니다📺");
//                        System.out.println(Templates.getInstance().Line());
//                    }
//
//                    userChoice = getUserChoice(sc);
//                    computerChoice = getComputerChoice();
//
//                    System.out.println("컴퓨터 : " + computerChoice);
//
//                    if (userChoice.equals(computerChoice)) {
//                        if (result == 1) {
//                            System.out.println("♥♡게임에서 이겼습니다♥♡");
//                            System.out.println(Templates.getInstance().Line());
//                            userRank = (int) (Math.random() * 37) + 10;
//                            userWins++;
//                            //userRating += userRank;
//                            userRating += 20; //이겼을 때 +20점
//                        } else {   // result == 2
//                            System.out.println("💢💢게임에서 졌습니다😱😱");
//                            System.out.println(Templates.getInstance().Line());
//                            comWins++;
//                            userRating -= 10; //졌을 때 -10점
//                        }
//                        break;
//                    } else { //같지 않을 때 승패 비교
//                        result = getResult(userChoice, computerChoice);
//                    }
//                }
//                if (userWins == 3 || comWins == 3){
//                    System.out.println("  🍀   🌹   🍀   🌼   🍀   🌷   🍀   🌻");
//                    System.out.println(userWins == 3 ? "축하합니다 (∩^o^)⊃━☆ 먼저 3승 달성 하셨습니다~!" : "컴퓨터가 3승 달성했습니다. 분발하세요! ┗( T﹏T )┛");
//                    System.out.println("  🍀   🌹   🍀   🌼   🍀   🌷   🍀   🌻");
//                    break;
//                }
//            }
//            while (true) {
//                System.out.print("1. 다시하기\n2. 랭킹\n3. 종료\n\n");
//                System.out.print("MENU 선택: ");
//                restart = sc.next();
//
//
//                try {
//                    int m = Integer.parseInt(restart);
//                    if (m >= 1 && m <= 3) {
//                        change(m);
//                        break;
//                    }else{
//                        throw new Exception();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    System.err.println("메뉴 1,2,3 중에서 선택하세요.");
//                }
//            }
//        }
//    }
//
//
//    //유저 선택
//    public static String getUserChoice(Scanner sc) {
//        while (true) {
//            System.out.print("♡묵, 찌, 빠 중 골라주세요♥ : ");
//            choice = sc.next();
//            if (choice.equals("묵") || choice.equals("찌") || choice.equals("빠")) {
//                break;
//            } else {
//                System.out.println("잘못된 입력입니다. '묵', '찌', '빠' 중에서 다시 골라주세요.");
//            }
//        }
//        return choice;
//    }
//
//    //컴퓨터 선택
//    public static String getComputerChoice() {
//        computer = (int) (Math.random() * 3) + 1;
//        switch (computer) {
//            case 1:
//                return "묵";
//            case 2:
//                return "찌";
//            case 3:
//                return "빠";
//            default:
//                return "";
//        }
//    }
//
//    public static int getResult(String user, String computer) {
//        if (user.equals("묵")) {
//            if (computer.equals("묵")) return 3;
//            else if (computer.equals("찌")) return 1;
//            else return 2;
//        } else if (user.equals("찌")) {
//            if (computer.equals("묵")) return 2;
//            else if (computer.equals("찌")) return 3;
//            else return 1;
//        } else {
//            if (computer.equals("묵")) return 1;
//            else if (computer.equals("찌")) return 2;
//            else return 3;
//        }
//    }
//
//}
//
