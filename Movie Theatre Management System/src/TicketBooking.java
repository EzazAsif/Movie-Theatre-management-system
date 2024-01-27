import java.util.ArrayList;
import java.util.List;

public class TicketBooking {
    private List<Ticket> tickets;

    public TicketBooking() {
        tickets = new ArrayList<>();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void bookTicket(Ticket ticket) {
        // Add the ticket to the list of booked tickets
        tickets.add(ticket);
        System.out.println("Ticket booked: " + ticket.toString());
    }

    public void cancelTicket(Ticket ticket) {
        // Check if the ticket exists in the list and remove it
        if (tickets.contains(ticket)) {
            tickets.remove(ticket);
            System.out.println("Ticket canceled: " + ticket.toString());
        } else {
            System.out.println("Ticket not found. Cancellation failed.");
        }
    }
}
