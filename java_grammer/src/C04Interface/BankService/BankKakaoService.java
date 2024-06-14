package C04Interface.BankService;

public class BankKakaoService implements BankService {

    @Override
    public void deposit(int money, BankAccount bankAccount) {
        int myMoney = bankAccount.getBalance();
        int total = myMoney + money;
        bankAccount.updateBalance(total);
        System.out.println(money+"원이 카카오페이로 입금되었습니다.");
        System.out.println("현재 잔액은 " + total);
    }

    @Override
    public void withdraw(int money, BankAccount bankAccount) {
        int myMoney = bankAccount.getBalance(); //잔액 받기
        int total = myMoney - money; // 빼고 남은 잔액 확인

        if(total < money){
            System.out.println("잔액 부족입니다.");
            System.out.println("현재 잔액은 " + myMoney); // 기존값 그대로
        }else {
            bankAccount.updateBalance(total); // 남은 돈 갱신
            System.out.println(money + "원이 카카오페이에서 출금되었습니다.");
            System.out.println("현재 잔액은 " + total); // 빠진 값
        }
    }
}
