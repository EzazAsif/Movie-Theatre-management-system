public class Customer extends User{

    private int customerId;

    private String name;

    private String email;
    public static String Role  ="Customer";

    public String getName() {
        return name;
    }

    public Customer(int customerId, String name, String email) {

        this.customerId = customerId;

        this.name = name;

        this.email = email;

    }




    public void updateContactInfo() {
        System.out.println("Contact information updated for customer: " + name);

    }

}