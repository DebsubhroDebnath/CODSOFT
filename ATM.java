package JavaProgramming.Codsoft;
import java.util.Scanner;

class BankAccount{

    String BankAccountNo;
    int Balance;

    BankAccount(String accountNo){
        this.BankAccountNo = accountNo;
    }

    public void checkBalance(){
        System.out.println("Remaining Balance of your account :"+" "+Balance);
        System.out.println();
        System.out.println("===================================");
    }
    
}

class ATM extends BankAccount {

    ATM(String accountNo) {
        super(accountNo);
    }

    public void deposit(int amount){
        this.Balance = amount;
    }

    public void withdraw(int amount){
        if(Balance==0 || amount>Balance){
            System.out.println("Withdraw unsuccessful! Insufficient Balance");
        }
        else{
            Balance = (Balance - amount);
            System.out.println("Balance Withdrawn Successfully!");
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc  = new Scanner(System.in);
        String userAccountNo = "";

        ATM user = new ATM(userAccountNo);


        System.out.printf("<--------------------ATM INTERFACE-------------------->\n");
        System.out.println();
        int choice;
        do{
            System.out.println("CHOSE OPTION AS PER YOUR REQUIREMENT----------------->");

            System.out.println("1.FOR CHECKING BALANCE");
            System.out.println("2.FOR WITHDRAWING MONEY");
            System.out.println("3.FOR DEPOSITING MONEY");
            System.out.println("4.EXIT");
            System.out.println();

            System.out.print("Enter your Option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Account Number:");
                    userAccountNo = sc.next();
                    user.checkBalance();
                    break;
                case 2:
                    System.out.println("Enter the amount to Withdraw:");
                    int amount = sc.nextInt();
                    user.withdraw(amount);
                    break;
                case 3:
                    System.out.println("Enter the amount for Deposit:");
                    int money = sc.nextInt();
                    user.deposit(money);
                    System.out.println("Depositted Successfully!");
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Please Enter a valid Option!");
            }

        }while(choice!=4);

        sc.close();
    }
}