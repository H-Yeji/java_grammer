package C04Interface.BankService;

// Entity (작업의 대상이 되는 객체)
public class BankAccount{

    static long static_id =0L;

    private long id;

    private String accountNumber;

    private int balance;

    BankAccount(String accountNumber){
        static_id +=1 ;
        id = static_id;
        this.accountNumber = accountNumber;
    }

    BankAccount(int balance) {
        this.balance = balance;
    }

    // getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public Long getId() {
        return id;
    }

    // setter
    public void updateBalance(int balance) {
        this.balance = balance;
    }

}
