package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankService {

    public static void main(String[] args) {

        /*// 객체 생성
        BankAccount bankAccount = new BankAccount("1234-5678");
        bankAccount.deposit(50000); // 50000원 예금
        bankAccount.withdraw(15000); // 15000원 출금
        bankAccount.withdraw(100000); // 10만원 출금 시도

        BankAccount bankAccount2 = new BankAccount("5555");
        bankAccount2.deposit(30000); // 3만원 예금
        System.out.println("=============transfer=============");
        bankAccount2.transfer(bankAccount, 10000); // b2가 b1한테 만원 이체 -> 성공
        bankAccount2.transfer(bankAccount, 30000); // b2가 b1한테 3만원 이체 -> 실패*/

        // 실습
        List<BankAccount> bankAccounts = new ArrayList<>(); // 생성한 계좌 리스트에 담기

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("무슨 서비스 이용할거야? 1. 계좌개설 2. 입금 3. 출금 4. 이체");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    // 계좌개설
                    System.out.println("계좌번호 입력해 : ");
                    String accountNumInput = sc.next();
                    // 계좌생성
                    BankAccount bankAccount = new BankAccount(accountNumInput);
                    // list에 넣기
                    bankAccounts.add(bankAccount);
                    System.out.println("계좌 개설 완료");
                    break;

                case 2:
                    // 입금
                    System.out.println("너 계좌번호 눌러봐 : ");
                    accountNumInput = sc.next();
                    // 계좌번호에 맞는 계좌 찾아오기
                    BankAccount myAccount = findAccountByNum(bankAccounts, accountNumInput);

                    // 가져온 계좌에 입금 ㄱㄱ
                    System.out.println("얼마 입금할거냐 : ");
                    int inputMoney = sc.nextInt();
                    myAccount.deposit(inputMoney);
                    break;

                case 3:
                    // 출금
                    System.out.println("너 계좌번호 눌러봐 : ");
                    accountNumInput = sc.next();
                    // 계좌번호에 맞는 계좌 찾아오기
                    myAccount = findAccountByNum(bankAccounts, accountNumInput);

                    // 가져온 계좌에서 출금 ㄱㄱ
                    System.out.println("얼마 출금할거냐 : ");
                    inputMoney = sc.nextInt();
                    myAccount.withdraw(inputMoney);
                    break;

                case 4:
                    // 이체
                    System.out.println("너 계좌번호 눌러봐 : ");
                    accountNumInput = sc.next();
                    // 계좌번호에 맞는 계좌 찾아오기
                    myAccount = findAccountByNum(bankAccounts, accountNumInput);

                    // 보낼 사람 계좌
                    System.out.println("누구한테 보낼거야? 계좌번호 눌러봐 : ");
                    String friendsAccountInput = sc.next(); // 친구 계좌번호 입력
                    // 친구 계좌 찾아오기
                    BankAccount friendsAccount = findAccountByNum(bankAccounts, friendsAccountInput);

                    System.out.println("얼마 보낼거야 ? ");
                    inputMoney = sc.nextInt();
                    myAccount.transfer(friendsAccount, inputMoney);
                    break;
            }
        }

    }

    // 계좌 찾아오기
    private static BankAccount findAccountByNum(List<BankAccount> bankAccounts, String accountNumber) {
        for (BankAccount account : bankAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // 계좌를 찾지 못하면 null 반환
    }
}


class BankAccount {

    private final String accountNumber; // 계좌번호
    private int balance; // 잔액

    // 생성자
    BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    // method
    // 예금하기
    public void deposit(int money) {
        this.balance += money;
        System.out.println(money + "원이 입금되었습니다. 잔액은 " + this.balance + "원 입니다. ");
    }

    // 출금하기
    public void withdraw(int money) {
        if (this.balance >= money) {
            this.balance -= money;
            System.out.println(money + "원이 출금되었습니다. 잔액은 " + this.balance + "원 입니다. ");
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }

    // 돈 이체하기
    public void transfer(BankAccount bankAccount, int money) {

        if (this.balance >= money) { // 보내려는 돈 보다 잔액이 더 많으면 -> 보낼 수 있음
            //b2의 잔액은 빠지고, b1의 잔액은 늘어남
            this.balance -= money;
            bankAccount.balance += money;
            System.out.println("이체 성공. 보낸 사람의 잔액 : " + this.balance);
        } else {
            System.out.println("돈 부족해. 이체 실패 [너가 보내려는 돈 : " + money + ", 남은 돈 : " + this.balance + "]");
        }
    }
}
