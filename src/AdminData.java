import java.util.Set;

public class AdminData {

    public String username;

    public String password;

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

    //variable for username and password

    //getter and setter for username and password
