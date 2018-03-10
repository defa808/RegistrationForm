package ua.kpi.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by Gavriliak on 14.02.2018.
 */

public class Record {

    public static List<Record> bookNotes;

    private Subscriber author;
    private String comment;
    private Date dateCreation;
    private Date dateEditing;


    public Record(Subscriber author, String comment) {
        this.author = author;
        this.comment = comment;
        this.dateCreation = new Date();
        this.dateEditing = new Date();
        bookNotes.add(this);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
        this.dateEditing = new Date();
    }

}
