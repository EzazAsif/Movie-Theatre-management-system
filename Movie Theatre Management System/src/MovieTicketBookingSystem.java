import java.awt.Desktop;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MovieTicketBookingSystem {
    public static User user;

    public static void main(String[] args) {
        FileHandler f1=new FileHandler();
        Scanner scanner = new Scanner(System.in);
        // Create a list of movies
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Jawan", 190, "Action"));
        // Create a list of available seats
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= 5; row++) {
            for (int seatNumber = 1; seatNumber <=  10; seatNumber++) {
                seats.add(new Seat(seatNumber, row, false));
            }
        }
        // Create a lfist of booked tickets
        List<Ticket> bookedTickets = new ArrayList<>();
       if (logReg().compareTo("Customer")==0) {
            while (true) {
                System.out.println("Movie Ticket Booking System");
                System.out.println("1. Show Movie List");
                System.out.println("2. Book a Ticket");
                System.out.println("3. View Booked Tickets");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Available Movies:");
                        for (Movie movie : movies) {
                            movie.displayDetails();
                        }
                        System.out.println("play trailer (insert y to play)");
                        char c=scanner.next().charAt(0);
                        if(c=='y'){
                            try {
                                // Specify the path to your MP4 file
                                String mp4FilePath = "C:\\Users\\USER\\IdeaProjects\\Grp Project\\Jawan.mp4";

                                // Create a File object with the file path
                                File mp4File = new File(mp4FilePath);

                                // Check if the file exists
                                if (mp4File.exists()) {
                                    // Use the Desktop class to open the file with the default media player
                                    Desktop.getDesktop().open(mp4File);
                                } else {
                                    System.err.println("File not found: " + mp4FilePath);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter movie title: ");
                        String movieTitle = scanner.nextLine();
                        movieTitle = scanner.nextLine();

                        System.out.println("Enter your name: ");
                        String passengerName = scanner.nextLine();

                        System.out.println("Enter the row and seat number: ");
                        int row = scanner.nextInt();
                        int seatNumber = scanner.nextInt();

                        Seat selectedSeat = null;
                        for (Seat seat : seats) {
                            if (seat.getRow() == row && seat.getSeatNumber() == seatNumber) {
                                selectedSeat = seat;
                                break;
                            }
                        }

                        if (selectedSeat != null && !selectedSeat.isIs_reserved()) {
                            selectedSeat.setIs_reserved(true);
                            Ticket bookedTicket = new Ticket(movieTitle, passengerName);
                            bookedTickets.add(bookedTicket);
                            System.out.println("Ticket booked: " + bookedTicket);
                        } else {
                            System.out.println("Seat is already reserved or invalid.");
                        }
                        break;
                    case 3:
                        System.out.println("Booked Tickets:");
                        for (Ticket ticket : bookedTickets) {
                            System.out.println(ticket);
                        }

                        break;
                    case 4:
                        System.out.println("Thank you for using the Movie Ticket Booking System.");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        else {
            while(true){
                System.out.println("Movie Ticket Booking System");
                System.out.println("1. Movie Add");
                System.out.println("2. Seat Add");
                System.out.println("3. Back");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter movie name");
                        String MovieName=scanner.nextLine();
                        System.out.println("Enter Duration");
                        int Duration=scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter Genre");
                        String Genre=scanner.nextLine();
                        movies.add(new Movie(MovieName, Duration, Genre));
                        f1.writeFile(MovieName,Duration+"\n"+Genre);
                        System.out.println("Movie Added");
                        break;
                    case 2:
                        System.out.println("Enter Rows");
                        int rownum=scanner.nextInt();
                        System.out.println("Seat Numbers");
                        int seatnum=scanner.nextInt();

                        for (int row = 1; row <= rownum; row++) {
                            for (int seatNumber = 1; seatNumber <=  seatnum; seatNumber++) {
                                seats.add(new Seat(seatNumber, row, false));
                            }
                        }
                        System.out.println("Seats Added");
                        break;
                    case 3:
                        main(args);
                        break;
                }

            }
        }


        }




    public static void reg(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id");
        int id=scanner.nextInt();
        System.out.println("Enter name");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.println("Set Password");
        String password=scanner.nextLine();
        System.out.println("Enter email");
        String email=scanner.nextLine();
        System.out.println("1.Customer\n2.Manager");
        int op=scanner.nextInt();
        if(op==1){
            User user=new Customer(id,name,email);
            try{
                BufferedWriter f1=new BufferedWriter(new FileWriter(id+".txt"));
                f1.write(password+"\n"+name+"\n"+email+"\n"+"Customer");

                f1.close();
            }
            catch(IOException e1){

            }
        }
        else if(op==2){
            User user=new Manager(id,name,email);
            try{
                BufferedWriter f1=new BufferedWriter(new FileWriter(id+".txt"));
                f1.write(password+"\n"+name+"\n"+email+"\n"+"Manager");

                f1.close();
            }
            catch(IOException e1){

            }
        }

    }
    public static String logIN()
    {
        String compPass,name,email,role;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Role(Manager/Customer)");
        String compRole=scanner.nextLine();
        System.out.println("Enter Id");
        int id=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Password");
        String pass=scanner.nextLine();
        String StringId=id+"";
        try{
        BufferedReader f1=new BufferedReader(new FileReader(StringId+".txt"));
        compPass=f1.readLine();
        name=f1.readLine();
        email=f1.readLine();
        role=f1.readLine();
        f1.close();
        if(compPass.compareTo(pass)!=0||(role.compareTo(compRole)!=0)){
            System.out.println("Wrong Password");
            logIN();
        }
        else {
            if(role.compareTo("Manager")==0){
                user=new Manager(id,name,email);

            }
            else if(role.compareTo("Customer")==0){
                user=new Customer(id,name,email);

            }
        }

        f1.close();
    }
            catch(IOException e1){

    }
       return compRole;
    }
    public static String logReg(){
        String t=null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Login \n2.Register");
        int rl=scanner.nextInt();
        if(rl==1){
            t =logIN();
        }
        else if(rl==2){
            reg();
            t="fjijrfigrs";
        }
         return t;
    }

}
