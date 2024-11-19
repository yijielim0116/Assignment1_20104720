package org.example.assignment1_20104720;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class DisplayCustomerList {
    public Node head = null;

    public void addTheatreCustomer(TheatreCustomer TC){
        Node tcnode = new Node();
        tcnode.contents=TC;
        tcnode.nextNode=head;
        head=tcnode;
    }

    public void addToComboBox(ComboBox tcView){
        tcView.getItems().clear();
        Node temp = head;
        while(temp!=null){
            tcView.getItems().add(temp.contents);
            temp = temp.nextNode;
        }
    }

    public void addToListView(ListView tcView){
        tcView.getItems().clear();
        Node temp = head;
        while(temp!=null){
            tcView.getItems().add(temp.contents);
            temp = temp.nextNode;
        }
    }

    public boolean deleteTheatreCustomer(TheatreCustomer TC) {
        if (head == null) {
            return false;
        }

        if (head.contents.equals(TC)) {
            head = head.nextNode;
        } else {
            Node temp = head;
            while (temp.nextNode != null) {
                if (temp.nextNode.contents.equals(TC)) {
                    temp.nextNode = temp.nextNode.nextNode;
                    return true;
                }
                temp = temp.nextNode;
            }
        }
        return false;
    }
}
