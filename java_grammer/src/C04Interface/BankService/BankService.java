package C04Interface.BankService;

public interface BankService {

    void deposit(int money, BankAccount bankAccount);
    void withdraw(int money, BankAccount bankAccount);
}
