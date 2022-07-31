package atmpackage;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int accountNumber;
    private int pinNumber;


    private double checkingBalance;
    private double savingBalance;


    Scanner scan = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");


    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    //calculate checking balance after withdraw
    private double calculateCheckingAccountBalanceAfterWithdraw (double amount){
        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }

    //calculate checking account after deposit
    private double calculateCheckingAccountBalanceAfterDeposit (double amount){
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }
    //calculate checking balance after withdraw
    private double calculateSavingAccountBalanceAfterWithdraw (double amount){
        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }

    //calculate checking account after deposit
    private double calculateSavingAccountBalanceAfterDeposit (double amount){
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    //Interact with user to withdraw money from checking account
    public void getCheckingWithdraw(){
        System.out.println("Your checking balance: "+moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you would like to withdraw: ");
        double amount = scan.nextDouble();
        if(amount<=0){
            System.out.println("Negative or zero amount is not acceptable!");
            getCheckingWithdraw();
        } else if(checkingBalance>= amount){
            calculateCheckingAccountBalanceAfterWithdraw(amount);
            System.out.println("Your checking balance: "+moneyFormat.format(checkingBalance));
        } else{
            System.out.println("You do not have enough money on your checking account");
        }
    }

    //Interact with user to deposit money to their checking account
    public void getCheckingDeposit(){
        System.out.println("Your checking balance: "+moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you would like to deposit: ");
        double amount = scan.nextDouble();
        if(amount<=0){
            System.out.println("Negative or zero amount is not acceptable!");
            getCheckingDeposit();
        } else{
            calculateCheckingAccountBalanceAfterDeposit(amount);
            System.out.println("Your checking balance: "+moneyFormat.format(checkingBalance));
        }
    }

    //Interact with user to withdraw money from saving account
    public void getSavingWithdraw(){
        System.out.println("Your saving balance: "+moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you would like to withdraw: ");
        double amount = scan.nextDouble();
        if(amount<=0){
            System.out.println("Negative or zero amount is not acceptable!");
            getSavingWithdraw();
        } else if(savingBalance>= amount){
            calculateSavingAccountBalanceAfterWithdraw(amount);
            System.out.println("Your saving balance: "+moneyFormat.format(savingBalance));
        } else{
            System.out.println("You do not have enough money on your saving account");
        }
    }

    //Interact with user to deposit money to their saving account
    public void getSavingDeposit(){
        System.out.println("Your saving balance: "+moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you would like to deposit: ");
        double amount = scan.nextDouble();
        if(amount<=0){
            System.out.println("Negative or zero amount is not acceptable!");
            getSavingDeposit();
        } else{
            calculateSavingAccountBalanceAfterDeposit(amount);
            System.out.println("Your saving balance: "+moneyFormat.format(savingBalance));
        }
    }
}
