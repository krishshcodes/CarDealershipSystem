package CarManagement.models;

public abstract class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String password;

    public User() {}

    public User(int id, String firstName, String lastName, String email, String phoneNo, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String fn) { this.firstName = fn; }

    public String getLastName() { return lastName; }
    public void setLastName(String ln) { this.lastName = ln; }

    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }

    public String getPhoneNo() { return phoneNo; }
    public void setPhoneNo(String p) { this.phoneNo = p; }

    public String getPassword() { return password; }
    public void setPassword(String pw) { this.password = pw; }

    public abstract void showMenu();
}
