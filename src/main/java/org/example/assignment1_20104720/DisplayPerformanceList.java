package org.example.assignment1_20104720;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class DisplayPerformanceList {
    Node head = null;
    DisplayBookingList bookingList;

    public void addTheatrePerformance(TheatrePerformance TP){
        Node tpnode = new Node();
        tpnode.contents=TP;
        tpnode.nextNode=head;
        head=tpnode;
    }

    public void addToListView(ListView performanceView){
        performanceView.getItems().clear();
        Node temp = head;
        while(temp!=null){
            performanceView.getItems().add(temp.contents);
            temp = temp.nextNode;
        }
    }

    public void addToComboBox(ComboBox performanceView){
        performanceView.getItems().clear();
        Node temp = head;
        while(temp!=null){
            performanceView.getItems().add(temp.contents);
            temp = temp.nextNode;
        }
    }

    public void deleteTheatrePerformance(TheatrePerformance TP){
        if(head.contents.equals(TP)){
            head=head.nextNode;
        }
        else{
            Node temp=head;
            while(temp.nextNode!=null){
                if(temp.nextNode.contents.equals(TP)){
                    temp.nextNode=temp.nextNode.nextNode; break;}
                temp=temp.nextNode;
            }
        }
    }
}
