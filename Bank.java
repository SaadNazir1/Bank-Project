import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bank {
    static private final int uniqueIDAccounts = 0;

    static private final int uniqueIDClient = 0;
    private final List<Client> clients;
    private Client currentClient = null;

    public Bank() {
        this.clients=new ArrayList<>();
    }


    public void addNewClient(Client client, int pin) {
        for (Client myclient : clients) {
            if (myclient.getIDnumber() == client.getIDnumber()) {
                System.out.println("Client is already in the list.");
                return;
            }
        }
        client.setPin(pin);
        clients.add(client);
//        System.out.println("Client has been created");
    }

    public void logOut() {
        currentClient = null;
        System.out.println("User logged out.");
    }

    public void logIn(int id, int pin) {
        for (Client client : clients) {
            if (client.getBankID() == id && client.getPin() == pin) {
                currentClient = client;
                System.out.println("Login successful.");
                return ;
            }
        }
        System.out.print("This user is not know to the bank, please check if you gave the correct ID and PIN!");
    }

        public void addAccount(Client client, double amount) {
        if(amount < 0){
            System.out.print("An account was added with a negative starting amount, this should not be possible!");
            return;
        }
        BankAccount newBankAccount=new BankAccount(uniqueIDAccounts,amount);
        client.addAccount(newBankAccount);
    }

    public void removeAccount(BankAccount toRemove, BankAccount transferAccount) {
        if (currentClient.getAccounts().contains(toRemove) ){
            currentClient.getAccounts().remove(toRemove);
            double amountTransferring=toRemove.getBalance();
            if  (transferAccount != null){
                transferAccount.addToBalance(amountTransferring);
            }
        }else{
            System.out.println(" ");
        }
    }


    public void transfer(BankAccount transferFrom, BankAccount transferTo, double amount) {
        boolean containTransferFrom = false;
        boolean containTransferTo = false;
        for (Client client: clients) {
            if (client.getAccounts().contains(transferFrom)){
                containTransferFrom = true;
            }
            if (client.getAccounts().contains(transferTo)){
                containTransferTo = true;
            }
        }
        if (containTransferFrom && containTransferTo && transferFrom.getBalance() >= amount) {
            transferTo.addToBalance(amount);
            transferFrom.removeFromBalance(amount);
        }else System.out.println(" ");
    }

    public void displayAccounts() {
        if(currentClient == null){
            return;
        }
        Iterator<Client> iterator=clients.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public int maxIDClient(){
        return uniqueIDClient;
    }

    public Client getCurrentClient(){
        return currentClient;
    }

    public List<Client> getClients() {
        return clients;
    }

}
