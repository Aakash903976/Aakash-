import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class ATM{
    float Balance;
    int PIN = 2004;
    List<String> history = new ArrayList<>();


    public void checkpin() {
        System.out.println("Enter your pin: ");
        Scanner sc = new Scanner(System.in);
        int enterpin = sc.nextInt();
        System.out.println("WELCOME TO ATM MACHINE");
        if(enterpin == PIN){
            menu();
        }
        else{
            System.out.println("Enter a valid pin");
            menu();
        }
    }

    public void menu(){
        System.out.println("Enter your Choice: ");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4 View Transaction History");
        System.out.println("5. EXIT");
        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        if(opt == 1){
            checkBalance();
        }else if(opt==2){
            WithdrawMoney();
        }else if(opt==3){
            depositMoney();

        }else if(opt==4){
            viewhistory();

        } else if(opt==5){
            return;
        }
        else{
            System.out.println("Enter a valid choice");
            menu();
        }
    }
    public void checkBalance(){
        System.out.println("Balance: " + Balance);
        menu();
    }
    public void WithdrawMoney(){
        System.out.println("Enter Amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if(amount>Balance){
            System.out.println("Insufficient Balance");
        }else{
            Balance = Balance - amount;
            String time = now();
            System.out.println("Money withdrawl Successful");
            history.add("Withdrawn: ₹" + amount + " on " + time);
        }
        menu();
    }
    public void depositMoney(){
        System.out.println("Enter the Amount: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        String time = now();
        System.out.println("Money Deposited Sucessfully");
        history.add("Deposited: ₹" + amount + " on " + time);
        menu();
    }
    public void viewhistory(){
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String entry : history) {
                System.out.println("- " + entry);
            }
        }
        menu();
    }
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

}
public class ATMMachine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkpin();

    }
}
