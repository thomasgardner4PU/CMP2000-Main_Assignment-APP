public class AdminData {

    //variable for username and password

    String username;
    String password;


    public AdminData(String loginName, String loginPassword) {
        this.username = loginName;
        this.password = loginPassword;
    }

    public AdminData() {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String adminPassword) {
        password = adminPassword;
    }

    public void setUsername(String adminUsername) {
        username = adminUsername;
    }
}
