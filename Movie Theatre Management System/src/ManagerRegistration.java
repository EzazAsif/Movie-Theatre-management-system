import java.util.Scanner;
public class ManagerRegistration{
    Scanner input=new Scanner(System.in);
    public ManagerRegistration(Manager manager){
        int managerId;
        String name;
        String successLevel;
        String email;
        System.out.println("Enter User id:");
        managerId=input.nextInt();
        System.out.println("Enter Success Level");
        successLevel=input.nextLine();
        System.out.println("Enter name");
        name=input.nextLine();
        System.out.println("Enter email");
        email=input.nextLine();
        manager.updateContactInfo(managerId,successLevel,name,email);
    }
}


