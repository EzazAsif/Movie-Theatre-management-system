class Ticket extends Movie{
    // Define properties of a ticket
    private int ticketNumber;
    private String passengerName;
    private String TicketTitle;
    public Ticket(String ticketTitle, String passengerName) {
       super(ticketTitle);

        this.passengerName = passengerName;

    }

    public Ticket(String title, int duration, String genre, int ticketNumber, String passengerName) {
        super(title, duration, genre);
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
    }

    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", passengerName='" + passengerName + '\'' +
                '}';
    }
}