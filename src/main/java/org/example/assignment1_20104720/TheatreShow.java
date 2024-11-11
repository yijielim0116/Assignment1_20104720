package org.example.assignment1_20104720;

public class TheatreShow {
    //Fields
    private String title;
    private int runningTime;
    private String startDate;
    private String endDate;
    private double stallPrice;
    private double circlePrice;
    private double balconyPrice;

    //Lists of Performance
    public DisplayPerformanceList performanceList = new DisplayPerformanceList();

    //Constructor
    public TheatreShow(String title, int runningTime, String startDate, String endDate, double stallPrice, double circlePrice, double balconyPrice) {
        this.title = title;
        this.runningTime = runningTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stallPrice = stallPrice;
        this.circlePrice = circlePrice;
        this.balconyPrice = balconyPrice;
    }

    //Methods
    @Override
    public String toString() {
        return "TheatreShow{" +
                "title='" + title + '\'' +
                ", runningTime=" + runningTime +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", stallPrice=" + stallPrice +
                ", circlePrice=" + circlePrice +
                ", balconyPrice=" + balconyPrice
                ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getStallPrice() {
        return stallPrice;
    }

    public void setStallPrice(double stallPrice) {
        this.stallPrice = stallPrice;
    }

    public double getCirclePrice() {
        return circlePrice;
    }

    public void setCirclePrice(double circlePrice) {
        this.circlePrice = circlePrice;
    }

    public double getBalconyPrice() {
        return balconyPrice;
    }

    public void setBalconyPrice(double balconyPrice) {
        this.balconyPrice = balconyPrice;
    }
}
