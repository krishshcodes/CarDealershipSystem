package CarManagement.models;

public class Client extends User {
    public Client() { super(); }

    public Client(int id, String firstName, String lastName, String email, String phoneNo, String password) {
        super(id, firstName, lastName, email, phoneNo, password);
    }

    @Override
    public void showMenu() {
        System.out.println("\n===== Buyer Menu =====");
        System.out.println("1. View Cars");
        System.out.println("2. Search Car (brand/model)");
        System.out.println("3. Logout");
    }
}
