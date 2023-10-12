package ru.belotelov.hw1.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Note implements Serializable {
    private Calendar time;
    private String content;

    public Note(String content) {
        this.time = new GregorianCalendar();
        this.content = content;
    }

    public Note(Calendar time, String content) {
        this(content);
        this.time = time;
    }

    public Date getTime() {
        return time.getTime();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return  time.getTime() + "\n"
                + content + "\n";
    }
}

