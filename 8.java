class BankAccount {
    private double balance = 1000.0;

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " - Insufficient Funds!");
        }
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.deposit(500), "User1");
        Thread t2 = new Thread(() -> account.withdraw(1200), "User2");

        t1.start();
        t2.start();
    }
}