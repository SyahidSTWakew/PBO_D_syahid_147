public class Admin extends User {
    private String username;
    private String password;

    public Admin(String lastThreeDigitsNIM) {
        super("Admin", lastThreeDigitsNIM);
        this.username = "syahid" + lastThreeDigitsNIM;
        this.password = "syahid" + lastThreeDigitsNIM;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}