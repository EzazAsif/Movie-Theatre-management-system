public class Seat {
    private int seatNumber;
    private int row;
    boolean is_reserved;

    public Seat(int seatNumber, int row, boolean is_reserved) {
        this.seatNumber = seatNumber;
        this.row = row;
        this.is_reserved = is_reserved;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isIs_reserved() {
        return is_reserved;
    }

    public void setIs_reserved(boolean is_reserved) {
        this.is_reserved = is_reserved;
    }
    public void reserveSeat()
    {
        if(is_reserved==true)
        {
            System.out.println(row+"Row and"+seatNumber+"number sit is reservrd");
        }
        else {
            System.out.println("your sit is booked");
        }
    }
}
