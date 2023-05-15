import java.io.IOException;

public class Program {
    public static void main(String[] args) throws CloneNotSupportedException, PlanException, IOException, PlanExceptionUserName {

        MobileCompany mobileCompany = new MobileCompany("Adib Tech", "admin", "admin", 10);
        UserInterface UI = new UserInterface(mobileCompany);
        UI.mainMenu();


    }

}