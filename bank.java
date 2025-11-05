import java.util.Scanner;
class Account {
    protected String customerName;
    protected String accountNumber;
    protected String accountType;
    protected double balance;

    public Account(String customerName, String accountNumber, String accountType, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    public void acceptDeposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void showBalance() {
        System.out.println("Account Balance: " + balance);
    }

    public void allowWithdrawal(double amount) {
        System.out.println("Withdrawal not implemented for base account.");
    }
}

class SavAcct extends Account {
    private double interestRate;

    public SavAcct(String customerName, String accountNumber, double initialBalance, double interestRate) {
        super(customerName, accountNumber, "Savings", initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest of " + interest + " has been added to your savings account.");
    }


    public void allowWithdrawal(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
}

class CurAcct extends Account {
    private double minimumBalance;
    private double serviceCharge;

    public CurAcct(String customerName, String accountNumber, double initialBalance, double minimumBalance, double serviceCharge) {
        super(customerName, accountNumber, "Current", initialBalance);
        this.minimumBalance = minimumBalance;
        this.serviceCharge = serviceCharge;
    }

   
    public void allowWithdrawal(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (balance - amount >= minimumBalance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            balance -= serviceCharge;
            System.out.println("Balance fell below minimum. Service charge of " + serviceCharge + " applied.");
        }
    }

    public void showBalance() {
        super.showBalance();
        if (balance < minimumBalance) {
            System.out.println("Warning: Your balance is below the minimum required. Service charges may apply.");
        }
    }

    public void showChequeBookFacility() {
        System.out.println("Cheque book facility is available for current account holders.");
    }
}


public class bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Savings Account input
        System.out.println("Enter details for Savings Account:");
        System.out.print("Customer Name: ");
        String savName = sc.nextLine();
        System.out.print("Account Number: ");
        String savAccNo = sc.nextLine();
        System.out.print("Initial Balance: ");
        double savBalance = sc.nextDouble();
        System.out.print("Interest Rate (%): ");
        double interestRate = sc.nextDouble();
        sc.nextLine();  

        SavAcct savingsAccount = new SavAcct(savName, savAccNo, savBalance, interestRate);
        System.out.println("Savings Account created for " + savName + ".");
        savingsAccount.showBalance();

        System.out.print("Enter amount to deposit in savings account: ");
        double savDeposit = sc.nextDouble();
        savingsAccount.acceptDeposit(savDeposit);

        savingsAccount.applyInterest();
        savingsAccount.showBalance();

        System.out.print("Enter amount to withdraw from savings account: ");
        double savWithdraw = sc.nextDouble();
        savingsAccount.allowWithdrawal(savWithdraw);
        savingsAccount.showBalance();

        sc.nextLine(); 
        System.out.println("\nEnter details for Current Account:");
        System.out.print("Customer Name: ");
        String curName = sc.nextLine();
        System.out.print("Account Number: ");
        String curAccNo = sc.nextLine();
        System.out.print("Initial Balance: ");
        double curBalance = sc.nextDouble();
        System.out.print("Overdraft Limit: ");
        double overdraftLimit = sc.nextDouble();
        System.out.print("Penalty Fee: ");
        double penaltyFee = sc.nextDouble();
        sc.nextLine(); 

        CurAcct currentAccount = new CurAcct(curName, curAccNo, curBalance, overdraftLimit, penaltyFee);
        System.out.println("Current Account created for " + curName + ".");
        currentAccount.showBalance();

        System.out.print("Enter amount to deposit in current account: ");
        double curDeposit = sc.nextDouble();
        currentAccount.acceptDeposit(curDeposit);

        System.out.print("Enter amount to withdraw from current account: ");
        double curWithdraw = sc.nextDouble();
        currentAccount.allowWithdrawal(curWithdraw);
        currentAccount.showBalance();

        System.out.print("Enter amount to withdraw from current account: ");
        double curWithdraw2 = sc.nextDouble();
        currentAccount.allowWithdrawal(curWithdraw2);
        currentAccount.showBalance();

        sc.close();
    }
}

