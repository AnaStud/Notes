package ru.anasoft.notes;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class NoteData implements Parcelable {

    private String name;
    private Date date;
    private String note;

    public NoteData(String name, Date date, String note) {
        this.name = name;
        this.date = date;
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
