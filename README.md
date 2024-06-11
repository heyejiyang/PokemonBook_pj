Hi
```
    public static void main(String[] args) {
        int lotto[] = new int[6];

        for(int i = 0 ; i < lotto.length ; i++){
            int lottoNum = (int)(Math.random() * 45)+1;
            boolean check = false;
//            lotto[i] = lottoNum;

            for(int k = 0 ; k < i ; k++){
                if(lotto[k] == lottoNum){
                    check = true;
                    break;
                }
            }
            if(check == true){
                i--;
            }
            else{
                lotto[i] = lottoNum;
                System.out.print(lotto[i]+" ");
            }
        }
    }
```
