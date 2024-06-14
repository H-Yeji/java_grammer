package C04Interface.BankService;

import java.util.Scanner;

public class BankController {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("계좌번호를 입력하세요.");
        String acocuntNumber = sc.nextLine();
        BankAccount bankAccount = new BankAccount(acocuntNumber);

        while (true){
            System.out.println("서비스 번호를 입력하세요 : 1. 카드, 2. 카카오페이");
            int number = Integer.parseInt(sc.nextLine());
            if (!(number == 1 || number == 2)){
                System.out.println("올바른 번호가 아닙니다.");
                continue;
            }
            System.out.println("입금하시려면 1번, 출금하시려면 2번 ");
            int number2 = Integer.parseInt(sc.nextLine());

            if(number == 1){ // 카드
                BankCardService bcs = new BankCardService();

                if (number2 == 1){
                    System.out.println("입금하실 금액을 입력하세요.");
                    int money = Integer.parseInt(sc.nextLine());
                    bcs.deposit(money, bankAccount);

                } else if (number2 == 2){
                    System.out.println("출금하실 금액을 입력하세요.");
                    int money = Integer.parseInt(sc.nextLine());
                    bcs.withdraw(money, bankAccount);
                }

            } else { // 카카오페이
                BankKakaoService kakao = new BankKakaoService();
                if (number2 == 1){
                    System.out.println("입금하실 금액을 입력하세요.");
                    int money = Integer.parseInt(sc.nextLine());
                    kakao.deposit(money, bankAccount);

                } else if (number2 == 2){
                    System.out.println("출금하실 금액을 입력하세요.");
                    int money = Integer.parseInt(sc.nextLine());
                    kakao.withdraw(money, bankAccount);
                }
            }
        }
    }

}
