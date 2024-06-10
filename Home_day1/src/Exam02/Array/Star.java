package Exam02.Array;

public class Star {
    // 이거 못하겠음
    public static void main(String[] args) {
        int star = 4;

        for (int i = 0; i < star; i++) {
            for (int j = 0; j < star - i - 1; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }

            // 줄 바꿈
            System.out.println();

        }
    }
}
