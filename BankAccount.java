import java.util.Scanner;
import java.text.*;

public class BankAccount {
    private double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public double checkBalance(){
        return balance;
    }

    public void deposit(double amount){

        if (amount > 0){
            balance = balance + amount;
            System.out.println("Successfully deposited");
        } else {
            System.out.println("Invalid deposit");
        }
    }

    public void withdraw(double amount){

        if (amount > 0 && amount <= balance){
            balance = balance - amount;
            System.out.println("Successfully withdraw");
        } else if (amount >  balance){
            System.out.println("Insufficient amount");
        } else {
            System.out.println("Invalid withdraw");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        BankAccount acc = new BankAccount(0);

        while (true){
            System.out.println("\n------ Bank Menu ------");
            System.out.println("1. Check Balance" + "\n2. Deposit Money" + "\n3. Withdraw Money" + "\n4. Exit");
            System.out.print("\nEnter your option: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Current Balance: RM " + df.format(acc.checkBalance()) + "\n");
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: RM ");
                    double depositAmount = sc.nextDouble();
                    acc.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: RM ");
                    double withdrawMoney = sc.nextDouble();
                    acc.withdraw(withdrawMoney);
                    break;
                case 4:
                    System.out.println("Exit the program, Thank you.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
