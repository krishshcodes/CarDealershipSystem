package CarManagement.models;

public class Admin extends User {
    public Admin() { super(); }

    public Admin(int id, String firstName, String lastName, String email, String phoneNo, String password) {
        super(id, firstName, lastName, email, phoneNo, password);
    }

    @Override
    public void showMenu() {
        System.out.println("\n===== Admin Menu =====");
        System.out.println("1. Add New Car");
        System.out.println("2. View All Cars");
        System.out.println("3. Update Car");
        System.out.println("4. Delete Car");
        System.out.println("5. Logout");
    }
}
