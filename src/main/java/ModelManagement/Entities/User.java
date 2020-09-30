package ModelManagement.Entities;

public class User {
    private int user_id;
    private String name;
    private String accountName;
    private String password;
    private String email;

    public User() {}

    public User(String name, String accountName, String password, String email) {
//        super();
        this.name = name;
        this.accountName = accountName;
        this.password = password;
        this.email = email;
    }

    public User(int user_id, String name, String accountName, String password, String email) {
//        super();
        this.user_id = user_id;
        this.name = name;
        this.accountName = accountName;
        this.password = password;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
