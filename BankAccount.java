public class BankAccount {

    private final int uniqueID;
    private double balance;

    public BankAccount(int uniqueID, double amount){
        this.uniqueID=uniqueID;
        this.balance=amount;
    }

    public void addToBalance(double amount){
        balance=balance+amount;
    }

    public boolean canBeRemovedFromBalance(double amount){
        if (balance>=amount){
            return true;
        }
        return false;
    }

    public void removeFromBalance(double amount){
        if (canBeRemovedFromBalance(amount)){
            balance=balance-amount;
        }
        else{
            System.out.println("It can not be removed");
        }
    }

    public double getBalance() {
       return balance;
    }

    public int getID() {
        return uniqueID;
    }
}
