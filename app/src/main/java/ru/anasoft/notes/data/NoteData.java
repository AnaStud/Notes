package ru.anasoft.notes.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class NoteData implements Parcelable {

    private Date date;
    private String name;
    private String note;

    public NoteData(Date date, String name, String note) {
        this.date = date;
        this.name = name;
        this.note = note;
    }

    protected NoteData(Parcel in) {
        name = in.readString();
        note = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(note);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NoteData> CREATOR = new Creator<NoteData>() {
        @Override
        public NoteData createFromParcel(Parcel in) {
            return new NoteData(in);
        }

        @Override
        public NoteData[] newArray(int size) {
            return new NoteData[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDate() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return df.format(date);
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
