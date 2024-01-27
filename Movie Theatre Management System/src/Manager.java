public class Manager extends User{
    private int managerId;
    private String successLevel,name,email;
    public static String Role="Manager";
    public Manager(int managerId, String name, String email) {
        this.managerId = managerId;
        this.name = name;
        this.email = email;
    }

    public void updateContactInfo(int managerId, String successLevel, String name, String email) {
        this.managerId = managerId;
        this.successLevel = successLevel;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
}
