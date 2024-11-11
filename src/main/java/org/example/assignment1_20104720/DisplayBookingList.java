package org.example.assignment1_20104720;

import javafx.scene.control.ListView;
import java.util.HashMap;
import java.util.Map;

public class DisplayBookingList {
    Node head = null;
    private Map<String, Map<String, Boolean>> theatreMap;

    public DisplayBookingList(){
        initializeTheatreMap();
    }

    // Initialize the theatre map with sectioned seating
    private void initializeTheatreMap() {
        theatreMap = new HashMap<>();
        theatreMap.put("B", initializeSectionSeats(24, "B"));
        theatreMap.put("C", initializeSectionSeats(30, "C"));
        theatreMap.put("S", initializeSectionSeats(40, "S"));
    }

    private Map<String, Boolean> initializeSectionSeats(int numSeats, String prefix) {
        Map<String, Boolean> seats = new HashMap<>();
        for (int i = 1; i <= numSeats; i++) {
            seats.put(prefix + i, true); // true indicates the seat is available
        }
        return seats;
    }

    // Check if a specific seat is available
    public boolean isSeatAvailable(String seat) {
        String section = seat.substring(0, 1);
        return theatreMap.containsKey(section) && theatreMap.get(section).getOrDefault(seat, false);
    }

    // Book a specific seat
    public void bookSeat(String seat) {
        String section = seat.substring(0, 1);
        if (isSeatAvailable(seat)) { // Check if the seat is available
            theatreMap.get(section).put(seat, false); // Mark seat as booked
        } else {
            System.out.println("Seat " + seat + " is already booked.");
        }
    }

    public void unbookSeat(String seat) {
        String section = seat.substring(0, 1);
        if (theatreMap.containsKey(section) && !theatreMap.get(section).get(seat)) {
            theatreMap.get(section).put(seat, true); // Mark seat as available
        } else {
            System.out.println("Seat " + seat + " is already available.");
        }
    }

    // Retrieve the theatre map for display purposes
    public Map<String, Map<String, Boolean>> getTheatreMap() {
        return theatreMap;
    }

    public void addTheatreBooking(TheatreBooking TB){
        Node tbnode = new Node();
        tbnode.contents=TB;
        tbnode.nextNode=head;
        head=tbnode;
    }

    public void deleteTheatreBooking(TheatreBooking TB){
        if(head.contents.equals(TB)){
            head=head.nextNode;
        }
        else{
            Node temp=head;
            while(temp.nextNode!=null){
                if(temp.nextNode.contents.equals(TB)){
                    temp.nextNode=temp.nextNode.nextNode; break;}
                temp=temp.nextNode;
            }
        }
    }

    public void addToListView(ListView tbView){
        tbView.getItems().clear();
        Node temp = head;
        while(temp!=null){
            tbView.getItems().add(temp.contents);
            temp = temp.nextNode;
        }
    }
}
