package ru.anasoft.notes;

import androidx.annotation.NonNull;

import java.util.Date;

public class NoteData {

    private String name;
    private Date date;
    private String note;

    public NoteData(String name, Date date, String note) {
        this.name = name;
        this.date = date;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    @NonNull
    @Override
    public String toString() {
        return name + " (" + date + ")\n" + note;
    }

}
