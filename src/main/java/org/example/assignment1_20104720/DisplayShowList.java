package org.example.assignment1_20104720;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class DisplayShowList {
    Node head = null;
    DisplayPerformanceList performanceList;
    DisplayBookingList bookingList;
    DisplayCustomerList customerList;

    //Add a specific show to the list
    public void addTheatreShow(TheatreShow TS){
        Node tsnode = new Node();
        tsnode.contents = TS;
        tsnode.nextNode=head;
        head = tsnode;
    }

    // Cancel a show and remove all related performances and bookings
    public boolean deleteTheatreShow(TheatreShow TS){
        if(head == null){
            return false;
        }

        if(head.contents.equals(TS)){
            head=head.nextNode;
        }
        else{
            Node temp=head;
            while(temp.nextNode!=null){
                if(temp.nextNode.contents.equals(TS)){
                    temp.nextNode=temp.nextNode.nextNode;
                    return true;
                }
                temp=temp.nextNode;
            }
        }
        return false;
    }

    //clears the list view, if the head of the list isn't null, it add the show to the list and moves to the next node
    public void addToListView(ListView lw){
        lw.getItems().clear();
        Node temp = head;
        while(temp!=null){
            lw.getItems().add(temp.contents);
            temp = temp.nextNode;
        }
    }

    //populates the combo box with the list view of display cases
    public void addToCombo(ComboBox lw){
        lw.getItems().clear();
        Node temp = head;
        while(temp!=null){
            lw.getItems().add(temp.contents);
            temp = temp.nextNode;
        }
    }

    public void addToPerformanceList(ObservableList observableList){
        observableList.clear();
        Node temp = head;
        while(temp!=null){
            observableList.add(temp.contents);
            temp = temp.nextNode;
        }
    }
}
