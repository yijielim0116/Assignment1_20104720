package org.example.assignment1_20104720;

public class TheatreBooking {
    //Fields
    private String theatreShow;
    private String theatreCustomer;
    private String bookingID;
    private String theatrePerformance;
    private String seatNumber;

    //List of performance lists
    public DisplayPerformanceList theatrePerformanceList = new DisplayPerformanceList();
    public DisplayShowList theatreShowList = new DisplayShowList();

    //Constructor
    public TheatreBooking(String theatreShow, String theatreCustomer, String bookingID, String theatrePerformance, String seatNumber) {
        this.theatreShow = theatreShow;
        this.theatreCustomer = theatreCustomer;
        this.bookingID = bookingID;
        this.theatrePerformance = theatrePerformance;
        this.seatNumber = seatNumber;

    }

    //Methods
    @Override
    public String toString() {
        return "TheatreBooking{" +
                "theatreShow='" + theatreShow + '\'' +
                ", bookingID='" + bookingID + '\'' +
                ", theatrePerformance='" + theatrePerformance + '\'' +
                ", seatNumber=" + seatNumber +
                '}';
    }

    public String getTheatreShow() {
        return theatreShow;
    }

    public void setTheatreShow(String theatreShow) {
        this.theatreShow = theatreShow;
    }

    public String getTheatreCustomer() {
        return theatreCustomer;
    }

    public void setTheatreCustomer(String theatreCustomer) {
        this.theatreCustomer = theatreCustomer;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getTheatrePerformance() {
        return theatrePerformance;
    }

    public void setTheatrePerformance(String theatrePerformance) {
        this.theatrePerformance = theatrePerformance;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
