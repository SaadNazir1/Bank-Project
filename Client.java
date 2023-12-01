import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Client {
    private int age;
    private String name;
    private int IDnumber;
    private String adress;
    private List<BankAccount> accounts;

    private int bankID;

    private int pin;

    public Client(String name, int age, int IDnumber, String adress) {
        this.name = name;
        this.age = age;
        this.IDnumber = IDnumber;
        this.adress = adress;
        this.accounts=new ArrayList<>();
    }
    public int getIDnumber() {
        return IDnumber;
    }

    public void addAccount(BankAccount bankAccount) {
        accounts.add(bankAccount);
    }

    public void removeAccount(BankAccount selectedAccount) {
        Iterator<BankAccount> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            BankAccount index = iterator.next();
            if (index == selectedAccount) {
                iterator.remove();
            }
        }

    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public List<BankAccount> getAccounts(){
        return accounts;
    }

    public void addBankID(int bankID) {
        this.bankID=bankID;
    }

    public int getBankID(){
        return bankID;
    }

    public void setPin(int pin){
        this.pin=pin;
    }

    public int getPin(){
        return pin;
    }
}
