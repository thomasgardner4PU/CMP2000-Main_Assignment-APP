import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminUser {

    public void setPassword(String[] userData) {
    }

    public String filePath = ("resources\\admin.txt");
    public String separator = "\\|";

    private final ArrayList<AdminUser> user = new ArrayList<>();
    public void load(){
        try {
            File file = new File(filePath);

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String data = scanner.nextLine();

                String [] userData = data.split(separator);

                AdminLogin user = new AdminLogin();

                user.setPassword(userData);

                user.add(user);
            }
            scanner.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
