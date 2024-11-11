package org.example.assignment1_20104720;

public class TheatrePerformance {
    //List of booking lists
    public DisplayBookingList theatreBookingList = new DisplayBookingList();

    //fields
    private String theatreShow;
    private String dateTime;
    private String performanceType;

    //Constructor
    public TheatrePerformance(String theatreShow, String dateTime, String performanceType) {
        this.theatreShow = theatreShow;
        this.dateTime = dateTime;
        this.performanceType = performanceType;
    }

    //Methods
    @Override
    public String toString() {
        return "TheatrePerformance{" +
                "theatreShow=" + theatreShow +
                "dateTime=" + dateTime +
                ", performanceType='" + performanceType + '\'' +
                '}';
    }

    public String getTheatreShow() {
        return theatreShow;
    }

    public void setTheatreShow(String theatreShow) {
        this.theatreShow = theatreShow;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getPerformanceType() {
        return performanceType;
    }

    public void setPerformanceType(String performanceType) {
        this.performanceType = performanceType;
    }
}
