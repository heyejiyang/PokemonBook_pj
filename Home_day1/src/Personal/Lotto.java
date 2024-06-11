package Personal;

public class Lotto {
    public static void main(String[] args) {
            int lotto[] = new int[6];

            for(int i = 0 ; i < lotto.length ; i++){
                int lottoNum = (int)(Math.random() * 45)+1;
                boolean check = false;

                for(int k = 0 ; k < i ; k++){
                    if(lotto[k] == lottoNum){
                        check = true;
                        break;
                    }
                } // 두번째 포문 닫힘

                if(check){
                    i--;
                }

                else{
                    lotto[i] = lottoNum;
                    System.out.print(lotto[i]+" ");
                }
            } // 첫 포문 닫힘

        }
    }

