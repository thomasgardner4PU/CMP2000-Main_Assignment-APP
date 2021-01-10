public class AdminData {

    //variable for username and password

    String username;
    String password;

    public AdminData() {
    }

    public AdminData(String loginName, String loginPassword) {
        this.username = loginName;
        this.password = loginPassword;
    }

    public String GetUsername() {
        return username;
    }

    public String GetPassword() {
        return password;
    }

    public void setPassword(String adminPassword) {
        password = adminPassword;
    }

    public void setUsername(String adminUsername) {
        username = adminUsername;
    }
}
